package com.gua.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/service2")
    @HystrixCommand(fallbackMethod = "testError")
    public String service1() {
        return restTemplate.getForObject("http://cloudService1/service1",String.class);
    }

    public String testError(){
        return "服务维护中...";
    }
}