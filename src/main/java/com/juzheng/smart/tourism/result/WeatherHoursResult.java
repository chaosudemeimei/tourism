package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author juzheng
 * @Title: WeatherHoursResult
 * @date 2019/5/7 11:27 AM
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WeatherHoursResult {
    String area;
    String areaid;
    String weather;
    String temperature;
    String wind_direction;
    String time;
    String weather_code;
    String wind_power;
}
