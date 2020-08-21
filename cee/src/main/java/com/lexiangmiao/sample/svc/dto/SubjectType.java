package com.lexiangmiao.sample.svc.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mzxiao on 2020/7/30 9:02
 * 文理科
 */
public enum SubjectType {
    // NONE
    SCIENCE(1, "理科"),
    LIBERAL_ARTS(2, "文科");

    private final int value;
    private final String displayName;

    SubjectType(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static SubjectType getMessageType(Integer value) {
        if (value == null) {
            return SubjectType.SCIENCE;
        }
        SubjectType[] values = SubjectType.values();
        return Arrays.stream(values).filter(item -> item.value == value).findFirst().orElse(null);
    }

    public static List<Integer> getAllValues() {
        SubjectType[] values = SubjectType.values();
        return Arrays.stream(values).map(item -> item.value).collect(Collectors.toList());
    }

    public int value() {
        return this.value;
    }
}
