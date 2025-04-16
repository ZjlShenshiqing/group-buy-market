package com.zjl.types.design.framework.tree;

/**
 * 策略受理器
 * 接口负责执行实际的业务逻辑。
 * <p>
 * Created By Zhangjilin 2025/04/13
 */
public interface StrategyHandler<T, D, R> {

    /**
     * 如果没有找到合适的策略处理器，就使用默认策略，默认策略的行为是返回 `null`
     */
    StrategyHandler DEFAULT = (T, D) -> null;

    /**
     * 每个具体的“节点”都会实现 `apply` 方法，执行这个节点的业务逻辑。
     * 方法会处理业务，可能会修改 `dynamicContext`（上下文），并返回结果（类型为 `R`）。
     * @param requestParameter 入参
     * @param dynamicContext 上下文
     * @return 返回的结果，如试算的结果
     */
    R apply(T requestParameter, D dynamicContext) throws Exception;
}
