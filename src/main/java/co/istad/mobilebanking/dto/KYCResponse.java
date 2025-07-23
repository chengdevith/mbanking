package co.istad.mobilebanking.dto;

import jakarta.persistence.Column;

public record KYCResponse(
        String nationalCardId,
        Boolean isVerified,
        Boolean isDeleted
) {
}
