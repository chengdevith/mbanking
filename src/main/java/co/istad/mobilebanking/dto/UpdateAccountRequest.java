package co.istad.mobilebanking.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record UpdateAccountRequest(

        @NotBlank(message = "Account alias is require")
        String alias,

        BigDecimal overLimit
) {
}
