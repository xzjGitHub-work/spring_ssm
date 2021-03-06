package com.myself.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author ZJQ
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020-07-13
 */
public class test {

    //获取不重复的
    public static <T> List<T> getWithoutRepetitionElements(List<T> list){
        return list.stream()
                // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                // Set<Entry>转换为Stream<Entry>
                .entrySet().stream()
                // 过滤出元素出现次数大于 1 的 entry
                .filter(entry -> entry.getValue() == 1)
                // 获得 entry 的键（重复元素）对应的 Stream
                .map(entry -> entry.getKey())
                // 转化为 List
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfo a = new UserInfo("a",14,"hn");
        UserInfo b = new UserInfo("a",14,"hb");
        UserInfo c = new UserInfo("b",14,"hn");
        UserInfo d = new UserInfo("ss",14,"hn");
        userInfos.add(a);
        userInfos.add(b);
        userInfos.add(c);
        userInfos.add(d);
//        HashSet<UserInfo> set = new HashSet<UserInfo>(userInfos);
//        System.out.println(set);
//        List<UserInfo> userInfos1 = getWithoutRepetitionElements(userInfos);
//        System.out.println(userInfos1);
        //userInfos集合中的对象的name全部都不是a返回true
        boolean result = userInfos.stream().noneMatch(o -> "a".equals(o.getName()));
        System.out.println("result = "+result);
        //userInfos集合中的对象的name有满足的返回true
        boolean result2 = userInfos.stream().anyMatch(o -> "a".equals(o.getName()));
        System.out.println("result2 = "+result2);
        //userInfos结合中的对象的name全部满足返回true
        boolean result3 = userInfos.stream().allMatch(o -> "a".equals(o.getName()));
        System.out.println("result3 = "+result3);
    }
    @Test
    public void test01(){
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfo a = new UserInfo("a",14,"hn");
        UserInfo b = new UserInfo("a",14,"hb");
        UserInfo c = new UserInfo("b",14,"hn");
        UserInfo d = new UserInfo("ss",14,"hn");
        userInfos.add(a);
        userInfos.add(b);
        userInfos.add(c);
        userInfos.add(d);
        //userInfos集合中的对象的name全部都不是a返回true
        boolean result = userInfos.stream().noneMatch(o -> "a".equals(o.getName()));
        System.out.println("result = "+result);
        //userInfos集合中的对象的name有满足的返回true
        boolean result2 = userInfos.stream().anyMatch(o -> "a".equals(o.getName()));
        System.out.println("result2 = "+result2);
        //userInfos结合中的对象的name全部满足返回true
        boolean result3 = userInfos.stream().allMatch(o -> "a".equals(o.getName()));
        System.out.println("result3 = "+result3);
    }
    @Test
    public void test02(){
        Object o = new Object();
        o = new UserInfo("a",14,"hn");
        if (o instanceof UserInfo){
            System.out.println("1111");
        }
    }

    @Test
    public void test03(){
//        System.out.println(LocalDate.now());
//        LocalDate of = LocalDate.of(2020, 2, 28);
//        int i =0 ;
//        while (LocalDate.now().compareTo(of) != 0){
//            System.out.println(i++);
//            of = of.plusDays(1);
//        }
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " 00:00:00");
                LocalDate of = LocalDate.of(2021, 3, 17);
        System.out.println(of.toEpochDay());
        System.out.println(LocalDate.now().toEpochDay());
        BigDecimal bigDecimal = new BigDecimal("1222");
        BigDecimal bigDecimal1 = new BigDecimal("10000");
        System.out.println(RoundingMode.HALF_DOWN);
        System.err.println(bigDecimal.divide(bigDecimal1,6, RoundingMode.HALF_DOWN).doubleValue());
        System.out.println(Math.log(bigDecimal.divide(bigDecimal1,6, RoundingMode.HALF_DOWN).doubleValue()));
        System.out.println(Math.log(100));

    }

    /**
     * @describe:数组初始化值
     *
     * @author:xzj
     * @createDate:2021/4/26 15:47
     * @param:[]
     * @return:void
     */
    @Test
    public void test04(){
        //int初始化值0
        int[] ints = new int[10];
        System.out.println(JSONObject.toJSONString(ints));
        //String初始化值null
        String[] strings = new String[10];
        System.out.println(JSONObject.toJSONString(strings));
        //Integer初始化值0
        Integer[] integers = new Integer[10];
        System.out.println(JSONObject.toJSONString(integers ));


    }
}
