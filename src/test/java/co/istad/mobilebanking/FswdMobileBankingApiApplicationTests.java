package co.istad.mobilebanking;

import co.istad.mobilebanking.repository.CustomerSegmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FswdMobileBankingApiApplicationTests {

    @Autowired
    private CustomerSegmentRepository customerSegmentRepository;

    @Test
    void testFetchType(){
        customerSegmentRepository.findAll().forEach(customer -> System.out.println(customer.getCustomers()));
    }

}
