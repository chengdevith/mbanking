package co.istad.mobilebanking.controller;

import co.istad.mobilebanking.domain.KYC;
import co.istad.mobilebanking.dto.KYCResponse;
import co.istad.mobilebanking.service.KYCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kycs")
@RequiredArgsConstructor
public class KYCController {

    private final KYCService kycService;

    @PostMapping("/{nationalCardId}")
    public void verify(@PathVariable String nationalCardId) {
        kycService.verify(nationalCardId);
    }

    @GetMapping
    public List<KYCResponse> findAll() {
        return kycService.findAll();
    }

}
