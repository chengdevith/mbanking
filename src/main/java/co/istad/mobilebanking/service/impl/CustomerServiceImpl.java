package co.istad.mobilebanking.service.impl;

import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.dto.CreateCustomerRequest;
import co.istad.mobilebanking.dto.CustomerResponse;
import co.istad.mobilebanking.dto.UpdateCustomerRequest;
import co.istad.mobilebanking.mapper.CustomerMapper;
import co.istad.mobilebanking.repository.CustomerRepository;
import co.istad.mobilebanking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse createNew(CreateCustomerRequest createCustomerRequest) {

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

        log.info("Customer before save: {}", customer.getId());

        customerRepository.save(customer);

        log.info("Customer after save: {}", customer.getId());

        return customerMapper.ToCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> findAll() {

        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customerMapper::ToCustomerResponse).toList();
    }

    @Override
    public CustomerResponse findByPhoneNumber(String phoneNumber) {

        return customerRepository.findByPhoneNumber(phoneNumber)
                .map(customerMapper::ToCustomerResponse)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Phone number not found")
                );
    }

    @Override
    public CustomerResponse updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer phone number not found")
                );

        customerMapper.toCustomerPartially(
                updateCustomerRequest,
                customer
        );

        customerRepository.save(customer);

        return customerMapper.ToCustomerResponse(customer);
    }
}
