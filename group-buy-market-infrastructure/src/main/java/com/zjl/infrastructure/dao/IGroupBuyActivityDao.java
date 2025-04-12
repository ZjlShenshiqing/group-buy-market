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

    List<GroupBuyActivity> queryGroupBuyActivityList();
}
