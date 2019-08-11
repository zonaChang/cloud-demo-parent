package com.carl.study.cloud.eurekaregistercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterCenterApplication.class, args);
        System.out.println("register center start...");
    }

}
