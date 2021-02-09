package com.test.demo02;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description: 作用描述
 * @Author: xzj
 * @CreateDate: 2021/2/4 9:44
 */
public class test02 {
//    给定一个整数数组 nums 和一个目标值 k，请实现一个方法判断 nums 中是否存在某个片段（即若干个相连元素）之和等于 k。要求时间复杂度为 O(n)。

   
    public boolean checkSum(int[] nums, int k) {
		//思路：
		//      计算出集合所有元素可能出现和集合 比对集合中是否函数与k相同数据
        boolean result = false;
        boolean resultOne = true;
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> arrayList ;
        while (resultOne) {
            arrayList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                arrayList.add(nums[i]);
                for (int j = i + 1; j < nums.length; j++) {
                    list.add(nums[i] + nums[j]);
                    if (i == nums.length - 2) {
                        arrayList.add(nums[i + 1]);
                        System.err.println(JSONObject.toJSONString(arrayList));
                        if (nums.length > 2) {
                            arrayList.set(0, arrayList.get(0) + arrayList.get(1));
                            arrayList.remove(1);
                            nums = new int[arrayList.size()];
                            for (int i1 = 0; i1 < arrayList.size(); i1++) {
                                nums[i1] = arrayList.get(i1);
                            }
                            System.err.println(JSONObject.toJSONString(arrayList));
                        } else {
                            list.add(arrayList.get(0) + arrayList.get(1));
                            resultOne = false;
                        }
                    }
                }
            }
        }
        System.out.println(JSONObject.toJSONString(list));
        for (Integer integer : list) {
            if (k == integer) {
                result = true;
            }
        }
        return result;
    }


    @Test
    public void test01() {
        int[] nums = new int[]{1, 2, 3,4,5};
        boolean b = checkSum(nums, 100);
        System.out.println(b);

    }


}
