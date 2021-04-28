package com.gua.cloud.controller;

import com.gua.cloud.client.ShardSeriveClient;
import com.gua.cloud.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HomeController {
    @Resource
    private ShardSeriveClient shardSeriveClient;

    @GetMapping("/getById")
    public User getById(Long id) {
        return shardSeriveClient.getById(id);
    }

    @PostMapping("/fastAdd")
    public String fastAdd() {
        shardSeriveClient.fastAdd();
        return "fastAdd";
    }

    @GetMapping("/page")
    public Object page(Integer pageNo, Integer pageSize) {
        return shardSeriveClient.page(pageNo,pageSize);
    }

}