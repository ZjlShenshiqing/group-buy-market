package com.zjl.infrastructure.dao;

import com.zjl.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * ISkuDao
 * <p>
 * Created by Zhangjilin on 2025/4/14
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);
}
