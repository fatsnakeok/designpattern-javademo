package com.fatsnake.designPattern.created.prototype;

import lombok.Data;

import java.util.HashMap;

/**
 * @Auther: fatsnake
 * @Description":  浅拷贝 简单小栗子  https://www.cnblogs.com/shakinghead/p/7651502.html
 * @Date:2020-02-23 15:15
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
@Data
public class HashMapCloneTest {
    private static HashMap<String, SearchWord> currentKeywordMaps = new HashMap();

    static {
        currentKeywordMaps.put("key1", new SearchWord("word1"));
        currentKeywordMaps.put("key2", new SearchWord("word2"));
//        currentKeywordMaps.put("key3", new SearchWord("word3"));
//        currentKeywordMaps.put("key4", new SearchWord("word4"));
    }


    public static void main(String[] args) {
        HashMap<String, SearchWord> newMap = (HashMap<String, SearchWord>) currentKeywordMaps.clone();
        System.out.println("浅拷贝的对象：" + newMap.toString());
        // 修改浅拷贝对象
        newMap.put("key1", new SearchWord("newWord"));
        System.out.println("浅拷贝的对象被修改后：" + newMap.toString());
        System.out.println("浅拷贝的对象被修改后的原对象：" + currentKeywordMaps.toString());

        // 删除
        newMap.remove("key1");
        System.out.println("浅拷贝的对象被删除后：" + newMap.toString());
        System.out.println("浅拷贝的对象被删除后的原对象：" + currentKeywordMaps.toString());
    }

}

