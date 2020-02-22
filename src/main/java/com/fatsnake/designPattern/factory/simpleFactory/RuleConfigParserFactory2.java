package com.fatsnake.designPattern.factory.simpleFactory;

import com.fatsnake.designPattern.factory.base.IRuleConfigParser;
import com.fatsnake.designPattern.factory.base.InvalidRuleConfigException;
import com.fatsnake.designPattern.factory.base.JsonRuleConfigParser;
import com.fatsnake.designPattern.factory.base.PropertiesRuleConfigParser;
import com.fatsnake.designPattern.factory.base.RuleConfig;
import com.fatsnake.designPattern.factory.base.XmlRuleConfigParser;
import com.fatsnake.designPattern.factory.base.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: fatsnake
 * @Description": 第二种简单工厂模式 = 简单工厂 + 单例模式
 * @Date:2020-02-22 14:53
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class RuleConfigParserFactory2 {

    private static final Map cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
            //返回null还是IllegalArgumentException全凭你自己说了算
        }
        IRuleConfigParser parser = (IRuleConfigParser) cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}


class RuleConfigSource2 {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory2.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = ""; //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}