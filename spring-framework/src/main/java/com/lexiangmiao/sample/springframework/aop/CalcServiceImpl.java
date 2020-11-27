package com.lexiangmiao.sample.springframework.aop;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("   ======计算结果 " + result);
        return result;
    }
}
