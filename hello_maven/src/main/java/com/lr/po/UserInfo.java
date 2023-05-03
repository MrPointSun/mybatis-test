package com.lr.po;

import java.util.Date;
import lombok.Data;

@Data
public class UserInfo {
    //user_id             bigint auto_increment comment '用户ID' primary key,
    // username         varchar(50)      null default '' comment  '用户名',
    // user_password    varchar(50)    null default '' comment '用户密码',
    // create_time  timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    // update_time  timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
    private Long userId;
    private String username;
    private String userPassword;
    private Date createTime;
    private Date updateTime;
}
