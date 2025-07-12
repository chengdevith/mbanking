package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.KYC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KYCRepository extends JpaRepository<KYC, String> {
}
