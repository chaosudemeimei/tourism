package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author juzheng
 * @Title: CityPlayCommentResult
 * @date 2019/5/19 8:25 AM
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityPlayCommentResult {
    public String playId;
    public String content;
    public Integer score;
}
