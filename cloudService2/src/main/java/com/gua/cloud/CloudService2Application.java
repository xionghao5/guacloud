package com.gua.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
public class CloudService2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudService2Application.class, args);
    }

    @Bean
    @LoadBalanced        // 开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
