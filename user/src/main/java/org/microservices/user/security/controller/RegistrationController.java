package org.microservices.user.security.controller;

import org.microservices.user.security.DTO.RegistrationRequest;
import org.microservices.user.service.registration.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/auth/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody @Valid RegistrationRequest request) {
        registrationService.register(request);
        return ResponseEntity.status(201).build();
    }
}
