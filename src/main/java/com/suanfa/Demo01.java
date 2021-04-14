package com.suanfa;

import com.alibaba.fastjson.JSONObject;
import com.myself.test.suanfa.ListNode;
import org.junit.Test;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/3/29 17:22
 */
public class Demo01 {
    /*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
    @Test
    public void test01() {
        ListNode l1 = new ListNode(9);
        int[] intArrar = new int[]{9,9,9,9,9,9,9,9,9,1};
        ListNode l2 = getListNodeByArray(intArrar);
//        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        StringBuilder builderOne = new StringBuilder();
        StringBuilder builderTwo = new StringBuilder();
        while (l1.next != null) {
            builderOne.append(l1.val);
            l1 = l1.next;
        }
        builderOne.append(l1.val);

        while (l2.next != null) {
            builderTwo.append(l2.val);
            l2 = l2.next;
        }
        builderTwo.append(l2.val);

        Integer result = Integer.parseInt(builderOne.reverse().toString()) + Integer.parseInt(builderTwo.reverse().toString());
        byte[] chars = new StringBuilder(result.toString()).reverse().toString().getBytes();
        ListNode startNode;
        ListNode endNode;
        startNode = new ListNode(Character.getNumericValue(chars[0]));
        endNode = startNode;
        for (int i = 1; i < chars.length; i++) {
            ListNode node = new ListNode(Character.getNumericValue(chars[i]));
            endNode.next = node;
            endNode = endNode.next;
        }
        System.out.println(startNode);

    }
    public ListNode getListNodeByArray(int[] intArrar){
        ListNode startNode;
        ListNode endNode;
        startNode = new ListNode(intArrar[0]);
        endNode = startNode;
        for (int i = 1; i < intArrar.length; i++) {
            ListNode node = new ListNode(intArrar[i]);
            endNode.next = node;
            endNode = endNode.next;
        }
        return startNode;
    }


}
