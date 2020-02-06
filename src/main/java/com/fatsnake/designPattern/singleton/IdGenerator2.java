package com.fatsnake.designPattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: fatsnake
 * @Description": 单例模式 --- 懒汉式
 * <p>
 * 懒汉式相对于饿汉式的优势是支持延迟加载。
 * 这种实现方式会导致频繁加锁、释放锁，以及并发度低等问题，频繁的调用会产生性能瓶颈。
 * @Date:2020-02-06 14:05
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class IdGenerator2 {

    private AtomicLong id = new AtomicLong();

    private IdGenerator2() {
    }

    private static IdGenerator2 instance;

    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
