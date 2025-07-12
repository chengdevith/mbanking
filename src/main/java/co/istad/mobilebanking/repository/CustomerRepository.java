package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phone);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
