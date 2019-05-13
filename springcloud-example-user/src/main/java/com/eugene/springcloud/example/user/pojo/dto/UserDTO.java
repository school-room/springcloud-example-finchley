package com.eugene.springcloud.example.user.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@ApiModel("用户信息")
@Data
public class UserDTO {

    @ApiModelProperty(value = "用户ID")
    private String id;

    @ApiModelProperty(value = "用户性别")
    private Integer gendaer;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户生日")
    private Date birthday;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;

}
