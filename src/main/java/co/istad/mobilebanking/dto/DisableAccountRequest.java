package co.istad.mobilebanking.dto;

import jakarta.validation.constraints.NotBlank;

public record DisableAccountRequest(

        @NotBlank(message = "IsDeleted is require")
        Boolean isDeleted
) {
}
