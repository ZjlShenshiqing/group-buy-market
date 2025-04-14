package com.zjl.domain.activity.service.trial.factory;

import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import com.zjl.domain.activity.service.trial.node.RootNode;
import com.zjl.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 默认的拼团活动策略工厂
 * Created By Zhangjilin 2025/04/13
 */
@Service
public class DefaultActivityStrategyFactory {

    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

    }
}
