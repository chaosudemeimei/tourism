package com.juzheng.smart.tourism.result;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.Result;

@ToString
@Data
public class BaseResult<T>
{
    String status; //1 成功(是) 0 失败(否)
    String message;//存放信息的;
    T result;

    /*SUCCESS(200, "操作成功"),
    FAILED(400, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");*/
 }
