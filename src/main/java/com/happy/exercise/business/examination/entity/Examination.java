package com.happy.exercise.business.examination.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.happy.exercise.common.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 考题表
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Examination对象", description = "考题表")
public class Examination extends BaseEntity {


    @ApiModelProperty(value = "问题")
    private String question;


    @ApiModelProperty(value = "题目种类")
    private Integer type;


    @TableField(exist = false)
    private List<ExaminationContent> examinationContentList;

}
