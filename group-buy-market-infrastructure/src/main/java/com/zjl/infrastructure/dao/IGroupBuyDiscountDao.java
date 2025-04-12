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

    List<GroupBuyDiscount> queryGroupBuyDiscountList();
}
