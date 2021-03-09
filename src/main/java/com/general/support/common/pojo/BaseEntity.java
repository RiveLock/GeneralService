/**
 * BaseEntity
 * @description
 * @author jixinshi
 * @date 2021/3/1 3:47 PM
 * @version 2.11.2
 */
package com.general.support.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 * @description
 * @author jixinshi
 * @date 2021/3/1 3:47 PM
 * @version 2.11.2
 */
@Data
public class BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
