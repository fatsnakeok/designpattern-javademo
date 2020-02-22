package com.fatsnake.designPattern.factory.factoryMethod;

import com.fatsnake.designPattern.factory.base.IRuleConfigParser;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-22 15:10
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();
}
