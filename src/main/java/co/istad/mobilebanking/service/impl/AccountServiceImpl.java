package co.istad.mobilebanking.service.impl;

import co.istad.mobilebanking.domain.Account;
import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.dto.AccountResponse;
import co.istad.mobilebanking.dto.CreateAccountRequest;
import co.istad.mobilebanking.dto.DisableAccountRequest;
import co.istad.mobilebanking.dto.UpdateAccountRequest;
import co.istad.mobilebanking.mapper.AccountMapper;
import co.istad.mobilebanking.repository.AccountRepository;
import co.istad.mobilebanking.repository.CustomerRepository;
import co.istad.mobilebanking.repository.CustomerSegmentRepository;
import co.istad.mobilebanking.service.AccountService;
import co.istad.mobilebanking.util.Util;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountMapper accountMapper;
    private final Util util;
    private final CustomerSegmentRepository customerSegmentRepository;

    @Override
    public AccountResponse createNew(CreateAccountRequest createAccountRequest) {

        Customer customer = customerRepository
                .findByPhoneNumberAndIsDeletedFalse(createAccountRequest.phoneNumber())
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer phone number not found")
                );


        Account account = accountMapper.fromAccountRequest(createAccountRequest);
        account.setActNo(util.generateRandomActNo());
        account.setIsDeleted(false);
        account.setCustomer(customer);

        if (customer.getCustomerSegment().getSegment().equals("Gold")) {
            account.setOverLimit(BigDecimal.valueOf(50000));
        }else if (customer.getCustomerSegment().getSegment().equals("Silver")) {
            account.setOverLimit(BigDecimal.valueOf(10000));
        }else{
            account.setOverLimit(BigDecimal.valueOf(1000));
        }

        return accountMapper.toAccountResponse(account);
    }

    @Override
    public List<AccountResponse> findAll() {
        return accountMapper.toAccountResponseList(accountRepository.findAll());
    }

    @Override
    public AccountResponse findByActNo(String actNo) {

        return accountMapper.toAccountResponse(accountRepository
                .findByActNo(actNo)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found")
                ));
    }

    @Override
    public AccountResponse findByCustomer(String phoneNumber) {

        Customer customer = customerRepository
                .findByPhoneNumberAndIsDeletedFalse(phoneNumber)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found")
                );

        return accountMapper.toAccountResponse(
                accountRepository.findByCustomer(customer)
                        .orElseThrow(
                                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found")
                        ));
    }

    @Transactional
    @Override
    public void deleteByActNo(String actNo) {
        accountRepository.deleteByActNo(actNo);
    }

    @Override
    public AccountResponse updateByActNo(String actNo, UpdateAccountRequest updateAccountRequest) {

        Account account = accountRepository.findByActNo(actNo)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found")
                );

        accountMapper.toAccountPartially(updateAccountRequest, account);

        accountRepository.save(account);

        return  accountMapper.toAccountResponse(account);
    }

    @Transactional
    @Override
    public AccountResponse disableByActNo(String actNo, DisableAccountRequest disableAccountRequest) {

        Account account = accountRepository.findByActNo(actNo)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not found")
                );

        account.setIsDeleted(disableAccountRequest.isDeleted());
        accountRepository.save(account);

        return accountMapper.toAccountResponse(account);
    }

}