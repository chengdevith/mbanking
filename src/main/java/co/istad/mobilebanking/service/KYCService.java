package co.istad.mobilebanking.service;

import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.domain.KYC;
import co.istad.mobilebanking.dto.KYCResponse;

import java.util.List;

public interface KYCService {

    void verify(String nationalCardId);

    List<KYCResponse> findAll();
}
