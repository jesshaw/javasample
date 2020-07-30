package com.lexiangmiao.sample.svc.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mzxiao on 2020/7/30 8:53
 * 年份
 */
public enum Year {
    // NONE
    YEAR_2015(2015, "2015"),
    YEAR_2016(2016, "2016"),
    YEAR_2017(2017, "2017"),
    YEAR_2018(2018, "2018"),
    YEAR_2019(2019, "2019"),
    YEAR_2020(2020, "2020");

    private final int value;
    private final String displayName;

    Year(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static Year getMessageType(Integer value) {
        if (value == null) {
            return Year.YEAR_2015;
        }
        Year[] values = Year.values();
        return Arrays.stream(values).filter(item -> item.value == value).findFirst().orElse(null);
    }

    public static List<Integer> getAllValues() {
        Year[] values = Year.values();
        return Arrays.stream(values).map(item -> item.value).collect(Collectors.toList());
    }

    public static List<Integer> getValuesNotEquals(int year) {
        Year[] values = Year.values();
        return Arrays.stream(values).filter(o -> o.value != year).map(item -> item.value).collect(Collectors.toList());
    }

    public int value() {
        return this.value;
    }
}
