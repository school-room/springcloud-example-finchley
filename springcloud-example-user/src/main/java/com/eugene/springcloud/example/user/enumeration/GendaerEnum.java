package com.eugene.springcloud.example.user.enumeration;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 描述枚举的作用
 *
 * @author Eugene
 * 2018-12-04 10:14
 */
@Getter
public enum GendaerEnum {
    MAN(1, "男"), FEMALE(2, "女");

    @JsonValue
    @EnumValue
    private Integer code;

    private String description;

    GendaerEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static GendaerEnum getGendaer(Integer code) {
        switch (code) {
            case 1:
                return GendaerEnum.MAN;

            case 2:
                return GendaerEnum.FEMALE;
            default:
                return null;
        }
    }
}
