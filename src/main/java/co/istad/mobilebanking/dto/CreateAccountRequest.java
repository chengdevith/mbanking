package co.istad.mobilebanking.dto;

import co.istad.mobilebanking.util.CurrencyUtil;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateAccountRequest(

        @NotBlank(message = "Account alias is require")
        String alias,

        @NotBlank(message = "Phon is require")
        String phoneNumber,

        CurrencyUtil currency,

        String type,

        String actNo,

        BigDecimal balance
) {
}
