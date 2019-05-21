package com.juzheng.smart.tourism.recommend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.juzheng.smart.tourism.entity.City;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author juzheng
 * @Title: RecommendResult
 * @date 2019/5/21 1:23 PM
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecommendResult   extends Model<RecommendResult> {
    private static final long serialVersionUID = 1L;
    String userId;
    String playId;
    String score;
}
