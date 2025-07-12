package co.istad.mobilebanking.mapper;

import co.istad.mobilebanking.domain.Account;
import co.istad.mobilebanking.dto.AccountResponse;
import co.istad.mobilebanking.dto.CreateAccountRequest;
import co.istad.mobilebanking.dto.DisableAccountRequest;
import co.istad.mobilebanking.dto.UpdateAccountRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account fromAccountRequest(CreateAccountRequest createAccountRequest);
    AccountResponse toAccountResponse(Account account);
    List<AccountResponse> toAccountResponseList(List<Account> accounts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toAccountPartially(
            UpdateAccountRequest updateAccountRequest,
            @MappingTarget Account account);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void toDisableAccountPartially(
//            DisableAccountRequest disableAccountRequest,
//            @MappingTarget Account account
//    );
}
