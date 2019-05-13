package com.eugene.springcloud.example.pojo.center.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 账户信息
 *
 * @author Eugene
 * 2019-05-07 10:24
 */
@ApiModel("账户信息")
@Data
public class AccountVO {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "财富", required = true, dataType = "Integer")
    private Double price;

    @ApiModelProperty(value = "用户ID")
    private String userId;
}
