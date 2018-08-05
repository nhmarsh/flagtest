package com.nhmarsh.flagtest.factory;

import com.nhmarsh.flagtest.entity.FeatureFlag;
import com.nhmarsh.flagtest.repository.FlagRepository;
import com.nhmarsh.flagtest.service.SpringInjectionTestService;
import com.nhmarsh.flagtest.service.impl.SpringInjectionTestServiceImplV1;
import com.nhmarsh.flagtest.service.impl.SpringInjectionTestServiceImplV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.nhmarsh.flagtest.entity.FeatureFlag.NO_FLAG_VALUE;

@Component
public class SpringTestServiceFactory {

    private final SpringInjectionTestServiceImplV1 v1;
    private final SpringInjectionTestServiceImplV2 v2;
    private final FlagRepository flagRepository;

    @Autowired
    public SpringTestServiceFactory(FlagRepository flagRepository) {
        this.flagRepository = flagRepository;
        v1 = new SpringInjectionTestServiceImplV1();
        v2 = new SpringInjectionTestServiceImplV2();
    }

    public SpringInjectionTestService getTestService() {
        FeatureFlag whichService = flagRepository.findById("which_service_version").orElse(FeatureFlag.builder().flagValue(NO_FLAG_VALUE).build());
        if(!NO_FLAG_VALUE.equals(whichService.getFlagValue())) {
            switch(whichService.getFlagValue()) {
                case "1":
                    return v1;
                case "2":
                    return v2;
            }
        }
        System.out.println("ERROR: NO INJECTION VALUE FOUND");
        return null;
    }
}
