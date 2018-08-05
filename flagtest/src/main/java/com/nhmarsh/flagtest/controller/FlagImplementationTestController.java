package com.nhmarsh.flagtest.controller;

import com.nhmarsh.flagtest.factory.SpringTestServiceFactory;
import com.nhmarsh.flagtest.service.FlagImplementationSwichTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flagimplementation")
public class FlagImplementationTestController {
    private final FlagImplementationSwichTestService flagImplementationSwichTestService;
    private final SpringTestServiceFactory springTestServiceFactory;
    @Autowired
    public FlagImplementationTestController(FlagImplementationSwichTestService flagImplementationSwichTestService, SpringTestServiceFactory springTestServiceFactory) {
        this.flagImplementationSwichTestService = flagImplementationSwichTestService;
        this.springTestServiceFactory = springTestServiceFactory;
    }

    @GetMapping
    public ResponseEntity<String> testBasicFlags() {
        return ResponseEntity.ok(flagImplementationSwichTestService.getTheValue());
    }

    @GetMapping
    @RequestMapping("/factorypattern")
    public ResponseEntity<String> testFactory() {
        return ResponseEntity.ok(springTestServiceFactory.getTestService().testInjection());
    }
}
