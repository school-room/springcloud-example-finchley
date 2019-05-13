package com.eugene.springcloud.example.user.api;

import com.eugene.springcloud.example.user.api.fallback.AccountAPI;
import com.eugene.springcloud.example.pojo.center.vo.AccountVO;
import com.eugene.springcloud.example.pojo.swagger2.DataResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "example-account", fallback = AccountAPI.class)
public interface IAccountAPI {

    @PostMapping(value = "/accounts/{userId}")
    DataResponseResult<AccountVO> get(@PathVariable("userId") String userId);
}
