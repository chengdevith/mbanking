package co.istad.mobilebanking.service.impl;

import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.domain.CustomerSegment;
import co.istad.mobilebanking.domain.KYC;
import co.istad.mobilebanking.dto.CreateCustomerRequest;
import co.istad.mobilebanking.dto.CustomerResponse;
import co.istad.mobilebanking.dto.UpdateCustomerRequest;
import co.istad.mobilebanking.mapper.CustomerMapper;
import co.istad.mobilebanking.repository.CustomerRepository;
import co.istad.mobilebanking.repository.CustomerSegmentRepository;
import co.istad.mobilebanking.repository.KYCRepository;
import co.istad.mobilebanking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerSegmentRepository customerSegmentRepository;
    private final KYCRepository kycRepository;

    @Override
    public CustomerResponse createNew(CreateCustomerRequest createCustomerRequest) {

        if(kycRepository.existsByNationalCardId(createCustomerRequest.nationalCardId())){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "National card already exists");
        }

        CustomerSegment customerSegment = customerSegmentRepository.findCustomerSegmentBySegment(
                createCustomerRequest.segmentType()
        ).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "segment not found")
        );

        if (customerRepository.existsByEmail(createCustomerRequest.email())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Email already exists"
            );
        }

        if (customerRepository.existsByPhoneNumber(createCustomerRequest.phoneNumber())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Phone Number already exists"
            );
        }

        Customer customer = customerMapper.fromCreateCustomerRequest(createCustomerRequest);
        customer.setIsDeleted(false);
        customer.setCustomerSegment(customerSegment);

        KYC kyc = KYC.builder()
                .nationalCardId(createCustomerRequest.nationalCardId())
                .isVerified(false)
                .isDeleted(false)
                .customer(customer)
                .build();

        customer.setKyc(kyc);

        customerRepository.save(customer);
        return customerMapper.ToCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> findAll() {

        List<Customer> customers = customerRepository.findAllByIsDeletedFalse();

        return customers.stream().map(customerMapper::ToCustomerResponse).toList();
    }

    @Override
    public CustomerResponse findByPhoneNumber(String phoneNumber) {

        return customerRepository.findByPhoneNumberAndIsDeletedFalse(phoneNumber)
                .map(customerMapper::ToCustomerResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone number not found")
                );
    }

    @Override
    public CustomerResponse updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository
                .findByPhoneNumberAndIsDeletedFalse(phoneNumber)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer phone number not found")
                );

        customerMapper.toCustomerPartially(
                updateCustomerRequest,
                customer
        );

        customerRepository.save(customer);

        return customerMapper.ToCustomerResponse(customer);
    }

    @Transactional
    @Override
    public void disableByPhoneNumber(String phoneNumber) {

        if (!customerRepository.existsByPhoneNumber(phoneNumber)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Customer phone number not found"
            );
        }

        customerRepository.disableByPhoneNumber(phoneNumber);

    }

}
