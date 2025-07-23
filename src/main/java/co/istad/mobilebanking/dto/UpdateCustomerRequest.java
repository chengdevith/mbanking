package co.istad.mobilebanking.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCustomerRequest(

        String fullName,
        String gender,
        String remark
) {
}
