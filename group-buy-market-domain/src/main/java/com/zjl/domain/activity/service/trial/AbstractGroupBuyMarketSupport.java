package com.zjl.domain.activity.service.trial;

import com.zjl.domain.activity.adaptor.repository.IActivityRepository;
import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import com.zjl.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zjl.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import com.zjl.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 拼团营销试算功能服务支撑
 * 继承于策略路由抽象类（规则树的核心）
 * Created By Zhangjilin 2025/04/13
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<com.zjl.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.zjl.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeout = 500;

    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(com.zjl.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException{
        // 缺省的方法
        // 子类有需要就自己重写，没需要就不用重写了
    };
}
