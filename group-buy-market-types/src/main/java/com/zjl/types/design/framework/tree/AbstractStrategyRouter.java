package com.zjl.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * 策略路由抽象类
 * 核心引擎类，继承了 Mapper 和 Handler。
 * 它的工作是：
 *   1. 调用 `get()` 方法，找到下一个节点（通过映射器策略）。
 *   2. 调用 `apply()` 方法，执行该节点的业务逻辑。
 *   3. 然后继续传给下一个节点……形成“链式多分支”的调用过程。
 * @param <T>
 * @param <D>
 * @param <R>
 */
public abstract class AbstractStrategyRouter<T, D, R> implements StrategyMapper<T, D, R>, StrategyHandler<T, D, R> {

    /**
     * defaultStrategyHandler：这是一个默认的策略处理器，类型是 StrategyHandler<T, D, R>。
     * 它通过 StrategyHandler.DEFAULT 被初始化，
     * 意味着它提供一个默认的处理方式，如果在路由过程中没有找到合适的策略处理器时，就会使用这个默认策略处理器来处理请求。
     */
    @Getter
    @Setter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 根据传入的 requestParameter（请求参数）和 dynamicContext（动态上下文），选择一个合适的策略处理器来执行操作。
     * @param requestParameter 请求参数
     * @param dynamicContext 动态上下文
     * @return 策略处理器
     * @throws Exception 异常
     */
    public R router(T requestParameter, D dynamicContext) throws Exception {
        /**
         * get(requestParameter, dynamicContext)：这个方法的调用目的是根据请求参数和动态上下文来获取一个具体的策略处理器。
         * get 方法的实现应该在继承 AbstractStrategyRouter 的子类中定义，因为这个方法的实现可能根据具体场景来选择不同的策略。
         */
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);

        /**
         * 一旦找到了合适的策略处理器，就调用它的 apply 方法来执行具体的操作。这个方法会根据具体的策略实现来处理请求，返回一个结果。
         */
        if (strategyHandler != null) {
            return strategyHandler.apply(requestParameter, dynamicContext);
        }

        /**
         * 没找到就返回默认的
         */
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }
}
