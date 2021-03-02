package com.general.support.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.general.support.sample.entity.User;
import com.general.support.sample.model.UserPage;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author John J
 * @since 2021-03-02
 */
public interface UserMapper extends BaseMapper<User> {

    UserPage selectUserPage(UserPage userPage);

}
