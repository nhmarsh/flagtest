package com.nhmarsh.flagtest;

import com.launchdarkly.client.LDClient;
import com.nhmarsh.flagtest.entity.FeatureFlag;
import com.nhmarsh.flagtest.repository.FlagRepository;
import com.nhmarsh.flagtest.service.SpringInjectionTestService;
import com.nhmarsh.flagtest.service.impl.SpringInjectionTestServiceImplV1;
import com.nhmarsh.flagtest.service.impl.SpringInjectionTestServiceImplV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.nhmarsh.flagtest.entity.FeatureFlag.NO_FLAG_VALUE;

@Configuration
public class FlagTestBeanConfiguration {

    @Autowired
    private FlagRepository flagRepository;

    @Bean
    public SpringInjectionTestService springInjectionTestService() {
        FeatureFlag whichService = flagRepository.findById("which_injected_service").orElse(FeatureFlag.builder().flagValue(NO_FLAG_VALUE).build());
        if(!NO_FLAG_VALUE.equals(whichService.getFlagValue())) {
            switch(whichService.getFlagValue()) {
                case "1":
                    return new SpringInjectionTestServiceImplV1();
                case "2":
                    return new SpringInjectionTestServiceImplV2();
            }
        }
        System.out.println("ERROR: NO INJECTION VALUE FOUND");
        return null;
    }

    @Bean
    public LDClient ldClient() {
        LDClient ldClient = new LDClient("sdk-65d4d604-439d-4dd3-bea8-4d76473a58d6");
        return ldClient;
    }
}
