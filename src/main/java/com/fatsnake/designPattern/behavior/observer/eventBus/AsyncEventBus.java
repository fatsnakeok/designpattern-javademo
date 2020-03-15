package com.fatsnake.designPattern.behavior.observer.eventBus;

import java.util.concurrent.Executor;

/**
 * @Auther: fatsnake
 * @Description": 异步非阻塞的观察者模式
 * @Date:2020-03-15 11:28
 * Copyright (c) 2020, zaodao All Rights Reserved.
 * 有了 EventBus，AsyncEventBus 的实现就非常简单了。为了实现异步非阻塞的观察者模式，它就不能再继续使用
 * MoreExecutors.directExecutor() 了，而是需要在构造函数中，由调用者注入线程池。
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
