package com.example.consent.src.controller;

import com.example.consent.src.model.CTaskResponse;
import com.example.consent.src.model.ConsentRequest;
import com.example.consent.src.service.ConsentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/consent")
public class ConsentController {
    @Autowired
    ConsentInfoService consentInfoService;
    @GetMapping
    public ResponseEntity<CTaskResponse> getCTaskDetails(@RequestParam String cTask) {
        // Get the details from db based on the ctask and return the details.
        return ResponseEntity.ok(consentInfoService.getCTaskDetails(cTask));
    }

    @PostMapping(value = "/set")
    public ResponseEntity<String> setConsent(@RequestBody ConsentRequest consentRequest) {
        return ResponseEntity.ok(consentInfoService.setConsentForCTask(consentRequest));
    }
}
