package co.istad.mobilebanking.controller;

import co.istad.mobilebanking.service.KYCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kycs")
@RequiredArgsConstructor
public class KYCController {

    private final KYCService kycService;

    @PostMapping("/{nationalCardId}")
    public void verify(@PathVariable String nationalCardId) {
        kycService.verify(nationalCardId);
    }

}
