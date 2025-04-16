package com.zjl.domain.activity.service.trial.node;

import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import com.zjl.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.zjl.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zjl.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 判断开关（是否可见，可参与拼团活动）
 * Created By Zhangjilin 2025/04/13
 */
@Slf4j
@Service
public class SwitchNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private MarketNode marketNode;

    /**
     * 判断方法，判断是否要走下一个节点
     * @param requestParameter 入参
     * @param dynamicContext 动态上下文
     * @return 是否要走下一个节点
     * @throws Exception 异常
     */
    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return router(requestParameter, dynamicContext);
    }

    /**
     * 给router指向
     */
    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return marketNode;
    }
}
