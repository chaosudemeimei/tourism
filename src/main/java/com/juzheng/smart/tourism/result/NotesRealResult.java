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
public class NotesRealResult {

    private String noteId;

    private String userId;

    private String cityId;

    private String title;

    private String content;

    private String creatime;

    private String cityName;
}
