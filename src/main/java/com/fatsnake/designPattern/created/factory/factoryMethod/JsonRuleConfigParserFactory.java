package com.fatsnake.designPattern.created.factory.factoryMethod;

import com.fatsnake.designPattern.created.factory.base.IRuleConfigParser;
import com.fatsnake.designPattern.created.factory.base.JsonRuleConfigParser;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-22 15:10
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
