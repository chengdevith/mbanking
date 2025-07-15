package co.istad.mobilebanking.service;

import co.istad.mobilebanking.domain.Customer;

public interface KYCService {

    void verify(String nationalCardId);

}
