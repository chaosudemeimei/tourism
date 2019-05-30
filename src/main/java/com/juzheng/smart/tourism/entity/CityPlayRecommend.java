package com.juzheng.smart.tourism.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CityPlayRecommend extends Model<CityPlayRecommend> {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String playRecommendId;

  private String playId;

  private String playImg;

  private String playContent;

  private String playTitle;


  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
