package com.zjl.domain.activity.adaptor.repository;

import com.zjl.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zjl.domain.activity.model.valobj.SkuVO;

/**
 * 活动计算仓储接口（与基础设施层进行对接）
 * <p>
 * Created by Zhangjilin on 2025/4/14
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);
}
