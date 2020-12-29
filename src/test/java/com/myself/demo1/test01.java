package com.myself.demo1;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.jsoup.Jsoup;
import org.junit.Test;

import javax.management.Query;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/10/22 10:40
 */
public class test01 {

    @Test
    public void test0() throws IOException, ParseException {
        int a[][] ={{11,22},{33,44},{22,33}};
        System.out.println(a[1][1]);

    }

    /**
     * 方法作用描述: 判断是否含有特殊字符
     *
     * @param str :
     * @return boolean
     * @author xzj
     * @createDate 2020/9/14 13:25
     */
    public boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
    @Test
    public void test01(){
        String s = "111111111111111111";
        boolean specialChar = isSpecialChar(s);
        System.out.println(specialChar);
    }

    @Test
    public void test02(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key",1);
        jsonObject.put("key",2);
        System.out.println(jsonObject);

    }

    public static Map<String, String> rules;
    static {
        rules = new HashMap<>();
        rules.put("companyName", "公司名称");
        rules.put("openBank", "开户行");
        rules.put("accountName", "账号名称");
        rules.put("account", "账号");
        rules.put("correspondentNo", "联行号");
        rules.put("location", "盖章位置");
    }
    @Test
    public void test03(){
        System.out.println(JSONObject.toJSONString(rules));

    }
    class QueueDemo implements Queue{

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public boolean offer(Object o) {
            return false;
        }

        @Override
        public Object remove() {
            return null;
        }

        @Override
        public Object poll() {
            return null;
        }

        @Override
        public Object element() {
            return null;
        }

        @Override
        public Object peek() {
            return null;
        }
    }

}
