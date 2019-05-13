package com.eugene.springcloud.example.center.web.controller;

import com.eugene.springcloud.example.center.pojo.dto.AccountDTO;
import com.eugene.springcloud.example.center.service.standard.IAccountService;
import com.eugene.springcloud.example.pojo.center.vo.AccountVO;
import com.eugene.springcloud.example.pojo.swagger2.DataResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "账户管理")
@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Value("${server.port}")
    private String port;

    /**
     * 查询指定用户的账户信息
     * @return PagingResponseResult响应结果
     */
    @ApiOperation(value = "获取用户ID的账户信息", notes = "通过指定的用户ID获取相关的账户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping(value = "/{userId}")
    public DataResponseResult<AccountVO> get(@PathVariable("userId") String userId) {
        log.info("服务端口:{}被调用......", this.port);
        AccountDTO accountDTO = this.accountService.findAccountByUserId(userId);
        AccountVO accountVO = new AccountVO();
        BeanUtils.copyProperties(accountDTO, accountVO);
        return new DataResponseResult<>(accountVO);
    }
}
