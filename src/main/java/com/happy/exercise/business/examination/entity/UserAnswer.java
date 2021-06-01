package com.happy.exercise.business.examination.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.happy.exercise.common.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户回答表
 * </p>
 *
 * @author John J
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserAnswer对象", description = "用户回答表")
public class UserAnswer extends BaseEntity {


    @ApiModelProperty(value = "考题id")
    @TableField("examinationId")
    private Integer examinationId;

    @ApiModelProperty(value = "用户回答")
    private Integer answer;

}
