package com.carl.study.springcloud.zuul;

import com.carl.study.springcloud.zuul.filter.AccessPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
//@EnableDiscoveryClient
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        System.out.println("eureka zuul start...");
    }

    @Bean
    public AccessPreFilter accessFilter(){
        return new AccessPreFilter();
    }

}
