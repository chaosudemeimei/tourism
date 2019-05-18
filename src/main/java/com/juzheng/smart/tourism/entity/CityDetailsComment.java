package com.juzheng.smart.tourism.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class CityDetailsComment extends Model<CityDetailsComment>{
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String detailsId;

  private String commentId;

  private String creatime;

  private String content;

  private Integer score;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
