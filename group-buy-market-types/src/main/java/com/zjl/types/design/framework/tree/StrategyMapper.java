package com.zjl.types.design.framework.tree;

/**
 * 策略映射器
 * 用来决定某个节点应该执行哪个策略，也就是决定当前流程走向。
 * <p>
 * Created By Zhangjilin 2025/04/13
 */
public interface StrategyMapper<T, D, R> {

    /**
     * 获取待执行策略
     * 根据请求参数和上下文，选择并返回下一个要执行的策略节点（StrategyHandler）。
     * 这些节点是业务逻辑的处理者，执行具体的任务。
     * @param requestParameter 入参
     * @param dynamicContext 上下文
     * @return 返回具体的处理者
     * @throws Exception 异常
     */
    StrategyHandler<T, D, R> get(T requestParameter, D dynamicContext) throws Exception;
}
