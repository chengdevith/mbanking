package co.istad.mobilebanking.dto;

public record UpdateCustomerRequest(
        String fullName,
        String gender,
        String remark
) {
}
