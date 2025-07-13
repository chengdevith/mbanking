package co.istad.mobilebanking.dto;

import java.math.BigDecimal;

public record AccountResponse(
         String alias,
         String actNo,
         BigDecimal balance,
         BigDecimal overLimit,
         Boolean isDeleted
) {
}
