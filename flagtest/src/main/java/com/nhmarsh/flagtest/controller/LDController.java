package com.nhmarsh.flagtest.controller;

import com.nhmarsh.flagtest.service.LDTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ldtest")
public class LDController {

    private final LDTestService testService;

    @Autowired
    public LDController(LDTestService testService) {
        this.testService = testService;
    }

    @GetMapping("/{user}")
    public @ResponseBody String launchDarklyTest(@PathVariable String user) {
        return testService.testLD(user);
    }

}
