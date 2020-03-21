package com.fatsnake.designPattern.behavior.strategy;

/**
 * 策略的定义
 * @Auther: fatsnake
 * @Description": 一个接口 + 一组实现接口的策略类
 * @Date:2020-03-21 10:48
 * Copyright (c) 2020, zaodao All Rights Reserved.
 * <p>
 * 因为所有的策略类都实现相同的接口，所以，客户端代码基于接口而非实现编程，可以灵活地替换不同的策略。
 */
public interface Strategy {
    void algorithmInterface();
}


class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithmInterface() {
        //具体的算法...

    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithmInterface() {
        //具体的算法...
    }
}