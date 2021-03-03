package com.general.support.business.sample.entity;

import com.general.support.common.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author John J
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User对象", description = "")
public class User extends BaseEntity {


    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;


}
