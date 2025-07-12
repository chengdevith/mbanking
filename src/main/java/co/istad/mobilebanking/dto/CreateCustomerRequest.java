package co.istad.mobilebanking.dto;

public record CreateCustomerRequest(
        String fullName,
        String email,
        String gender,
        String phoneNumber,
        String remark
) {
}
