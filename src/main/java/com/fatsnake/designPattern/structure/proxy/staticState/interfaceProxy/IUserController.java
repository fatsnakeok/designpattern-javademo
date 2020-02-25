package com.fatsnake.designPattern.structure.proxy.staticState.interfaceProxy;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-25 19:27
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public interface IUserController {
    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
