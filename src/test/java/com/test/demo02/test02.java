package com.test.demo02;

import com.alibaba.fastjson.JSONObject;
import com.myself.test.UserInfo;
import com.myself.test.UserInfoTest;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        ArrayList<Integer> arrayList;
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
        int[] nums = new int[]{1, 2, 3, 4, 5};
        boolean b = checkSum(nums, 100);
        System.out.println(b);

    }

    //Map<String, List<EntryDeliveryDetailywk>> detailsMap01 = dtos1.stream()
//.collect(Collectors.groupingBy(EntryDeliveryDetailywk::getskuId));
    @Test
    public void test02() {
        ArrayList<UserInfoTest> list = new ArrayList<>();
        UserInfoTest info = new UserInfoTest();
        info.setName("111");
        info.setAge(10);
        List<String> infoList = new ArrayList<>();
        infoList.add("好");
        infoList.add("很好");
        infoList.add("非常好");
        info.setProperty(infoList);
        UserInfoTest info2 = new UserInfoTest();
        info2.setName("111");
        List<String> infoList2 = new ArrayList<>();
        infoList2.add("好");
        infoList2.add("很好");
        infoList2.add("非常好");
        info2.setProperty(infoList2);
        UserInfoTest info3 = new UserInfoTest();
        info3.setName("222");
        List<String> infoList3 = new ArrayList<>();
        infoList3.add("好");
        infoList3.add("很好");
        infoList3.add("非常好");
        info3.setProperty(infoList3);
        UserInfoTest info4 = new UserInfoTest();
        info4.setName("222333");
        List<String> infoList4 = new ArrayList<>();
        infoList4.add("好");
        infoList4.add("很好");
        infoList4.add("不非常好");
        info3.setProperty(infoList4);
        list.add(info);
        list.add(info2);
        list.add(info3);
        list.add(info4);
//        System.out.println(JSONObject.toJSONString(list));
//Map<Object, List<BillFeeVO>> feeGroup = feeVOList.stream().filter(item->StringUtil.isNotBlank(item.getBizOperator())).collect(Collectors.groupingBy(BillFeeVO::getBizOperator)); // 增加了字段非空过滤
//        Map<List<String>, List<UserInfoTest>> collect = list.stream().filter(o -> !StringUtils.isEmpty(o.getName())).collect(Collectors.groupingBy(UserInfoTest::getName));
        Map<List<String>, List<UserInfoTest>> collect = list.stream().filter(o -> o.getProperty() != null).collect(Collectors.groupingBy(UserInfoTest::getProperty));
//        List<UserInfo> collect = list.stream().filter(o -> !StringUtils.isEmpty(o.getName())).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));
//        Map<String, List<UserInfo>> collect = list.stream().collect(Collectors.groupingBy(d -> fetchGroupKey(d) ));
//        System.err.println(JSONObject.toJSONString(collect));



//{
// ["好","很好","不非常好"]
// :[{"name":"222","property":["好","很好","不非常好"]}],
// ["好","很好","非常好"]:
// [{"age":10,"name":"111","property":["好","很好","非常好"]},{"name":"111","property":["好","很好","非常好"]}]}
    }

    public static void main(String[] args) {
        ArrayList<UserInfoTest> list = new ArrayList<>();
        UserInfoTest info = new UserInfoTest();
        info.setName("111");
        info.setAge(10);
        List<String> infoList = new ArrayList<>();
        infoList.add("好");
        infoList.add("很好");
        infoList.add("非常好");
        info.setProperty(infoList);
        UserInfoTest info2 = new UserInfoTest();
        info2.setName("111");
        List<String> infoList2 = new ArrayList<>();
        infoList2.add("好");
        infoList2.add("很好");
        infoList2.add("非常好");
        info2.setProperty(infoList2);
        UserInfoTest info3 = new UserInfoTest();
        info3.setName("222");
        List<String> infoList3 = new ArrayList<>();
        infoList3.add("好");
        infoList3.add("非常好");
        infoList3.add("很好");
        info3.setProperty(infoList3);
        UserInfoTest info4 = new UserInfoTest();
        info4.setName("222333");
        List<String> infoList4 = new ArrayList<>();
        infoList4.add("好");
        infoList4.add("很好");
        infoList4.add("不非常好");
        info4.setProperty(infoList4);
        list.add(info);
        list.add(info2);
        list.add(info3);
        list.add(info4);
//        System.out.println(JSONObject.toJSONString(list));
//Map<Object, List<BillFeeVO>> feeGroup = feeVOList.stream().filter(item->StringUtil.isNotBlank(item.getBizOperator())).collect(Collectors.groupingBy(BillFeeVO::getBizOperator)); // 增加了字段非空过滤
//        Map<List<String>, List<UserInfoTest>> collect = list.stream().filter(o -> !StringUtils.isEmpty(o.getName())).collect(Collectors.groupingBy(UserInfoTest::getName));
        Map<List<String>, List<UserInfoTest>> collect = list.stream().filter(o -> o.getProperty() != null).collect(Collectors.groupingBy(UserInfoTest::getProperty));
//        List<UserInfo> collect = list.stream().filter(o -> !StringUtils.isEmpty(o.getName())).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));
//        Map<String, List<UserInfo>> collect = list.stream().collect(Collectors.groupingBy(d -> fetchGroupKey(d) ));
//        System.err.println(JSONObject.toJSONString(collect));

//        {["好","很好","不非常好"]:[{"name":"222","property":["好","很好","不非常好"]}],
//            ["好","很好","非常好"]:[{"age":10,"name":"111","property":["好","很好","非常好"]},{"name":"111","property":["好","很好","非常好"]}]}
//
//        {["好","很好","不非常好"]:[{"name":"222","property":["好","很好","不非常好"]}],
//            ["好","很好","非常好"]:[{"age":10,"name":"111","property":["好","很好","非常好"]},{"name":"111","property":["好","很好","非常好"]}]}

        //{["好","非常好","很好"]:
        // [{"name":"222","property":["好","非常好","很好"]}],
        // ["好","很好","不非常好"]:
        // [{"name":"222333","property":["好","很好","不非常好"]}],
        // ["好","很好","非常好"]:[{"age":10,"name":"111","property":["好","很好","非常好"]},{"name":"111","property":["好","很好","非常好"]}]}

    }

}
