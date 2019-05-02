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
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
public class City extends Model<City> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String cityId;

    private String provinceId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
