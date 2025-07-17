package co.istad.mobilebanking.util;

import co.istad.mobilebanking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class Util {

    private final AccountRepository accountRepository;

    public String generateRandomActNo() {
        String actNo;
        do{
            actNo = String.valueOf(100_000_000 + new Random().nextInt(999_999_999));
        }while (accountRepository.existsByActNo(actNo));
        return actNo;
    }
}
