package com.zjl.infrastructure.adaptor.repository;

import com.zjl.domain.activity.adaptor.repository.IActivityRepository;
import com.zjl.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zjl.domain.activity.model.valobj.SkuVO;
import com.zjl.infrastructure.dao.IGroupBuyActivityDao;
import com.zjl.infrastructure.dao.IGroupBuyDiscountDao;
import com.zjl.infrastructure.dao.ISkuDao;
import com.zjl.infrastructure.dao.po.GroupBuyActivity;
import com.zjl.infrastructure.dao.po.GroupBuyDiscount;
import com.zjl.infrastructure.dao.po.Sku;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 与领域层进行对接的活动仓库层
 * <p>
 * Created by Zhangjilin on 2025/4/15
 */
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;

    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Resource
    private ISkuDao skuDao;

    /**
     * 根据渠道值查询配置中最新的一个有效的活动
     * @param source 来源
     * @param channel 渠道
     * @return 折扣活动
     */
    @Override
    public GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel){
        // 查询活动
        GroupBuyActivity groupBuyActivityReq = new GroupBuyActivity();
        groupBuyActivityReq.setSource(source);
        groupBuyActivityReq.setChannel(channel);
        GroupBuyActivity groupBuyActivityRes = groupBuyActivityDao.queryValidGroupBuyActivity(groupBuyActivityReq);

        // 从活动中获取折扣id
        String discountId = groupBuyActivityRes.getDiscountId();

        // 通过折扣id查询折扣信息
        GroupBuyDiscount groupBuyDiscountRes = groupBuyDiscountDao.queryGroupBuyActivityDiscountByDiscountId(discountId);

        // 构建VO的折扣信息
        GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount = GroupBuyActivityDiscountVO.GroupBuyDiscount.builder()
                .discountName(groupBuyDiscountRes.getDiscountName())
                .discountType(groupBuyDiscountRes.getDiscountType())
                .discountDesc(groupBuyDiscountRes.getDiscountDesc())
                .marketPlan(groupBuyDiscountRes.getMarketPlan())
                .marketExpr(groupBuyDiscountRes.getMarketExpr())
                .tagId(groupBuyDiscountRes.getTagId())
                .build();


        return GroupBuyActivityDiscountVO.builder()
                .activityId(groupBuyActivityRes.getActivityId())
                .activityName(groupBuyActivityRes.getActivityName())
                .source(groupBuyActivityRes.getSource())
                .channel(groupBuyActivityRes.getChannel())
                .goodsId(groupBuyActivityRes.getGoodsId())
                .groupBuyDiscount(groupBuyDiscount)
                .groupType(groupBuyActivityRes.getGroupType())
                .takeLimitCount(groupBuyActivityRes.getTakeLimitCount())
                .target(groupBuyActivityRes.getTarget())
                .validTime(groupBuyActivityRes.getValidTime())
                .status(groupBuyActivityRes.getStatus())
                .startTime(groupBuyActivityRes.getStartTime())
                .endTime(groupBuyActivityRes.getEndTime())
                .tagId(groupBuyActivityRes.getTagId())
                .tagScope(groupBuyActivityRes.getTagScope())
                .build();
    }

    /**
     * 查询商品信息
     * @param goodsId 商品id
     * @return 商品信息
     */
    @Override
    public SkuVO querySkuByGoodsId(String goodsId) {
        Sku sku = skuDao.querySkuByGoodsId(goodsId);
        return SkuVO.builder()
                .goodsId(sku.getGoodsId())
                .goodsName(sku.getGoodsName())
                .originalPrice(sku.getOriginalPrice())
                .build();
    }
}
