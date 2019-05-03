package com.juzheng.smart.tourism.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author juzheng
 * @Title: LoginRes
 * @date 2019/5/2 8:54 PM
 * @Description:登录时候前端返回的数据
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LoginRes {
    String user_data1;
    String user_data2;

}
