package com.eugene.springcloud.example.pojo.user.criteria;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户查询条件
 *
 * @author Eugene
 * 2019-05-07 15:20
 */
@ApiModel("用户信息")
@Data
public class UserCriteria {
    @ApiModelProperty(value = "主键ID", required = true)
    private String id;

    @ApiModelProperty(value = "性别", dataType = "Integer")
    private Integer gendaer;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "生日", dataType = "Date")
    private Date birthday;

    @ApiModelProperty(value = "年龄", dataType = "Integer")
    private Integer age;
}
