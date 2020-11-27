package com.lexiangmiao.sample.algorithms;

/**
 * 给出两个 非空 的链表用来表示两个 非负 的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class SumLinkListDemo {

    public static void main(String[] args) {
        Node a = new Node(2, new Node(4, new Node(3, null)));
        Node b = new Node(5, new Node(6, new Node(4, null)));

        Node r = m1(a, b, false);
        System.out.println(r);
    }

    public static Node m1(Node a, Node b, boolean flag) {
        Node current = a;

        if (current == null || b == null) {
            return null;
        }
        if (current != null && b == null) {
            return a;
        }

        if (current == null && b != null) {
            return b;
        }

        if (current != null && b != null) {
            int sum = current.getData() + b.getData() + (flag ? 1 : 0);
            current.setData(sum % 10);
            m1(current.getNext(), b.getNext(), sum > 9);
        }

        return current;
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data, Node nex) {
        this.data = data;
        this.next = nex;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", nex=" + next +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
