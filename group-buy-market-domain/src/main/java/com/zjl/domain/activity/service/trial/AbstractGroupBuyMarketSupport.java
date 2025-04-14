package com.zjl.domain.activity.service.trial;

import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import com.zjl.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zjl.types.design.framework.tree.AbstractStrategyRouter;

/**
 * 拼团营销试算功能服务支撑
 * 继承于策略路由抽象类（规则树的核心）
 * Created By Zhangjilin 2025/04/13
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractStrategyRouter<com.zjl.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.zjl.domain.activity.model.entity.TrialBalanceEntity> {

}
