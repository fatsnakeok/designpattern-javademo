package com.fatsnake.designPattern.factory.factoryMethod;

import com.fatsnake.designPattern.factory.base.IRuleConfigParser;
import com.fatsnake.designPattern.factory.base.InvalidRuleConfigException;
import com.fatsnake.designPattern.factory.base.RuleConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-22 15:13
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
// 因为工厂类只包含方法，不包含成员变量，完全可以复用，
// 不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
// 工厂的工厂
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}

class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();
        String configText = ""; //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}