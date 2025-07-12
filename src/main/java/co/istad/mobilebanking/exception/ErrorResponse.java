package co.istad.mobilebanking.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse<T>(
        String message,
        Integer code,
        LocalDateTime timeStamp,
        T details
) {
}
