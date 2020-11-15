package com.lexiangmiao.sample.algorithms;

import java.util.Arrays;

/**
 * 数组的相对排序
 * <p>
 * 给你两个数组，arr1 和arr2，
 * <p>
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2中的元素arr2[i]各不相同
 * arr2 中的每个元素arr2[i]都出现在arr1中
 */
public class RelativeSortArrayDemo {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = new int[]{2, 42, 38, 0, 43, 21};

        RelativeSortArrayDemo o = new RelativeSortArrayDemo();
        System.out.println("output: " + Arrays.toString(o.relativeSortArray(arr1, arr2)));
        System.out.println("expect: " + Arrays.toString(new int[]{2, 42, 38, 0, 43, 21, 5, 7, 12, 12, 13, 23, 24, 24, 27, 29, 30, 31, 33, 48}));
    }

    private int[] relativeSortArray(int[] arr1, int[] arr2) {int[] result = new int[arr1.length];
        int left = 0, right = result.length - 1;

        // 按arr2相对排序
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    result[left++] = arr1[j];
                }
            }
        }

        // 不存arr2中的从右往左插入，并记下最弱要排序开始位置的索引
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == arr1[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result[right--] = arr1[i];
            }
        }

        // 从指定索引开始位置进行排序
        Arrays.sort(result, right+1, result.length);

        return result;
    }
}
