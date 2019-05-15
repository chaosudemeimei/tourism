package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author juzheng
 * @Title: CityResult
 * @date 2019/5/15 9:03 PM
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityResult {
    public String name;
    public String value;
    public int checked;
}
