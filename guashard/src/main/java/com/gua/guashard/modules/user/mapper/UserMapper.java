package com.gua.guashard.modules.user.mapper;

import com.gua.guashard.modules.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author auto-genergator
 * @since 2021-04-24
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> nextPage(@Param("pageSize") Integer pageSize, @Param("lastId") Long lastId);
    User selectOneById(@Param("id") Long id);
    List<User> selectByUpdateTime(@Param("time")Date time, @Param("pageSize")Integer pageSize);
}
