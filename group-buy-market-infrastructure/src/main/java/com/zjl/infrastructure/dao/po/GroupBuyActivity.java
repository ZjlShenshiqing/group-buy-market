package com.zjl.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 拼团活动实体类（用于创建一个拼团活动）
 * <p>
 * Created By Zhangjilin 2025/04/12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyActivity {

    /**
     * ID
     */
    private Long id;

    /**
     * 拼团活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 来源
     */
    private String source;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 折扣id
     */
    private String discountId;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
