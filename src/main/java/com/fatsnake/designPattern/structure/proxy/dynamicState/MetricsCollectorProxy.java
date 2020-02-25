package com.fatsnake.designPattern.structure.proxy.dynamicState;

import com.fatsnake.designPattern.structure.proxy.staticState.interfaceProxy.MetricsCollector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: fatsnake
 * @Description": 动态代理
 * @Date:2020-02-25 19:54
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        Class[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            // 委托
            Object result = method.invoke(proxiedObject, args);

            // 附加的其他新逻辑
            return result;
        }
    }
}
