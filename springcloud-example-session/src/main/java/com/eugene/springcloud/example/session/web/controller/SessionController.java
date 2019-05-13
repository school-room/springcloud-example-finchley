package com.eugene.springcloud.example.session.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/sessions")
public class SessionController {

    @ApiOperation(value = "创建Session", notes = "创建一个Session，将请求地址放进HttpSession中")
    @GetMapping(value = "/new")
    public Map<String, Object> create(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>(2);
        request.getSession().setAttribute("requestUrl", request.getRequestURL());
        result.put("requestUrl", request.getRequestURL());
        return result;
    }

    @ApiOperation(value = "获取Session", notes = "获取Session，正常情况通过同一台及其访问不同服务节点，获取的sessionID和message值相同")
    @GetMapping(value = "/get")
    public Map<String, Object> get(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>(2);
        System.out.println("SessionId:" + request.getSession().getId());
        result.put("sessionId", request.getSession().getId());
        result.put("message", request.getSession().getAttribute("requestUrl"));
        return result;
    }
}
