package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author juzheng
 * @Title: RegisertRes
 * @date 2019/4/30 11:31 AM
 * @Description:注册返回的手机号+验证码的类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RegisertRes {
    public String phone_number;
    public String register_number;
}
