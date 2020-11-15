package com.lexiangmiao.sample.algorithms;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode convert(int[] sortedArray) {
        ListNode preHead = new ListNode();
        ListNode prev = preHead;
        for (int i :
                sortedArray) {
            prev.next = new ListNode(i);
            prev = prev.next;
        }
        return preHead.next;
    }

    @Override
    public String toString() {
        ListNode prev = this;
        StringBuilder sb = new StringBuilder();
        while (prev != null) {
            sb.append(prev.val + " ");
            prev = prev.next;
        }
        return sb.toString();
    }
}

/**
 * 合并两个有序链表
 */
public class MergeTwoSortedLinkListsDemo {
    public static void main(String[] args) {
        ListNode h1 = ListNode.convert(new int[]{1, 2, 4, 10});
        ListNode h2 = ListNode.convert(new int[]{1, 3, 4});
        System.out.println(h1);
        System.out.println(h2);

        ListNode merged = mergeTwoSortedList(h1, h2);
        System.out.println(merged);


        ListNode h3 = ListNode.convert(new int[]{1, 2, 4, 10});
        ListNode h4 = ListNode.convert(new int[]{1, 3, 4});
        System.out.println(h3);
        System.out.println(h4);

        ListNode merged1 = mergeTwoSortedList2(h3, h4);
        System.out.println(merged1);

    }

    /**
     * 迭代
     */
    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode();
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    /**
     * 递归
     */
    public static ListNode mergeTwoSortedList2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoSortedList2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedList2(l1, l2.next);
            return l2;
        }
    }
}
