package com.lexiangmiao.sample.algorithms;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉K位数字
 * <p>
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 */
public class RemoveKdigitsDemo {
    public static void main(String[] args) {
        RemoveKdigitsDemo intReverse = new RemoveKdigitsDemo();
        System.out.println(intReverse.removeKdigits("92", 2));
    }

    /**
     * 队列思维
     */
    public String removeKdigits(String num, int k) {
        // 队列思维方式
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        // 删除跟给出数字字符串相同长度位数的数字时，k不为0。需特别处理
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        // 按指定格式输出数字字符串
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
