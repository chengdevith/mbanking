package co.istad.mobilebanking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequest(

        @NotBlank(message = "Name is require")
        String fullName,

        @NotBlank(message = "Email is require")
        @Email
        String email,

        @NotBlank(message = "Gender is require")
        String gender,

        @NotBlank(message = "Phone Number is require")
        @Min(value = 5,message = "Invalid Phone Number")
        @Max(value = 15,message = "Invalid Phone Number")
        String phoneNumber,

        String remark
) {
}
