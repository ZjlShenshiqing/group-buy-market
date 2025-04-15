package com.zjl.infrastructure.dao;

import com.zjl.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 拼团活动数据库接口
 * <p>
 * Created By Zhangjilin 2025/04/12
 */
@Mapper
public interface IGroupBuyActivityDao {

    /**
     * 查询所有拼团活动记录
     * @return 所有拼团活动记录
     */
    List<GroupBuyActivity> queryGroupBuyActivityList();

    /**
     * 特定的 source 和 channel的“拼团活动”记录中的一条
     * @param groupBuyActivityReq 特定的渠道和来源
     * @return 最新的拼团活动
     */
    GroupBuyActivity queryValidGroupBuyActivity(GroupBuyActivity groupBuyActivityReq);
}
