package com.eugene.springcloud.example.center.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("account")
@Data
public class AccountDO {

    private String id;

    private Double price;

    @TableField("user_id")
    private String userId;
}
