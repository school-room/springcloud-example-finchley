package com.eugene.springcloud.example.user.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eugene.springcloud.example.user.pojo.criteria.Paging;
import com.eugene.springcloud.example.user.pojo.domain.UserDO;
import com.eugene.springcloud.example.user.pojo.dto.UserDTO;
import com.eugene.springcloud.example.user.service.standard.IUserService;
import com.eugene.springcloud.example.pojo.swagger2.DataResponseResult;
import com.eugene.springcloud.example.pojo.swagger2.PagingResponse;
import com.eugene.springcloud.example.pojo.swagger2.PagingResponseResult;
import com.eugene.springcloud.example.pojo.swagger2.ResponseResult;
import com.eugene.springcloud.example.pojo.user.criteria.UserCriteria;
import com.eugene.springcloud.example.pojo.user.vo.UserAccoutVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询指定条件的用户列表
     * @param userCriteria 用户查询条件
     * @param currentPageNum 当前页码
     * @param pageSize 每页显示数据条数
     * @return PagingResponseResult响应结果
     */
    @ApiOperation(value = "获取匹配条件的用户信息", notes = "获取匹配指定用户ID的用户信息")
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping(value = "/list")
    public PagingResponseResult get(@RequestBody UserCriteria userCriteria, @RequestParam("currentPageNum") Long currentPageNum, @RequestParam("pageSize") Long pageSize) {
        IPage<UserDO> page = this.userService.fetchAll(userCriteria, new Paging(currentPageNum, pageSize));
        PagingResponse<UserDO> pagingResponse = new PagingResponse<>();
        pagingResponse.setCurrentPage(page.getCurrent());
        pagingResponse.setPageSize(page.getSize());
        pagingResponse.setList(page.getRecords());
        return new PagingResponseResult(pagingResponse);
    }

    /**
     *
     * @param id 用户ID
     * @return DataResponseResult响应结果
     */
    @ApiOperation(value = "获取指定ID的用户信息", notes = "获取匹配指定用户ID的用户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "创建成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping(value = "/{id}")
    public DataResponseResult<UserDTO> get(@PathVariable("id") String id) {
        UserDTO userDTO = this.userService.fetchById(id);
        return new DataResponseResult<>(userDTO);
    }

    /**
     *
     * @param id 用户ID
     * @return DataResponseResult响应结果
     */
    @ApiOperation(value = "获取指定ID的用户账户信息", notes = "获取匹配指定用户ID的用户账户信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping(value = "/{id}/account")
    public DataResponseResult<UserAccoutVO> getAccount(@PathVariable("id") String id) {
        UserAccoutVO userAccoutVO = this.userService.fetchAccountByUserId(id);
        return new DataResponseResult<>(userAccoutVO);
    }

    /**
     *
     * @param id 用户ID
     * @return ResponseResult响应结果
     */
    @ApiOperation(value = "删除指定ID的用户信息", notes = "删除指定ID的用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "创建成功"),
            @ApiResponse(code = 400, message = "服务器内部错误")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseResult delete(@PathVariable("id") String id) {
        boolean isSuccess = this.userService.removeById(id);
        return isSuccess ? new ResponseResult(HttpStatus.OK.value(), "用户删除成功"): new ResponseResult(HttpStatus.BAD_REQUEST.value(), "用户删除失败");
    }

    /**
     * 新增用户
     * @param userCriteria 用户信息
     * @return ResponseResult响应结果
     */
    @ApiOperation(value = "新增用户", notes = "新增一个用户信息")
    @ApiResponses({
        @ApiResponse(code = 201, message = "创建成功"),
        @ApiResponse(code = 400, message = "服务器内部错误")
    })
    @PostMapping(value = "/new")
    public ResponseResult create(@RequestBody UserCriteria userCriteria) {
        boolean isSuccess = this.userService.saveUser(userCriteria);
        return isSuccess ? new ResponseResult(HttpStatus.CREATED.value(), "用户创建成功") : new ResponseResult(HttpStatus.BAD_REQUEST.value(), "用户创建失败");
    }

    /**
     * 更新用户
     * @param userCriteria 用户信息
     * @return ResponseResult响应结果
     */
    @ApiOperation(value = "更新用户", notes = "更新一个用户信息")
    @ApiResponses({
            @ApiResponse(code = 201, message = "更新成功"),
            @ApiResponse(code = 400, message = "服务器内部错误")
    })
    @PutMapping(value = "/one")
    public ResponseResult update(@RequestBody UserCriteria userCriteria) {
        boolean isSuccess = this.userService.modifyUser(userCriteria);
        return isSuccess ? new ResponseResult(HttpStatus.OK.value(), "用户更新成功"): new ResponseResult(HttpStatus.BAD_REQUEST.value(), "用户更新失败");
    }
}
