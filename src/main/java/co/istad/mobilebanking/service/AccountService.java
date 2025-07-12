package co.istad.mobilebanking.service;

import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.dto.AccountResponse;
import co.istad.mobilebanking.dto.CreateAccountRequest;
import co.istad.mobilebanking.dto.DisableAccountRequest;
import co.istad.mobilebanking.dto.UpdateAccountRequest;

import java.util.List;

public interface AccountService {
    AccountResponse createNew(CreateAccountRequest createAccountRequest);
    List<AccountResponse> findAll();
    AccountResponse findByActNo(String actNo);
    AccountResponse findByCustomer(String phoneNumber);
    void deleteByActNo(String actNo);
    AccountResponse updateByActNo(String actNo, UpdateAccountRequest updateAccountRequest);
    AccountResponse disableByActNo(String actNo, DisableAccountRequest disableAccountRequest);
}
