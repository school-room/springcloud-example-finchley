package com.eugene.springcloud.example.center.service.standard;

import com.eugene.springcloud.example.center.pojo.dto.AccountDTO;

/**
 * 用户业务接口定义
 *
 * @author Eugene
 * 2019-05-07 14:59
 */
public interface IAccountService {

    AccountDTO findAccountByUserId(String userId);
}
