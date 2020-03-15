package com.fatsnake.designPattern.behavior.observer.eventBus;


import com.google.common.annotations.Beta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: fatsnake
 * @Description": 用于标明观察者中的哪个函数可以接收消息
 * @Date:2020-03-15 11:24
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
@Retention(RetentionPolicy.RUNTIME) // 在运行时有效（即运行时保留）
@Target(ElementType.METHOD)  // 用于描述方法
@Beta
public @interface Subscribe {}