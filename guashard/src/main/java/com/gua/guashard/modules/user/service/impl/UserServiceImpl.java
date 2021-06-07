package com.gua.guashard.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gua.guashard.modules.user.entity.User;
import com.gua.guashard.modules.user.mapper.UserMapper;
import com.gua.guashard.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2021-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> nextPage(Integer pageSize, Long lastId) {
        List<User> list = userMapper.nextPage(pageSize,lastId);
        IPage<User> page = new Page<>();
        page.setSize(pageSize);
        page.setRecords(list);
        return page;
    }

    @Override
    public User selectOneById(Long id) {
        return userMapper.selectOneById(id);
    }

    @Override
    public IPage<User> test() {
        Integer pageSize = 10;
        Date now = new Date();
        List<User> list = userMapper.selectByUpdateTime(now,pageSize);
        IPage<User> page = new Page<>();
        page.setSize(pageSize);
        page.setRecords(list);
        return page;
    }
}
