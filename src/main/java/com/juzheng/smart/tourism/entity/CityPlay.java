package com.juzheng.smart.tourism.entity;

import java.math.BigDecimal;
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
public class CityPlay extends Model<CityPlay> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String playId;

    private String cityId;

    private String playName;

    private String playAddress;

    private String playLevel;

    private String playPrice;

    private String playTime;

    private String playImg1;

    private String playImg2;

    private String playImg3;

    private String playImg4;

    private String playImg5;

    private String playHighlight;

    private String playIntroduction;

    private String playSpecialnote;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
