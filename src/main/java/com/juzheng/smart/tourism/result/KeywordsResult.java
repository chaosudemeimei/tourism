package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author juzheng
 * @Title: KeywordsResult
 * @date 2019/5/14 8:54 PM
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeywordsResult {
    public String name;
    public String value;
    public int checked;
}
