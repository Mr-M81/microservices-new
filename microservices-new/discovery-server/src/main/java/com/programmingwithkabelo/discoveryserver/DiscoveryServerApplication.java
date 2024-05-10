package com.programmingwithkabelo.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //this is how to use your discovery server.
public class DiscoveryServerApplication {
    public static void main(String[] args){
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }

}
