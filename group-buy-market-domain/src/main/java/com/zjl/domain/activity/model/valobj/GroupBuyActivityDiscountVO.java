package com.zjl.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 拼团活动营销配置值对象
 * 值对象是不可变的，即一旦创建后，它的状态（属性值）就不能再改变。
 * <p>
 * Created by Zhangjilin on 2025/4/14
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyActivityDiscountVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 渠道
     */
    private String source;

    /**
     * 来源
     */
    private String channel;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 折扣配置
     */
    private GroupBuyDiscount groupBuyDiscount;

    /**
     * 拼团方式
     * 0：自动成团
     * 1：达成目标成团
     */
    private Integer groupType;

    /**
     * 拼团次数限制
     */
    private Integer takeLimitCount;

    /**
     * 拼团目标
     */
    private Integer target;

    /**
     * 拼团时长
     *
     * 计时单位为分钟
     */
    private Integer validTime;

    /**
     * 活动状态
     * 0：创建
     * 1：生效
     * 2：过期
     * 3：废弃
     */
    private Integer status;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 人群标签规则标识
     */
    private String tagId;

    /**
     * 人群标签规则范围
     */
    private String tagScope;

    /**
     * 拼团折扣配置
     * <p>
     * Created By Zhangjilin 2025/04/14
     */
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GroupBuyDiscount {
        /**
         * 折扣标题
         */
        private String discountName;

        /**
         * 折扣描述
         */
        private String discountDesc;

        /**
         * 折扣类型
         */
        private Byte discountType;

        /**
         * 营销优惠计划
         * ZJ:直减
         * MJ：满减
         * N元购
         */
        private String marketPlan;

        /**
         * 营销优惠表达式
         */
        private String marketExpr;

        /**
         * 人群标签，特定优惠限定
         */
        private String tagId;
    }
}
