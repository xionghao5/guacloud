package com.gua.guashard.modules.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gua.guashard.modules.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2021-04-24
 */
public interface IUserService extends IService<User> {

    IPage<User> nextPage(Integer pageSize, Long lastId);

    User selectOneById(Long id);

    IPage<User> test();
}
