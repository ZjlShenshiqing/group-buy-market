package com.zjl.domain.activity.service.trial.node;

import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import com.zjl.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.zjl.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zjl.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 输出试算结果
 * <p>
 * Created by Zhangjilin on 2025/4/13
 */
@Slf4j
@Service
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }
}
