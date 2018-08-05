package com.nhmarsh.flagtest.service.impl;

import com.nhmarsh.flagtest.service.SpringInjectionTestService;

public class SpringInjectionTestServiceImplV1 implements SpringInjectionTestService {
    @Override
    public String testInjection() {
        return "Version A of this feature";
    }
}
