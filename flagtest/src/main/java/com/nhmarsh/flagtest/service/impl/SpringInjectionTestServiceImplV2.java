package com.nhmarsh.flagtest.service.impl;

import com.nhmarsh.flagtest.service.SpringInjectionTestService;

public class SpringInjectionTestServiceImplV2 implements SpringInjectionTestService {
    @Override
    public String testInjection() {
        return "Version B of this feature";
    }
}
