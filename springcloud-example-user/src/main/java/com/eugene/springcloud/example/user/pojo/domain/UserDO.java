package com.eugene.springcloud.example.user.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eugene.springcloud.example.user.enumeration.GendaerEnum;
import lombok.Data;

import java.util.Date;

@TableName("user")
@Data
public class UserDO {

    @TableId
    private String id;

    private GendaerEnum gendaer;

    private String name;

//    @TableField("nick_name")
    private String nickName;

    private Date birthday;

    private Integer age;

}
