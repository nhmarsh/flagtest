package com.nhmarsh.flagtest.service.impl;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;
import com.nhmarsh.flagtest.service.LDTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LDTestServiceImpl implements LDTestService {

    private final LDClient ldClient;

    @Autowired
    public LDTestServiceImpl(LDClient ldClient) {
        this.ldClient = ldClient;
    }

    @Override
    public String testLD(String user) {
        LDUser ldUser = new LDUser.Builder(user)
                .build();

        boolean showFeature = ldClient.boolVariation("flagtest", ldUser, false);

        if(showFeature) {
            return "Enabled for user " + user;
        } else {
            return "Disabled for user " + user;
        }
    }
}
