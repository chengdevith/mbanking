package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.KYC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KYCRepository extends JpaRepository<KYC, String> {

    boolean existsByNationalCardId(String nationalCardId);

    Optional<KYC> findByNationalCardId(String nationalCardId);

}
