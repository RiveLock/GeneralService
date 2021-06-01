package com.happy.exercise.business.examination.service.impl;

import com.happy.exercise.business.examination.entity.ExaminationContent;
import com.happy.exercise.business.examination.entity.UserAnswer;
import com.happy.exercise.business.examination.mapper.UserAnswerMapper;
import com.happy.exercise.business.examination.service.ExaminationContentService;
import com.happy.exercise.business.examination.service.UserAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户回答表 服务实现类
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@Service
public class UserAnswerServiceImpl extends ServiceImpl<UserAnswerMapper, UserAnswer> implements UserAnswerService {

    @Autowired
    private ExaminationContentService examinationContentService;

    @Override
    public String choose(UserAnswer userAnswer) {
        ExaminationContent examinationContent = examinationContentService.getById(userAnswer.getAnswer());
        if (examinationContent == null) {
            throw new IllegalArgumentException("传入参数有问题");
        }

        userAnswer.setCreatedTime(LocalDateTime.now());
        this.save(userAnswer);

        return examinationContent.getAnswer();
    }
}
