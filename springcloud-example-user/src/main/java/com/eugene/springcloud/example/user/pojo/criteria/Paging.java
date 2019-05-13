package com.eugene.springcloud.example.user.pojo.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 分页信息实体
 *
 * @author Eugene
 * 2018-12-04 16:34
 */
@Data
@AllArgsConstructor
public class Paging {

    /**
     * 当前页码
     */
    private Long currentPageNum;

    /**
     * 每页数据条数
     */
    private Long pageSize;
}
