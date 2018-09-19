package com.nhmarsh.flagtest.controller;

import com.nhmarsh.flagtest.service.LDTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ldtest")
public class LaunchDarklyTestController {

    private final LDTestService ldTestService;

    @Autowired
    public LaunchDarklyTestController(LDTestService ldTestService) {
        this.ldTestService = ldTestService;
    }

    @GetMapping("/{username}")
    public String testLd(@PathVariable("username") String username) {
        return ldTestService.ldTest(username);
    }
}
