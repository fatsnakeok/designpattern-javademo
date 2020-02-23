package com.fatsnake.designPattern.created.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: fatsnake
 * @Description": 单例模式 -- 饿汉式
 *
 * 饿汉式的实现方式，在类加载的期间，就已经将 instance 静态实例初始化好了，
 * 所以，instance 实例的创建是线程安全的。不过，这样的实现方式不支持延迟加载实例。
 *
 * @Date:2020-02-06 09:55
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class IdGenerator1 {

    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator1 instance = new IdGenerator1();

    private IdGenerator1() {
    }

    public static IdGenerator1 getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
