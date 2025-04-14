package com.zjl.domain.activity.service;

import com.zjl.domain.activity.model.entity.MarketProductEntity;
import com.zjl.domain.activity.model.entity.TrialBalanceEntity;
import org.springframework.stereotype.Service;

/**
 * 营销服务接口
 * <p>
 * Created by Zhangjilin on 2025/4/13
 */
@Service
public interface IIndexGroupBuyMarketService {

    /**
     * 首页试算
     * @param marketProductEntity 营销商品
     * @return 试算结果
     * @throws Exception 异常
     */
    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;
}
