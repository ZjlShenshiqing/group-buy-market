package com.zjl.domain.activity.service.trial.thread;

import com.zjl.domain.activity.adaptor.repository.IActivityRepository;
import com.zjl.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import java.util.concurrent.Callable;

/**
 * 查询营销活动异步任务
 * <p>
 * Created by Zhangjilin on 2025/4/14
 */
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    /**
     * 来源
     */
    private final String source;

    /**
     * 渠道
     */
    private final String channel;

    /**
     * 活动仓储
     */
    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source ,String channel, IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return activityRepository.queryGroupBuyActivityDiscountVO(source, channel);
    }
}
