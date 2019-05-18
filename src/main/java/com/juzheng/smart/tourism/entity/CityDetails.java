package com.juzheng.smart.tourism.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CityDetails extends Model<CityDetails>{

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String detailsId;

  private String cityId;

  private String detailsBrief;

  private String detailsContent;

  private String detailsImg1;

  private String detailsImg2;

  private String detailsImg3;

  private String detailsImg4;

  private String detailsImg5;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
