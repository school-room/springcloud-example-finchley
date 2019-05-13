package com.eugene.springcloud.example.user.service.standard;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eugene.springcloud.example.user.pojo.criteria.Paging;
import com.eugene.springcloud.example.user.pojo.domain.UserDO;
import com.eugene.springcloud.example.user.pojo.dto.UserDTO;
import com.eugene.springcloud.example.pojo.user.criteria.UserCriteria;
import com.eugene.springcloud.example.pojo.user.vo.UserAccoutVO;

/**
 * 用户业务接口定义
 *
 * @author Eugene
 * 2019-05-07 14:59
 */
public interface IUserService {

    /**
     * 新增用户信息
     * @param userCriteria 用户信息
     * @return 新增成功返回true，新增失败返回false
     */
    boolean saveUser(UserCriteria userCriteria);

    /**
     * 删除指定ID的用户信息
     * @param id 用户ID
     * @return 删除成功返回true，删除失败返回false
     */
    boolean removeById(String id);

    boolean modifyUser(UserCriteria userCriteria);

    /**
     * 获取指定ID的用户信息
     * @param id 用户ID
     * @return 返回匹配指定ID的用户信息，没有匹配的用户信息返回null
     */
    UserDTO fetchById(String id);

    /**
     * 获取指定ID的用户信息
     * @param userCriteria 用户查询条件
     * @param paging 分页信息
     * @return 返回匹配指定ID的用户信息，没有匹配的用户信息返回null
     */
    IPage<UserDO> fetchAll(UserCriteria userCriteria, Paging paging);

    UserAccoutVO fetchAccountByUserId(String userId);
}
