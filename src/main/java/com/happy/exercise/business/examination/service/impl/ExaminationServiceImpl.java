package com.happy.exercise.business.examination.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.happy.exercise.business.examination.entity.Examination;
import com.happy.exercise.business.examination.entity.ExaminationContent;
import com.happy.exercise.business.examination.entity.dto.QuestionAddDTO;
import com.happy.exercise.business.examination.mapper.ExaminationMapper;
import com.happy.exercise.business.examination.service.ExaminationContentService;
import com.happy.exercise.business.examination.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 考题表 服务实现类
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@Service
public class ExaminationServiceImpl extends ServiceImpl<ExaminationMapper, Examination> implements ExaminationService {

    @Autowired
    private ExaminationContentService examinationContentService;

    @Autowired
    private ExaminationService examinationService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(QuestionAddDTO dto) {
        Examination examination = new Examination();
        examination.setQuestion(dto.getQuestion());
        examination.setType(dto.getType());
        examination.setCreatedTime(LocalDateTime.now());
        examinationService.save(examination);

        for (ExaminationContent examinationContent : dto.getExaminationContentList()) {
            examinationContent.setExaminationId(examination.getId());
            examinationContent.setCreatedTime(LocalDateTime.now());
        }
        examinationContentService.saveBatch(dto.getExaminationContentList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        examinationService.removeById(id);
        examinationContentService.remove(new LambdaQueryWrapper<ExaminationContent>().eq(ExaminationContent::getExaminationId, id));
    }

    @Override
    public void questionMotify(Examination examination) {
        if (examinationService.getById(examination.getId()) == null) {
            throw new IllegalArgumentException("该考题不存在，id：" + examination.getId());
        }

        examinationService.updateById(examination);
    }

    @Override
    public List<Examination> all() {
       List<Examination> examinationList = examinationService.list();
       for (Examination examination : examinationList) {
           List<ExaminationContent> examinationContentList =  examinationContentService.list(new LambdaQueryWrapper<ExaminationContent>().eq(ExaminationContent::getExaminationId, examination.getId()));
           examination.setExaminationContentList(examinationContentList);
       }
       return examinationList;
    }
}
