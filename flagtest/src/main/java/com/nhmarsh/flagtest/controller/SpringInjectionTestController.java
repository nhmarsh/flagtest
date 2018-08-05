package com.nhmarsh.flagtest.controller;

import com.nhmarsh.flagtest.service.SpringInjectionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/injectiontest")
public class SpringInjectionTestController {

    private final SpringInjectionTestService springInjectionTestService;

    @Autowired
    public SpringInjectionTestController(SpringInjectionTestService springInjectionTestService) {
        this.springInjectionTestService = springInjectionTestService;
    }

    @GetMapping
    public ResponseEntity<String> getTheValue() {
        return ResponseEntity.ok(springInjectionTestService.testInjection());
    }


}
