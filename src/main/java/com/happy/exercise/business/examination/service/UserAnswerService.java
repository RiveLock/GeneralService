package com.happy.exercise.business.examination.service;

import com.happy.exercise.business.examination.entity.UserAnswer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户回答表 服务类
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
public interface UserAnswerService extends IService<UserAnswer> {

    String choose(UserAnswer userAnswer);
}
