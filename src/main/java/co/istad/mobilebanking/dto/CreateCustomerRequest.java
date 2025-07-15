package co.istad.mobilebanking.dto;

import jakarta.validation.constraints.*;

public record CreateCustomerRequest(

        @NotBlank(message = "Name is require")
        String fullName,

        @NotBlank(message = "Email is require")
        @Email
        String email,

        @NotBlank(message = "Gender is require")
        String gender,

        @NotBlank(message = "Phone Number is require")
        @Size(min = 5, max = 15, message = "Invalid Phone Number")
        String phoneNumber,

        String remark,

        @NotBlank(message = "segmentType is require")
        String segmentType,

        @NotBlank(message = "national card id is require")
        String nationalCardId
) {
}
