/**
 * QuestionAddDTO
 * @description
 * @author jixinshi
 * @date 2021/6/1 11:21 AM
 * @version 3.2.2
 */
package com.happy.exercise.business.examination.entity.dto;

import com.google.common.collect.Lists;
import com.happy.exercise.business.examination.entity.ExaminationContent;
import lombok.Data;

import java.util.List;

/**
 * QuestionAddDTO
 * @description
 * @author jixinshi
 * @date 2021/6/1 11:21 AM
 * @version 3.2.2
 */
@Data
public class QuestionAddDTO {

    private String question;

    private Integer type;

    private List<ExaminationContent> examinationContentList = Lists.newArrayList();
}
