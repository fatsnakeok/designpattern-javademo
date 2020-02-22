package com.fatsnake.designPattern.factory.simpleFactory;

import com.fatsnake.designPattern.factory.base.IRuleConfigParser;
import com.fatsnake.designPattern.factory.base.InvalidRuleConfigException;
import com.fatsnake.designPattern.factory.base.JsonRuleConfigParser;
import com.fatsnake.designPattern.factory.base.PropertiesRuleConfigParser;
import com.fatsnake.designPattern.factory.base.RuleConfig;
import com.fatsnake.designPattern.factory.base.XmlRuleConfigParser;
import com.fatsnake.designPattern.factory.base.YamlRuleConfigParser;

/**
 * @Auther: fatsnake
 * @Description": 简单工厂类
 * @Date:2020-02-22 14:47
 * Copyright (c) 2020, zaodao All Rights Reserved.
 * 每次调用 RuleConfigParserFactory 的 createParser() 的时候，都要创建一个新的 parser。实际上，如果 parser 不复用
 */
public class RuleConfigParserFactory1 {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}


class RuleConfigSource1 {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory1.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}