package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.AccountType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountTypeRepository extends CrudRepository<AccountType, Long> {

    Optional<AccountType> findByType(String type);

}
