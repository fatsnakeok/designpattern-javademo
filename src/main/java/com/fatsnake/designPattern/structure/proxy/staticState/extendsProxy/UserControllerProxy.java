package com.fatsnake.designPattern.structure.proxy.staticState.extendsProxy;

import com.fatsnake.designPattern.structure.proxy.staticState.interfaceProxy.MetricsCollector;
import com.fatsnake.designPattern.structure.proxy.staticState.interfaceProxy.UserController;
import com.fatsnake.designPattern.structure.proxy.staticState.interfaceProxy.UserVo;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-25 19:34
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class UserControllerProxy extends UserController {
    private MetricsCollector metricsCollector;

    public UserControllerProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public UserVo login(String telephone, String password) {
        // 委托
        UserVo userVo = super.login(telephone, password);


        // 省去追加的其他逻辑
        return null;
    }

    public UserVo register(String telephone, String password) {
        // weituo
        UserVo userVo = super.register(telephone, password);

        // 省去追加的其他逻辑
        return null;
    }
}

// UserControllerProxy使用举例
// UserController userController = new UserControllerProxy();