package com.zjl.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * 线程池配置
 *
 * @EnableAsync 是 Spring Framework 中的一个注解，用于启用异步方法的执行。
 * 单来说，当你在应用程序中使用了 @EnableAsync 后，
 * Spring 会扫描所有标记了 @Async 的方法，并在单独的线程中执行它们，而不是在调用线程中顺序执行。
 * <p>
 * Created by Zhangjilin on 2025/4/14
 */
@Slf4j
@EnableAsync
@Configuration
@EnableConfigurationProperties(ThreadPoolConfigProperties.class)
public class ThreadPoolConfig {

    @Bean
    /**
     * @ConditionalOnMissingBean(ThreadPoolExecutor.class) 是 Spring Boot 中的一个条件注解，
     * 用于在 Spring 容器中不存在指定类型的 Bean 时，才加载或创建标注该注解的 Bean 配置。
     */
    @ConditionalOnMissingBean(ThreadPoolExecutor.class)
    public ThreadPoolExecutor threadPoolExecutor(ThreadPoolConfigProperties properties) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        // 实例化策略
        RejectedExecutionHandler handler;

        /*
         * AbortPolicy：丢弃任务并抛出RejectedExecutionException异常。
         * DiscardPolicy：直接丢弃任务，但是不会抛出异常
         * DiscardOldestPolicy：将最早进入队列的任务删除，之后再尝试加入队列的任务被拒绝
         * CallerRunsPolicy：如果任务添加线程池失败，那么主线程自己执行该任务
         * */
        switch (properties.getPolicy()) {
            case "AbortPolicy":
                handler = new ThreadPoolExecutor.AbortPolicy();
                break;
            case "DiscardPolicy":
                handler = new ThreadPoolExecutor.DiscardPolicy();
                break;
            case "DiscardOldestPolicy":
                handler = new ThreadPoolExecutor.DiscardOldestPolicy();
                break;
            case "CallerRunsPolicy":
                handler = new ThreadPoolExecutor.CallerRunsPolicy();
                break;
            default:
                handler = new ThreadPoolExecutor.AbortPolicy();
                break;
        }

        // 创建线程池
        return new ThreadPoolExecutor(
                properties.getCorePoolSize(),
                properties.getMaxPoolSize(),
                properties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(properties.getBlockQueueSize()),
                Executors.defaultThreadFactory(),
                handler
        );
    }
}
