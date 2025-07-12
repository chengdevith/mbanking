package co.istad.mobilebanking.dto;

import java.math.BigDecimal;

public record UpdateAccountRequest(
        String alias,
        BigDecimal overLimit
) {
}
