package com.happy.exercise.business.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happy.exercise.business.sample.entity.User;
import com.happy.exercise.business.sample.entity.dto.UserPage;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author John J
 * @since 2021-03-03
 */
public interface UserMapper extends BaseMapper<User> {

    UserPage selectUserPage(UserPage userPage);

}
