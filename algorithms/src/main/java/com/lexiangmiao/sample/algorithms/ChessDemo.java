package com.lexiangmiao.sample.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ChessDemo {
    static Set<Chessman> qipan=null;
    static {
        qipan = new HashSet<>();
        // 初始化棋盘
        System.out.println();
    }

    public Boolean checkCross(Chessman qi){
        return ChessDemo.qipan.contains(qi);
    }
}

class Chessman {
    private int x;
    private int y;

    Chessman() {
    }

    Chessman(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x +","+y;
    }
}
