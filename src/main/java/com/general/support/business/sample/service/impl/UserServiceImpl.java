package com.general.support.business.sample.service.impl;

import com.general.support.business.sample.entity.User;
import com.general.support.business.sample.mapper.UserMapper;
import com.general.support.business.sample.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author John J
 * @since 2021-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
