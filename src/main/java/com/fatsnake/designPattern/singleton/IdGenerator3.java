package com.fatsnake.designPattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: fatsnake
 * @Description": 单例模式 --- 双重检测  https://www.cnblogs.com/tangZH/p/10031337.html
 * @Date:2020-02-06 14:10
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class IdGenerator3 {

    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator3 instance;

    private IdGenerator3() {
    }

    public static IdGenerator3 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator3.class) {// 此处为类级别的锁
                if (instance == null) {
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}
