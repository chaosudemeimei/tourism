package com.juzheng.smart.tourism.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author juzheng
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
public class NotesPlanInfo extends Model<NotesPlanInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String planId;

    private String userId;

    private String cityId;

    private LocalDateTime createtime;

    private LocalDateTime begintime;

    private LocalDateTime endtime;

    private String population;

    private String budget;

    private String notesKeywords;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}