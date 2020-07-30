package com.lexiangmiao.sample.svc.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mzxiao on 2020/7/30 9:25
 * 录取批次
 */
public enum AdmissionBatch {

    // NONE
    Undergraduate_First_Batch(7, "本科一批"),
    Undergraduate_Second_Batch(8, "本科二批");

    private final int value;
    private final String displayName;

    AdmissionBatch(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static AdmissionBatch getMessageType(Integer value) {
        if (value == null) {
            return AdmissionBatch.Undergraduate_First_Batch;
        }
        AdmissionBatch[] values = AdmissionBatch.values();
        return Arrays.stream(values).filter(item -> item.value == value).findFirst().orElse(null);
    }

    public static List<Integer> getAllValues() {
        AdmissionBatch[] values = AdmissionBatch.values();
        return Arrays.stream(values).map(item -> item.value).collect(Collectors.toList());
    }

    public int value() {
        return this.value;
    }
}
