package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juzheng
 * @Title: WeatherResult
 * @date 2019/5/7 11:26 AM
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherResult {
    String area;
    String areaid;
    String ret_code;
    List<WeatherHoursResult> hourList=new ArrayList<>();
}
