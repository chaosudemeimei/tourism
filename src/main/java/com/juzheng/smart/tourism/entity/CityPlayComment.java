package com.juzheng.smart.tourism.entity;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CityPlayComment extends Model<CityPlayComment> {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String commentId;

  private String playId;

  private String creatime;

  private String playtime;

  private String content;

  private Integer score;


}
