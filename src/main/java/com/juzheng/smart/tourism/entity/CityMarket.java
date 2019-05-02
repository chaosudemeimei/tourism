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
public class CityMarket extends Model<CityMarket> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer marketId;

    private String marketScore;

    private String marketContent;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
