package com.myself.test.two;

import com.alibaba.fastjson.JSONObject;
import com.myself.utils.ExcelParse;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/8/7 15:05
 */
public class test {
    public static Map<String, String> rules;

    static {
        rules = new HashMap<>();
        rules.put("companyName", "甲方公司名称");
        rules.put("signDate", "YYYY-MM-DD");
        rules.put("openBank", "开户行");
        rules.put("loginName", "账户名称");
        rules.put("account", "账号");
        rules.put("correspondentNo", "联行号");
        rules.put("startYear", "YYYY");
        rules.put("startMonth", "MM");
        rules.put("startDay", "DD");
        rules.put("endYear", "yyyy");
        rules.put("endMonth", "mm");
        rules.put("endDay", "dd");
        rules.put("location", "甲方盖章位置");
        rules.put("address", "乙方盖章位置");
    }

    public  void test() {
        String[] s1 = {"1", "2"};
        long l = System.currentTimeMillis();
        System.err.println(l);
        List<String> list = Stream.of("11", "22", "22", "22", "22", "23", "33", "33").filter(s -> !s.equals("11")).filter(s -> s.contains("2")).collect(Collectors.toList());
//        List<String> collect = Stream.of("11", "22", "22", "22", "22", "23", "33", "33").filter(s -> !s.equals("11")).filter(s -> s.contains("2")).limit(1).collect(Collectors.toList());
//        Stream.of(s1).collect()
        /*forEach*/
//        list.forEach(s -> System.out.println("六十" + s));
        /*for*/
//        for (String s : collect) {
//
//        }
    }

    public  void demo(String path) throws Exception {
        ExcelParse excelParse = new ExcelParse();
//        excelParse.parse(path);
    }

    public void main(String[] args) throws Exception {
//        test();
        long l = System.currentTimeMillis();
        demo("D:\\img\\test.xlsx");
        long l1 = System.currentTimeMillis();
        long l2 = l1 - l;
        System.out.println(l2 / 1000);
    }

    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        map.put("4", "44");
        map.put("5", "55");
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(map.get(string));
        }
        strings.forEach(o -> System.out.println(map.get(o)));
    }

    public boolean test01() {
        String license = "1111111111";
        if (StringUtils.isEmpty(license)) {
            return false;
        }
        if (license.length() != 18) {
            return false;
        }

        String regex = "^([159Y]{1})([1239]{1})([0-9ABCDEFGHJKLMNPQRTUWXY]{6})([0-9ABCDEFGHJKLMNPQRTUWXY]{9})([0-90-9ABCDEFGHJKLMNPQRTUWXY])$";
        if (!license.matches(regex)) {
            return false;
        }
        String str = "0123456789ABCDEFGHJKLMNPQRTUWXY";
        int[] ws = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
        String[] codes = new String[2];
        codes[0] = license.substring(0, license.length() - 1);
        codes[1] = license.substring(license.length() - 1, license.length());
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += str.indexOf(codes[0].charAt(i)) * ws[i];
        }
        int c18 = 31 - (sum % 31);
        if (c18 == 31) {
            c18 = 'Y';
        } else if (c18 == 30) {
            c18 = '0';
        }
        if (str.charAt(c18) != codes[1].charAt(0)) {
            return false;
        }
        return true;
    }

    @Test
    public void test14() {
     String json = "param={\"code\":\"0\",\"contractId\":\"5fe15d2137cc1db2d23c4f76\",\"des\":\"成功\",\"nowFileId\":\"285473257239232512\",\"state\":\"1\"}";
        json = json.replace("param=", "");
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject.getString("code"));
        System.out.println(json);
    }
    @Test
    public void test13() {
        //验证算法题一
        int[] ints = new int[]{3,2,4};
        for (int i : twoSum(ints, 6)) {
            System.out.println(i);
        }

    }

    /**
     * 算法题一：给定一个整数 一个数组
     * 找出这个数组两个数的和等于这个整数的 索引
     *
     * @author      xzj
     * @createDate  2020/12/21 14:25
     * @param nums :
     * @param target :
     * @return      int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
           int result = target - nums[i];
           if (i == nums.length-1){
               return null;
           }
            for (int n = i+1 ; n < nums.length; n++) {
                System.out.println("n = " + nums[n]);
                if (result == nums[n]){
                    ints[0] = i;
                    ints[1] = n;
                    return  ints;
                }
            }
        }
        return null;
    }

    /**
     * 算法二：求一个整数的二进制数 连续1最长的位数
     * 允许将一个0转化为1
     *
     * @author      xzj
     * @createDate  2020/12/21 14:31
     * @param num :
     * @return      java.lang.Integer
     */
    public Integer reverseBits(int num){
        return 0;
    }



}
