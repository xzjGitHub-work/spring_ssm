package com.myself.test.one;


import com.alibaba.fastjson.JSONObject;
import com.myself.domain.Account;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
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
//    public static <T> List<T> getWithoutRepetitionElements(List<T> list){
//        return list.stream()
//                // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
//                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
//                // Set<Entry>转换为Stream<Entry>
//                .entrySet().stream()
//                // 过滤出元素出现次数大于 1 的 entry
//                .filter(entry -> entry.getValue() == 1)
//                // 获得 entry 的键（重复元素）对应的 Stream
//                .map(entry -> entry.getKey())
//                // 转化为 List
//                .collect(Collectors.toList());
//    }
    public static void main(String[] args) {
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfo a = new UserInfo("a", 14, "hn");
        UserInfo b = new UserInfo("a", 14, "hb");
        UserInfo c = new UserInfo("a", 14, "hn");
        userInfos.add(a);
        userInfos.add(b);
        userInfos.add(c);
        List<UserInfo> list = new ArrayList<>();
//        HashSet<UserInfo> set = new HashSet<UserInfo>(userInfos);
        int i = 0;
        List<UserInfo> distinctClass = userInfos.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(userInfo -> userInfo.getName() + ";" + userInfo.getAddress()))), ArrayList::new));
        userInfos.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserInfo::getName))), ArrayList::new));


        List<UserInfo> list2 = userInfos.stream().filter(s -> "a".equals(s.getName())).collect(Collectors.toList());
        for (UserInfo userInfo : list2) {
            System.err.println(userInfo.getName());
        }

//        for (UserInfo userInfo : userInfos) {
//             Boolean result=userInfos.stream().anyMatch(u -> u.getAddress().equals(userInfo.getAddress()));
//            if (!result){
//                list.add(userInfo);
//            }
//            System.out.println(i);
//            i++;
//        }
//        for (UserInfo userInfo : distinctClass) {
//            System.out.println(userInfo.getName());
//        }
//        List<UserInfo> userInfos1 = getWithoutRepetitionElements(userInfos);
//        System.out.println(userInfos1);
    }


    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        for (String s : list) {
            System.out.println(s);
        }
    }
    /*
     * 方法作用描述
     *
     * @author      xzj
     * @createDate  2020/8/14 11:11
     * @param null :
     * @return
     */

    @Test
    public void test01() {
        String id = "NDIyMA==";
        Base64.Decoder decoder = Base64.getDecoder();
        String s1 = new String(decoder.decode(id));
        Base64.Encoder encoder = Base64.getEncoder();
        System.err.println(new String(encoder.encode("4062".getBytes())));
        System.err.println(new String(encoder.encode("WB20180417002110".getBytes())));
        System.out.println(s1);

    }

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void test02() {
//        new StringEncryptor();
//        utWFmXj/yT907T6oG5oexw==

    }

    @Test
    public void test03() {
        String s = "你好sss";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        System.out.println(chars.length);
    }

    /*给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1：
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：
输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。*/
    @Test
    public void test04() throws FileNotFoundException {
//        int[] iArr = {2,4,1};
        int[] iArr = {1, 2, 4};
        System.out.println(maxProfit(2, iArr));
    }

    /*2
[3,2,6,5,0,3]*/

    public int maxProfit(int k, int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 == prices.length) {
                break;
            }
            for (int j = i + 1; j < prices.length; j++) {
                map.put("第" + (i + 1) + "天买入,第" + (j + 1) + "天卖出", prices[j] - prices[i]);
            }
        }
        Set<Map.Entry<String, Integer>> mapEntries = map.entrySet();
        List<Map.Entry<String, Integer>> aList = new LinkedList<>(mapEntries);
        Integer account = 0;
        Collections.sort(aList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> ele1, Map.Entry<String, Integer> ele2) {
                return ele2.getValue().compareTo(ele1.getValue());

            }

        });
        if (aList.size() > k) {
            for (int i = 0; i < k; i++) {
                Map.Entry<String, Integer> entry = aList.get(i);
                if (entry.getValue() > 0) {
                    account = account + entry.getValue();
                }
            }
        } else {
            for (Map.Entry<String, Integer> entry : aList) {
                if (entry.getValue() > 0) {
                    account = account + entry.getValue();
                }
            }
        }
        System.out.println("222");
        return account;
    }

    @Test
    public void test21() {
        Double d = 114.899999;
//        d = d * 10000;
//        d = Double.parseDouble(d.intValue() + "");
//        System.out.println(d/10000);

//        System.err.println(Math.round(d * 100) / 100);
//        DecimalFormat format = new DecimalFormat("#.00");
//        System.err.println(format.format(d));
        d = d * 100;
        System.out.println(d);
        System.out.println(Double.parseDouble(d.intValue()+ "") /100);
    }
}

