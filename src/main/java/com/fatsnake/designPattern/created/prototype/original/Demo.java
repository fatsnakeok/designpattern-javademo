package com.fatsnake.designPattern.created.prototype.original;

import com.fatsnake.designPattern.created.prototype.SearchWord;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Auther: fatsnake
 * @Description": 原始代码 : 如果是10万条数据，创建对象的损耗资源相当大
 * @Date:2020-02-23 15:46
 * Copyright (c) 2020, zaodao All Rights Reserved.
 * 需求：
 * 任何时刻，系统 A 中的所有数据都必须是同一个版本的，要么都是版本 a，要么都是版本 b，不能有的是版本 a，有的是版本 b。
 * 那刚刚的更新方式就不能满足这个要求了。除此之外，我们还要求：在更新内存数据的时候，系统 A 不能处于不可用状态，也就是不能停机更新数据。
 */
public class Demo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    public void refresh() {
        HashMap<String, SearchWord> newKeywords = new LinkedHashMap<>();

        // 从数据库中取出所有的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }

        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords() {
        // TODO: 从数据库中取出所有的数据
        return null;
    }
}