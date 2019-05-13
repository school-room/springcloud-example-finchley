package com.eugene.springcloud.example.center.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eugene.springcloud.example.center.pojo.domain.AccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAccountMapper extends BaseMapper<AccountDO> {
}
