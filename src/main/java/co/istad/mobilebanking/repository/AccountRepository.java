package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.Account;
import co.istad.mobilebanking.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByActNo(String actNo);

    Optional<Account> findByCustomer(Customer customer);

    void deleteByActNo(String actNo);

    boolean existsByActNo(String actNo);
}