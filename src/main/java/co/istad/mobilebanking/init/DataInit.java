package co.istad.mobilebanking.init;

import co.istad.mobilebanking.domain.AccountType;
import co.istad.mobilebanking.domain.CustomerSegment;
import co.istad.mobilebanking.repository.AccountTypeRepository;
import co.istad.mobilebanking.repository.CustomerSegmentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    final CustomerSegmentRepository customerSegmentRepository;
    final AccountTypeRepository accountTypeRepository;

    @PostConstruct
    void init() {
        initCustomerSegment();
        initAccountType();
    }

    void initCustomerSegment() {

        if (customerSegmentRepository.count() == 0) {
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
    void initAccountType(){
        AccountType accountType = new AccountType();
        if (accountTypeRepository.count() == 0) {
            List<AccountType> accountTypeList = List.of(
                    AccountType.builder()
                            .type("Payroll")
                            .isDeleted(false)
                            .build(),
                    AccountType.builder()
                            .type("Saving")
                            .isDeleted(false)
                            .build(),
                    AccountType.builder()
                            .type("Junior")
                            .isDeleted(false)
                            .build()
            );
            accountTypeRepository.saveAll(accountTypeList);
        }
    }

}
