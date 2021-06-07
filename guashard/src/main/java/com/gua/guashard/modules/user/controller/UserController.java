package com.gua.guashard.modules.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gua.guashard.modules.user.entity.User;
import com.gua.guashard.modules.user.service.IUserService;
import com.gua.guashard.util.NickNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /**
     * 禁止翻页的分页查询
     */
    @GetMapping("/firstPage")
    public IPage<User> firstPage(Integer pageSize) {
        IPage<User> page = new Page<>(1, pageSize);
        return userService.page(page);
    }

    @GetMapping("/nextPage")
    public IPage<User> nextPage(Integer pageSize,Long lastId) {
        return userService.nextPage(pageSize,lastId);
    }


    @GetMapping("/test")
    public IPage<User> test() {
        return userService.test();
    }



    @GetMapping("/getById")
    public User getById(Long id) {
        return userService.selectOneById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        user.setUpdateTime(new Date());
        userService.save(user);
    }

    @PostMapping("/fastAdd")
    public void fastAdd() {
        fastAddOne();
    }

    private void fastAddOne() {
        User user = generateUser();
        userService.save(user);
    }

    @GetMapping("/fastAddMany")
    public void fastAddMany(Integer number) {
        for (int i = 0; i < number; i++) {
            fastAddOne();
        }
    }

    private User generateUser() {
        User user = new User();
        user.setName(NickNameUtil.generateName());
        user.setAge(27);
        user.setJob(NickNameUtil.generateName());
        user.setUpdateTime(new Date());
        return user;
    }

    @GetMapping("/fastAddBatch")
    public void fastAddBatch(Integer number) {
        for (int i = 0; i < number; i++) {
            List<User> list = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                User user = generateUser();
                list.add(user);
            }
            userService.saveBatch(list);
        }
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


