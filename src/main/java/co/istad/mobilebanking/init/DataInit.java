package co.istad.mobilebanking.init;

import co.istad.mobilebanking.domain.CustomerSegment;
import co.istad.mobilebanking.repository.CustomerSegmentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    final CustomerSegmentRepository customerSegmentRepository;

    @PostConstruct
    void init() {
        initCustomerSegment();
    }

    void initCustomerSegment() {
        List<CustomerSegment> customerSegment = List.of(
                CustomerSegment
                        .builder()
                        .segment("Gold")
                        .description("Over limit 50000")
                        .isDeleted(false)
                        .build(),
                CustomerSegment
                        .builder()
                        .segment("Silver")
                        .description("Over limit 10000")
                        .isDeleted(false)
                        .build(),
                CustomerSegment
                        .builder()
                        .segment("Regular")
                        .description("Over limit 5000")
                        .isDeleted(false)
                        .build()
        );
        customerSegmentRepository.saveAll(customerSegment);
    }

}
