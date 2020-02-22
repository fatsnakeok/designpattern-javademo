package com.fatsnake.designPattern.factory.factoryMethod;

import com.fatsnake.designPattern.factory.base.IRuleConfigParser;
import com.fatsnake.designPattern.factory.base.JsonRuleConfigParser;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-22 15:10
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
