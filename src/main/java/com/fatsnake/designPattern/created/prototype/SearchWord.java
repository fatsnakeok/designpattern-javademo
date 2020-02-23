package com.fatsnake.designPattern.created.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: fatsnake
 * @Description":
 * @Date:2020-02-23 15:46
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
@Data
@AllArgsConstructor
public class SearchWord {
    private String keyword;
    private Long lastUpdateTime;
    private Integer count;

    public SearchWord(String keyword) {
        this.keyword = keyword;
        this.lastUpdateTime = new Date().getTime();
    }
}