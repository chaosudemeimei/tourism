package com.juzheng.smart.tourism.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CityPlayComment extends Model<CityPlayComment> {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String commentId;

  private String playId;

  private String userId;

  private String creatime;

  private String content;

  private Integer score;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

}
