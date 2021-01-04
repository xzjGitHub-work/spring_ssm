package com.myself.test.suanfa;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2021/1/4 9:22
 */
public class demo {
    //两数之和
    /*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
    @Test
    public void test01() {
        ListNode node = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(node, node2));
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode node = null;
        if (l1.next != null) {
            node = new ListNode(l1.val + l2.val, addTwoNumbers(l1.next, l2.next));
            return node;
        }
        node = new ListNode(l1.val + l2.val);
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        StringBuilder builder1 = new StringBuilder();
        builder1.append(l1.val);
        while (l1.next != null) {
            builder1.append(l1.next.val);
            l1 = l1.next;
        }

        StringBuilder builder2 = new StringBuilder();
        builder2.append(l2.val);
        while (l2.next != null) {
            builder2.append(l2.next.val);
            l2 = l2.next;
        }
        Integer i = Integer.parseInt(builder1.toString()) + Integer.parseInt(builder2.toString());
        char[] chars = i.toString().toCharArray();
        List<Character> list = new ArrayList<>();
        for (int j = chars.length-1; j >=0; j--) {
            list.add(chars[j]);
        }
        node = recursion.recursionFunction(list.iterator());
        return node;
    }

    static class recursion {
        static public ListNode recursionFunction(Iterator<Character> iterator) {
            ListNode node = new ListNode();
            if (iterator.hasNext()) {
                Character next = iterator.next();
                iterator.remove();
                node = new ListNode(Integer.parseInt(String.valueOf(next)), recursionFunction(iterator));
                return node;
            }
            return null;
        }
    }

    public ListNode test001(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;

    }
}
