package com.eugene.springcloud.example.user.api.fallback;

import com.eugene.springcloud.example.user.api.IAccountAPI;
import com.eugene.springcloud.example.pojo.center.vo.AccountVO;
import com.eugene.springcloud.example.pojo.swagger2.DataResponseResult;
import org.springframework.stereotype.Component;

@Component
public class AccountAPI implements IAccountAPI {
    @Override
    public DataResponseResult<AccountVO> get(String userId) {
        return null;
    }
}
