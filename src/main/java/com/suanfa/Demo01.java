package com.suanfa;

import com.alibaba.fastjson.JSONObject;
import com.myself.test.suanfa.ListNode;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

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

    /*2 给你一个长度为 n 的数组，其中只有一个数字出现了奇数次，其他均出现偶数次，问如何使用优秀的时空复杂度快速找到这个数字*/

    @Test
    public void test02() throws InterruptedException {
        int[] i = new int[]{2,2,10};
        boolean b = false;
        int result = 0;
        for (int l : i) {
            for (int m : i) {
//                b = l == m ? b = b:b = !b;
                if (l == m){
                    b = !b;
                }
            }
            if (b){
                result = l ;
                break;
            }
        }
        System.out.println(result);
    }
    /* '^'
    异或解法：异或运算满足交换律，a^b^a=a^a^b=b,因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
    然后再根据交换律把相等的合并到一块儿进行异或（结果为0），然后再与只出现过一次的元素进行异或，这样最后的结果就是，只出现过一次的元素（0^任意值=任意值）*/
    @Test
    public void test03() throws InterruptedException {
        int[] i = new int[]{0,2,0,2,10,1,1};
        int result = 0 ;
        for (int l = 0; l < i.length; l++) {
            result = result ^ i[l];
            System.out.println(result);
        }
        System.out.println(result);

    }

    /*给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。*/
    @Test
    public void test04(){
        int[] arr  = new int[]{1,2,3,4,5,5,5,5,2,2,2,23,3,4,3,3,4,4,5,6,7,8,8,7,6,6,5,4,3,2,1,2,3,3,4,5,1,2,3,4,5,6,7,8,9,0,0,8,3,37,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7};
        int num = arr[0],count =1;
        for (int i = 1; i < arr.length; i++) {
            if (num == arr[i]){
                ++count;
            }else if (--count == 0 ){
                num = arr[i];
                count = 1;
            }

        }
        System.out.println(count);
        System.out.println(num);
    }

    /*给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
        进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。*/
    @Test
    public void test05(){
        int [] nums= new int []{4,5,3,4,4,1,0,-1,-2,4,6,7,8,4};
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1){
            list.add(nums[0]);
        }else if (nums.length == 2){
            if(nums[1] == nums[0]){
                list.add(nums[1]);
            }else{
                list.add(nums[0]);
                list.add(nums[1]);
            }
        }else if (nums.length>2){
            int res1 = nums[0],res2 =nums[0],count1= 1 , count2=1;
            for (int i =1; i < nums.length; i++) {
                if (nums[i]==res1){
                    count1++;
                }else if (nums[i]==res2){
                    count2++;
                }else if (count1==0){
                    res1 = nums[i];
                    count1 =1 ;
                }else if (count2 ==0){
                    res2 = nums[i];
                    count2 =1 ;
                }else {
                    count1--;
                    count2--;
                }
            }
            //判断数组中是否存在两个数出现的次数超过了1/3
            count1=0;
            count2=0;
            for (int num : nums) {
                if (num == res1){
                    count1++;
                }
                if (num == res2){
                    count2++;
                }
            }
            if (count1 > nums.length/3 && count2 > nums.length/3){
                if(res1 ==res2){
                    list.add(res1);
                }else{
                    list.add(res1);
                    list.add(res2);
                }
            }else if(count1<=nums.length/3 && count2<=nums.length/3){

            }
            else {
                list.add(count1>count2?res1:res2);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test06(){
        long start = System.currentTimeMillis();
        int[] nums  = new int[]{1,2,3,4,5,5,5,5,2,2,2,23,3,4,3,3,4,4,5,6,7,8,8,7,6,6,5,4,3,2,1,2,3,3,4,5,1,2,3,4,5,6,7,8,9,0,0,8,3,37,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,3,4,4,2,24,4,5,6,7,7,7,7,7,7,7,7,7,5,5,6,7,7,7,7,7,7,5,5,4,46,6,7,8,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,5,5,4,4,4,4,7};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = 0 ;
            for (int j : nums) {
                if (i==j){
                    count++;
                }
            }
            if (count>nums.length/3){
                map.put(i,count);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        System.out.println(list);
        System.err.println(System.currentTimeMillis()-start);
    }
    @Test
    public void test07(){
       String a = "        Aa  Aa         ";
        System.out.println(a.trim());
    }

}
