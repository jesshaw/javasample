package com.lexiangmiao.sample.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lexiangmiao.sample.springcloud.entities.CommonResult;

public final class CustomerBlockHandler {
    public static CommonResult handleException(BlockException block) {
        return new CommonResult(4444, "按客户自定义，global handlerException!---1");
    }
    public static CommonResult handleException2(BlockException block) {
        return new CommonResult(4444, "按客户自定义，global handlerException!---2");
    }
}
