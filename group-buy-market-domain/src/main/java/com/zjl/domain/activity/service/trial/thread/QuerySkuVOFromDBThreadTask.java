package com.zjl.domain.activity.service.trial.thread;

import com.zjl.domain.activity.adaptor.repository.IActivityRepository;
import com.zjl.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * 查询商品信息异步任务
 * <p>
 * Created by Zhangjilin on 2025/4/14
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }
}
