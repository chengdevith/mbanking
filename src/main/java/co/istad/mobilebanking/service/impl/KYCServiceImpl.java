package co.istad.mobilebanking.service.impl;

import co.istad.mobilebanking.domain.KYC;
import co.istad.mobilebanking.repository.KYCRepository;
import co.istad.mobilebanking.service.KYCService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class KYCServiceImpl implements KYCService {

    private final KYCRepository kycRepository;

    @Override
    public void verify(String nationalCardId) {

        boolean isExist = kycRepository.existsByNationalCardId(nationalCardId);

        KYC kyc = kycRepository.findByNationalCardId(nationalCardId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "National Card Not Found")
        );

        kyc.setIsVerified(true);

        kycRepository.save(kyc);

    }
}
