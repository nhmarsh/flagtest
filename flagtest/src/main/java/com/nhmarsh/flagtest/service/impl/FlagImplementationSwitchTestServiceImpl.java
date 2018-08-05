package com.nhmarsh.flagtest.service.impl;

import com.nhmarsh.flagtest.entity.FeatureFlag;
import com.nhmarsh.flagtest.repository.FlagRepository;
import com.nhmarsh.flagtest.service.FlagImplementationSwichTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.nhmarsh.flagtest.entity.FeatureFlag.NO_FLAG_VALUE;

@Component
public class FlagImplementationSwitchTestServiceImpl implements FlagImplementationSwichTestService {

    private final FlagRepository flagRepository;

    @Autowired
    public FlagImplementationSwitchTestServiceImpl(FlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    @Override
    public String getTheValue() {
        FeatureFlag valueSwitch = flagRepository.findById("which_code_path")
                .orElse(FeatureFlag.builder().flagValue(NO_FLAG_VALUE).build());

        if(!NO_FLAG_VALUE.equals(valueSwitch.getFlagValue())) {
            switch(valueSwitch.getFlagValue()) {
                case "1":
                    return "Version A of this feature";
                case "2":
                    return "Version B of this feature";
            }
        }
        return "No implementation of this feature";

    }
}
