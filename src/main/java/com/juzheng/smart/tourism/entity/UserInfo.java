package com.juzheng.smart.tourism.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private Integer sex;

    private String birthday;

    private LocalDateTime registerTime;

    private String realname;

    private String headUrl;

    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
