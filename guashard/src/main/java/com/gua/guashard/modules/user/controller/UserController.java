package com.gua.guashard.modules.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gua.guashard.modules.user.entity.User;
import com.gua.guashard.modules.user.service.IUserService;
import com.gua.guashard.util.NickNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author auto-genergator
 * @since 2021-04-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/page")
    public IPage<User> page(Integer pageNo, Integer pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        return userService.page(page);
    }

    @GetMapping("/getById")
    public User getById(Long id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        user.setUpdateTime(new Date());
        userService.save(user);
    }

    @PostMapping("/fastAdd")
    public void fastAdd() {
        User user = new User();
        user.setName(NickNameUtil.generateName());
        user.setAge(27);
        user.setJob(NickNameUtil.generateName());
        user.setUpdateTime(new Date());
        userService.save(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        user.setUpdateTime(new Date());
        userService.updateById(user);
    }

    @GetMapping("/delete")
    public void delete(String id) {
        userService.removeById(id);
    }

    @GetMapping("/fuck")
    public String fuck() {
        return "fuck";
    }

    @PostMapping("/post")
    public String post() {
        return "post方法不行吗？";
    }
}


