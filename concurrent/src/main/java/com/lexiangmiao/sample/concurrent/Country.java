package com.lexiangmiao.sample.concurrent;

import lombok.Getter;

public enum Country {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");


    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;

    Country(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static Country to(int retCode) {

        Country[] countries = Country.values();

        for (Country item :
                countries) {
            if (retCode == item.getRetCode()) {
                return item;
            }
        }
        return null;
    }
}
