package co.istad.mobilebanking.mapper;

import co.istad.mobilebanking.domain.Customer;
import co.istad.mobilebanking.dto.CreateCustomerRequest;
import co.istad.mobilebanking.dto.CustomerResponse;
import co.istad.mobilebanking.dto.UpdateCustomerRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse ToCustomerResponse(Customer customer);
    Customer fromCreateCustomerRequest(CreateCustomerRequest createCustomerRequest);

    //update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerPartially(
            UpdateCustomerRequest updateCustomerRequest,
            @MappingTarget Customer customer);
}
