package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class StartupServices implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    RequestService requestService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        for(int i=1;i<5;i++) {
            requestService.sendRequest(i);
        }

    }
}
