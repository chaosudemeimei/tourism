package com.juzheng.smart.tourism.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author juzheng
 * @since 2019-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CityComment extends Model<CityComment> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String commentId;

    private String commentScore;

    private String commentContent;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
