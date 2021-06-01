package com.happy.exercise.business.examination.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.happy.exercise.common.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 考题内容表
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ExaminationContent对象", description = "考题内容表")
public class ExaminationContent extends BaseEntity {

    @ApiModelProperty(value = "考题id")
    @TableField("examinationId")
    private Integer examinationId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "答案")
    private String answer;

}
