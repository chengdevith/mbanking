package co.istad.mobilebanking.controller;

import co.istad.mobilebanking.domain.Account;
import co.istad.mobilebanking.dto.AccountResponse;
import co.istad.mobilebanking.dto.CreateAccountRequest;
import co.istad.mobilebanking.dto.DisableAccountRequest;
import co.istad.mobilebanking.dto.UpdateAccountRequest;
import co.istad.mobilebanking.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponse createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return accountService.createNew(createAccountRequest);
    }

    @GetMapping
    public List<AccountResponse> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{actNo}")
    public AccountResponse findAccount(@PathVariable String actNo) {
        return accountService.findByActNo(actNo);
    }

    @GetMapping("/customer/{phoneNumber}")
    public AccountResponse findByCustomer(@PathVariable String phoneNumber) {
        return accountService.findByCustomer(phoneNumber);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{actNo}")
    public void deleteByActNo(@PathVariable String actNo) {
        accountService.deleteByActNo(actNo);
    }

    @PatchMapping("/{actNo}")
    public AccountResponse updateByActNo(@PathVariable String actNo,
                                         @Valid @RequestBody UpdateAccountRequest updateAccountRequest) {
        return accountService.updateByActNo(actNo, updateAccountRequest);
    }

    @PutMapping("/{actNo}")
    public AccountResponse disableByActNo(@PathVariable String actNo,
                                          @Valid @RequestBody DisableAccountRequest disableAccountRequest) {
        return accountService.disableByActNo(actNo, disableAccountRequest);
    }
}
