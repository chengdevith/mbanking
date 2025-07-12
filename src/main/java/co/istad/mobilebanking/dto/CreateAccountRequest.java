package co.istad.mobilebanking.dto;

import java.math.BigDecimal;

public record CreateAccountRequest(
        String alias,
        String phoneNumber,
        BigDecimal balance,
        BigDecimal overLimit
) {
}
