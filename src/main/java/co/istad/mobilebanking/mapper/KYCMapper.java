package co.istad.mobilebanking.mapper;

import co.istad.mobilebanking.domain.KYC;
import co.istad.mobilebanking.dto.KYCResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KYCMapper {

    List<KYCResponse> fromKYCtoKYCResponseList(List<KYC> kyc);
}
