package com.fatsnake.designPattern.created.factory.original;

import com.fatsnake.designPattern.created.factory.base.IRuleConfigParser;
import com.fatsnake.designPattern.created.factory.base.InvalidRuleConfigException;
import com.fatsnake.designPattern.created.factory.base.JsonRuleConfigParser;
import com.fatsnake.designPattern.created.factory.base.PropertiesRuleConfigParser;
import com.fatsnake.designPattern.created.factory.base.RuleConfig;
import com.fatsnake.designPattern.created.factory.base.XmlRuleConfigParser;
import com.fatsnake.designPattern.created.factory.base.YamlRuleConfigParser;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-22 14:38
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception{
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new PropertiesRuleConfigParser();
        } else {
            throw new InvalidRuleConfigException(
                "Rule config file format is not supported: " + ruleConfigFilePath);
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
