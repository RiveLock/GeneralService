package com.happy.exercise.business.examination.service;

import com.happy.exercise.business.examination.entity.Examination;
import com.baomidou.mybatisplus.extension.service.IService;
import com.happy.exercise.business.examination.entity.dto.QuestionAddDTO;

import java.util.List;

/**
 * <p>
 * 考题表 服务类
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
public interface ExaminationService extends IService<Examination> {

    void add(QuestionAddDTO dto);

    void delete(Integer id);

    void questionMotify(Examination examination);

    List<Examination> all();
}
