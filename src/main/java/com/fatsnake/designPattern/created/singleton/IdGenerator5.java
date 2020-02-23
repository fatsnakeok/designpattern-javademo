package com.fatsnake.designPattern.created.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: fatsnake
 * @Description": 单例模式 --- 枚举  https://www.cnblogs.com/kaleidoscope/p/9636779.html   https://www.jianshu.com/p/d35f244f3770
 * 最简单的实现方式，基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。
 * @Date:2020-02-06 14:14
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public enum IdGenerator5 {INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }}
