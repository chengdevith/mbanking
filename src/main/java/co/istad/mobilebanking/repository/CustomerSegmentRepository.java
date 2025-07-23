package co.istad.mobilebanking.repository;

import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.domain.CustomerSegment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerSegmentRepository extends CrudRepository<CustomerSegment, Long> {

    Optional<CustomerSegment> findCustomerSegmentBySegment(String segment);
}
