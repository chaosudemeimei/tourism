package com.juzheng.smart.tourism.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.City;
import com.juzheng.smart.tourism.entity.CityBuy;
import com.juzheng.smart.tourism.mapper.CityMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.result.WeatherHoursResult;
import com.juzheng.smart.tourism.result.WeatherResult;
import com.juzheng.smart.tourism.service.ICityService;
import com.juzheng.smart.tourism.util.HotCity;
import com.juzheng.smart.tourism.util.HttpUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author juzheng
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ICityService cityService;
    @ApiOperation(value="返回热门城市列表", notes="token需要解析")
    @RequestMapping(value = "/api/city/token", method = RequestMethod.GET)
    public List<City> city_des_sel() {
        List<City>list=new ArrayList<>();
        for(HotCity hotCity : HotCity .values()){
            QueryWrapper<City>cityQueryWrapper=new QueryWrapper<>();
            cityQueryWrapper.lambda().eq(City::getName,hotCity.getCity_name());
            list.add(cityService.getOne(cityQueryWrapper));
        }

        return list;
    }

    @ApiOperation(value="根据cityid返回城市名称", notes="返回Stirng")
    @RequestMapping(value = "/api/city/{cityid}", method = RequestMethod.GET)
    public String city_des_sel(@PathVariable("cityid") String cityid) {
        QueryWrapper<City>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(City::getCityId,cityid);
        City city=cityService.getOne(queryWrapper);
        String cityName=city.getName();
        return cityName;
    }
    @ApiOperation(value="根据城市id返回天气", notes="需要进一步解析json")
    @RequestMapping(value = "/api/city/weather/{cityid}", method = RequestMethod.GET)
    public String cityweather(@PathVariable("cityid") String cityid) {
        /*ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        String cityid = "";
        for (Cookie cookie : cookies) {
            switch(cookie.getName()){
                case "cityid":
                    cityid = cookie.getValue();
                    break;
                default:
                    break;
            }
        }*/
        if(cityid!=null) {
            QueryWrapper<City> cityQueryWrapper = new QueryWrapper<>();
            cityQueryWrapper.lambda().eq(City::getCityId, cityid);
            City city = cityService.getOne(cityQueryWrapper);
            String cityname = city.getName();

            String host = "http://saweather.market.alicloudapi.com";
            String path = "/hour24";
            String method = "GET";
            String appcode = "26d5b6355f7f458ba426740c92d1be08";
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("area", cityname);
            //querys.put("areaid", "101230506");
            try {
                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
                System.out.println(response.toString());
                //获取response的body
                String s = EntityUtils.toString(response.getEntity());
                Map map = (Map) JSONArray.parse(s);
                //System.out.println(map.get("showapi_res_body"));
                String jsonString = map.get("showapi_res_body").toString();
                WeatherResult weatherResult = JSON.parseObject(jsonString, WeatherResult.class);
                List<WeatherHoursResult> weatherHoursResult = weatherResult.getHourList();
                String wea = weatherHoursResult.get(0).getWeather() + ",";
                String tem = weatherHoursResult.get(0).getTemperature() + "度，";
                String win_d = weatherHoursResult.get(0).getWind_direction() + ",";
                String win_p = weatherHoursResult.get(0).getWind_power();
                String weather = wea + tem + win_d + win_p;
                return weather;
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
        else
        {
            return "";
        }

    }
    



}
