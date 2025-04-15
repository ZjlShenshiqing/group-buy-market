package com.zjl.infrastructure.dao;

import com.zjl.infrastructure.dao.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 折扣配置数据库接口
 * <p>
 * Created By Zhangjilin 2025/04/12
 */
@Mapper
public interface IGroupBuyDiscountDao {

    /**
     * 查询所有拼团折扣
     * @return 所有拼团折扣
     */
    List<GroupBuyDiscount> queryGroupBuyDiscountList();

    /**
     * 根据折扣id查询折扣配置
     * @param discountId 折扣id
     * @return 折扣配置
     */
    GroupBuyDiscount queryGroupBuyActivityDiscountByDiscountId(String discountId);
}
