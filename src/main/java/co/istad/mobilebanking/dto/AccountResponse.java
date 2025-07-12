package co.istad.mobilebanking.dto;

import co.istad.mobilebanking.domain.AccountType;

import java.math.BigDecimal;

public record AccountResponse(
         String alias,
         String actNo,
         BigDecimal balance,
         BigDecimal overLimit,
         Boolean isDeleted
) {
}
