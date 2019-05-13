package com.eugene.springcloud.example.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eugene.springcloud.example.center.pojo.domain.AccountDO;
import com.eugene.springcloud.example.center.pojo.dto.AccountDTO;
import com.eugene.springcloud.example.center.repository.IAccountMapper;
import com.eugene.springcloud.example.center.service.standard.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 描述类提供的功能
 *
 * @author Eugene
 * 2019-05-07 15:00
 */
@Service
public class AccountService extends ServiceImpl<IAccountMapper, AccountDO> implements IAccountService {

    @Override
    public AccountDTO findAccountByUserId(String userId) {
        LambdaQueryWrapper<AccountDO> lambdaQueryWrapper = new QueryWrapper<>(new AccountDO()).lambda();
        lambdaQueryWrapper.eq(AccountDO::getUserId, userId);
        AccountDO accountDO = super.baseMapper.selectOne(lambdaQueryWrapper);
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(accountDO, accountDTO);
        return accountDTO;
    }
}
