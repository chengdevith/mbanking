package co.istad.mobilebanking.service;

import co.istad.mobilebanking.dto.CreateCustomerRequest;
import co.istad.mobilebanking.dto.CustomerResponse;
import co.istad.mobilebanking.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {
    CustomerResponse createNew(CreateCustomerRequest createCustomerRequest);
    List<CustomerResponse> findAll();
    CustomerResponse findByPhoneNumber(String phoneNumber);
    CustomerResponse updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest);
    void disableByPhoneNumber(String phoneNumber);
}
