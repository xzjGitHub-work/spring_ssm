package com.test.demo02;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2021/2/25 21:32
 */
public class UserInfoTest {
    private String name;

    private Integer age;

    private List<String> property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getProperty() {
        return property;
    }

    public void setProperty(List<String> property) {
        this.property = property;
    }
    public static void main(String[] args) {
        ArrayList<com.myself.test.UserInfoTest> list = new ArrayList<>();
        com.myself.test.UserInfoTest info = new com.myself.test.UserInfoTest();
        info.setName("111");
        info.setAge(10);
        List<String> infoList = new ArrayList<>();
        infoList.add("good");
        infoList.add("veryGood");
        infoList.add("veryveryGood");
        info.setProperty(infoList);
        com.myself.test.UserInfoTest info2 = new com.myself.test.UserInfoTest();
        info2.setName("111");
        List<String> infoList2 = new ArrayList<>();
        infoList2.add("good");
        infoList2.add("veryGood");
        infoList2.add("veryveryGood");
        info2.setProperty(infoList2);
        com.myself.test.UserInfoTest info3 = new com.myself.test.UserInfoTest();
        info3.setName("222");
        List<String> infoList3 = new ArrayList<>();
        infoList3.add("good");
        infoList3.add("veryGood");
        infoList3.add("veryveryGood");
        info3.setProperty(infoList3);
        com.myself.test.UserInfoTest info4 = new com.myself.test.UserInfoTest();
        info4.setName("222333");
        List<String> infoList4 = new ArrayList<>();
        infoList4.add("good");
        infoList4.add("veryGood");
        infoList4.add("veryveryGood");
        info3.setProperty(infoList4);
        list.add(info);
        list.add(info2);
        list.add(info3);
        list.add(info4);
//        System.out.println(JSONObject.toJSONString(list));
//Map<Object, List<BillFeeVO>> feeGroup = feeVOList.stream().filter(item->StringUtil.isNotBlank(item.getBizOperator())).collect(Collectors.groupingBy(BillFeeVO::getBizOperator)); // 增加了字段非空过滤
//        Map<List<String>, List<UserInfoTest>> collect = list.stream().filter(o -> !StringUtils.isEmpty(o.getName())).collect(Collectors.groupingBy(UserInfoTest::getName));
        Map<List<String>, List<com.myself.test.UserInfoTest>> collect = list.stream().filter(o -> o.getProperty() != null).collect(Collectors.groupingBy(com.myself.test.UserInfoTest::getProperty));
//        List<UserInfo> collect = list.stream().filter(o -> !StringUtils.isEmpty(o.getName())).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));
        System.out.println(collect.toString());
//        Map<String, List<UserInfo>> collect = list.stream().collect(Collectors.groupingBy(d -> fetchGroupKey(d) ));
//        System.err.println(JSONObject.toJSONString(collect));

    }

}


