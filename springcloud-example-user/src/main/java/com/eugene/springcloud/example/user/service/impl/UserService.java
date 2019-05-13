package com.eugene.springcloud.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eugene.springcloud.example.user.api.IAccountAPI;
import com.eugene.springcloud.example.user.pojo.criteria.Paging;
import com.eugene.springcloud.example.user.pojo.domain.UserDO;
import com.eugene.springcloud.example.user.repository.IUserMapper;
import com.eugene.springcloud.example.user.service.standard.IUserService;
import com.eugene.springcloud.example.user.enumeration.GendaerEnum;
import com.eugene.springcloud.example.user.pojo.dto.UserDTO;
import com.eugene.springcloud.example.pojo.center.vo.AccountVO;
import com.eugene.springcloud.example.pojo.swagger2.DataResponseResult;
import com.eugene.springcloud.example.pojo.user.criteria.UserCriteria;
import com.eugene.springcloud.example.pojo.user.vo.UserAccoutVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述类提供的功能
 *
 * @author Eugene
 * 2019-05-07 15:00
 */
@Slf4j
@Service
public class UserService extends ServiceImpl<IUserMapper, UserDO> implements IUserService {

    @Autowired
    private IAccountAPI accountAPI;

    @Override
    public boolean saveUser(UserCriteria userCriteria) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userCriteria, userDO);
        userDO.setGendaer(GendaerEnum.MAN.getCode().equals(userCriteria.getGendaer()) ? GendaerEnum.MAN : GendaerEnum.FEMALE);

        return super.save(userDO);
    }

    @Override
    public boolean removeById(String id) {
        return super.removeById(id);
    }

    @Override
    public boolean modifyUser(UserCriteria userCriteria) {
        UserDTO userDTO = this.fetchById(userCriteria.getId());
        if (userDTO == null) {
            throw new RuntimeException("没有查询到的用户");
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userCriteria, userDO);
        return super.updateById(userDO);
    }

    @Override
    public UserDTO fetchById(String id) {
        UserDTO userDTO = new UserDTO();
        UserDO userDO = super.getById(id);
        BeanUtils.copyProperties(userDO, userDTO);
        userDTO.setGendaer(userDO.getGendaer().getCode());
        return userDTO;
    }

    @Override
    public IPage<UserDO> fetchAll(UserCriteria userCriteria, Paging paging) {
        UserDO userDO = new UserDO();
        IPage<UserDO> queryPage = new Page(paging.getCurrentPageNum(), paging.getPageSize());
        LambdaQueryWrapper<UserDO> lambdaQueryWrapper = new QueryWrapper<>(userDO).lambda();
        if (userCriteria.getAge() != null) {
            lambdaQueryWrapper.eq(UserDO::getAge, userCriteria.getAge());
        }
        if (userCriteria.getGendaer() != null) {
            lambdaQueryWrapper.eq(UserDO::getGendaer, userCriteria.getGendaer());
        }

        return super.baseMapper.selectPage(queryPage, lambdaQueryWrapper);
    }

    @Override
    public UserAccoutVO fetchAccountByUserId(String userId) {
        UserDTO userDTO = this.fetchById(userId);
        if (userDTO == null) {
            throw new RuntimeException("没有查询到用户");
        }
        DataResponseResult<AccountVO> result = this.accountAPI.get(userId);
        log.info("通过ID：{}，查询到用户信息：{}", userId, result);
        UserAccoutVO userAccoutVO = new UserAccoutVO();
        BeanUtils.copyProperties(userDTO, userAccoutVO);
        userAccoutVO.setPrice(result.getData().getPrice());
        return userAccoutVO;
    }
}
