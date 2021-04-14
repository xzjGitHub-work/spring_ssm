package com.yunqi.xzj.factory.test;

import com.alibaba.fastjson.JSONObject;
import com.yunqi.xzj.factory.bean.UserModel;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 测试工厂模式下
 * @Author: xzj
 * @CreateDate: 2021/2/1 9:25
 */
public class Demo {
    public static final Map<String,Object> mapData = new HashMap<>();
    public static void main(String[] args) throws Exception {
        //把配置文件变成流
        InputStream stream = Demo.class.getClassLoader().getResourceAsStream("test/TestFactoryBean.xml");
        //得到dom4j的操作对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(stream);
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.elements("bean");
        System.out.println(list.size());
        for (Element element : list) {
            mapData.put(element.attributeValue("id"),Class.forName(element.attributeValue("class")).newInstance());
        }
        UserModel userModel = (UserModel)mapData.get("UserModel");
        System.out.println(userModel.getUserModel());
        System.out.println(stream);
    }


    @Test
    public void test01(){
        List<String> list = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        listTwo.add("1111");
        list.add("http://172.16.68.195:8901");
        System.out.println(list.stream().noneMatch("http://172.16.68.195:8901/"::contains));
        Map<String, List<String>> map = new HashMap<>();
        map.put("list",list);
        map.put("listTwo",listTwo);
        map.forEach((key,list1) ->{
            for (String s : list1) {
                System.out.println(s);
            }
        });
    }
}
