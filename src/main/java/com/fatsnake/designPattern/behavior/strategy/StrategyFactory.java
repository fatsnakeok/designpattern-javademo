package com.fatsnake.designPattern.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略的创建
 *
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-03-21 10:50
 * Copyright (c) 2020, zaodao All Rights Reserved.
 * <p>
 * 因为策略模式会包含一组策略，在使用它们的时候，一般会通过类型（type）来判断创建哪个策略来使用。为了封装创建逻辑，我们需要对客户端代码
 * 屏蔽创建细节。我们可以把根据 type 创建策略的逻辑抽离出来，放到工厂类中。
 */
public class StrategyFactory {  // 编译时静态确定,共享策略对象
    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}

/**
 * 如果策略类是有状态的，根据业务场景的需要，我们希望每次从工厂方法中，获得的都是新创建的策略对象，而不是缓存好可共享的策略对象，那我们
 * 就需要按照如下方式来实现策略工厂类。
 * <p>
 * 此时并没有简化if-else逻辑，只不过是运动多态性进行封装
 */
class StrategyFactory2 { // 编译时静态确定,独享（新建）策略对象
    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }

        if (type.equals("A")) {
            return new ConcreteStrategyA();
        } else if (type.equals("B")) {
            return new ConcreteStrategyB();
        }

        return null;
    }
}