package co.istad.mobilebanking.dto;

import co.istad.mobilebanking.util.CurrencyUtil;

import java.math.BigDecimal;

public record AccountResponse(
         String alias,
         String actNo,
         CurrencyUtil currency,
         BigDecimal balance,
         BigDecimal overLimit,
         Boolean isDeleted
) {
}
