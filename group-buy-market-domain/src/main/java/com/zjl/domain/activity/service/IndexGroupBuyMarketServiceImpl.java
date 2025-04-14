package com.zjl.domain.activity.service;

import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import com.zjl.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zjl.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 营销服务实现
 * <p>
 * Created by Zhangjilin on 2025/4/13
 */
@Service
@Slf4j
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService{

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();

        TrialBalanceEntity trialBalanceEntity = strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());

        return trialBalanceEntity;
    }
}
