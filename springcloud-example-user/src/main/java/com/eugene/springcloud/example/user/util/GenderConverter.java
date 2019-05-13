package com.eugene.springcloud.example.user.util;

import com.eugene.springcloud.example.user.enumeration.GendaerEnum;
import org.apache.commons.beanutils.Converter;

/**
 * 描述类提供的功能
 *
 * @author Eugene
 * 2018-12-04 15:22
 */
public class GenderConverter implements Converter {
    @Override
    public <T> T convert(Class<T> clazz, Object o) {
        if (o instanceof GendaerEnum) {
            int gendaerStr = (int) o;
            return gendaerStr == 1 ? (T)GendaerEnum.MAN : (T)GendaerEnum.FEMALE;
        }
        return null;
    }
}
