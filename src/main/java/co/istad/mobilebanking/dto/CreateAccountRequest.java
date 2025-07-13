package co.istad.mobilebanking.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateAccountRequest(

        @NotBlank(message = "Account alias is require")
        String alias,

        @NotBlank(message = "Phon is require")
        String phoneNumber,

        @NotBlank(message = "Balance is require")
        @Min(value = 5L,message = "Balance must be greater than $5")
        BigDecimal balance,

        BigDecimal overLimit
) {
}
