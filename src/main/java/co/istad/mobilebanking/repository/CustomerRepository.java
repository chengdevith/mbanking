package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phone);

    Optional<Customer> findByPhoneNumberAndIsDeletedFalse(String phoneNumber);

    @Modifying
    @Query(value = """
            UPDATE Customer c
            SET c.isDeleted = TRUE
            WHERE c.phoneNumber= ?1
            """)
    void disableByPhoneNumber(String phoneNumber);

    List<Customer> findAllByIsDeletedFalse();

}
