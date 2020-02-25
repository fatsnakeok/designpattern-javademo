package com.fatsnake.designPattern.structure.proxy.staticState.interfaceProxy;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-25 19:30
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class UserControllerProxy implements IUserController {

    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        // 委托
        UserVo userVo = userController.login(telephone, password);

        // 附加的其他新逻辑

        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        UserVo userVo = userController.register(telephone, password);

        // 附加的其他新逻辑
        return null;
    }


    //UserControllerProxy使用举例
    // 因为原始类和代理类实现相同的接口，是基于接口而非实现编程
    // 将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
    // IUserController userController = new UserControllerProxy(new UserController());
}
