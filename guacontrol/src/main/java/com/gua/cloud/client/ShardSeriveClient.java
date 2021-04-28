package com.gua.cloud.client;

import com.gua.cloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "guashard")
public interface ShardSeriveClient {

    @GetMapping("/user/fuck")
    String fuck();

    @GetMapping("/user/getById")
        // 添加@RequestParam ,纠正参数映射，否则报405
    User getById(@RequestParam("id") Long id);

    @PostMapping("/user/fastAdd")
    void fastAdd();

    @GetMapping("/user/page")
    Object page(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);
}
