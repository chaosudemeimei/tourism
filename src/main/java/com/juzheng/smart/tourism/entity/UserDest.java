package com.juzheng.smart.tourism.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author juzheng
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDest extends Model<UserDest> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String cityId;

    private Integer frequency;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
