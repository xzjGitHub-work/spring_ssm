package com.myself.test;

import com.myself.dao.AccountDao;
import com.myself.domain.Account;
import com.myself.service.AccountService;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.elasticsearch.common.Table;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AccountTest {

    @Test
    public void findAll() throws Exception {
        //把配置文件变成流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //得到SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //得到SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成接口代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAll();
        System.out.println(list);
    }


    @Test
    public void findAllService() {
        //加载IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        List<Account> list = accountService.findAll();
        System.out.println(list);
    }


    public static void main(String[] args) throws Exception {
//        String time = "2020-02-02 11:11:11";
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = simpleDateFormat1.parse(time);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
//        String format = simpleDateFormat.format(parse);
//        System.out.println(format);
//        System.out.println("请输入1-7的数字：");
//        Scanner sc = new Scanner(System.in);
//        int v = sc.nextInt();
//        boolean result = true;
//        do {
//            switch (v){
//                case 1:
//                    System.out.println("星期一");
//                    result = false;
//                    break;
//                case 2:
//                    System.out.println("星期二");
//                    result = false;
//                    break;
//                case 3:
//                    System.out.println("星期三");
//                    result = false;
//                    break;
//                case 4:
//                    System.out.println("星期四");
//                    result = false;
//                    break;
//                case 5:
//                    System.out.println("星期五");
//                    result = false;
//                    break;
//                case 6:
//                    System.out.println("星期六");
//                    result = false;
//                    break;
//                case 7:
//                    System.out.println("星期七");
//                    result = false;
//                    break;
//                default:
//                    System.out.println("您输入有误！请重新输入");
//                    v = sc.nextInt();
//                    break;
//            }
//        }while (result);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您消费的金额：");
        int v = sc.nextInt();
        int zk = 0 ;
        if (100 <= v && v < 300){
            //价格介于100 到300之间的
            zk = 20;
            v = v - zk;
        }
        if (300 <= v && v < 500){
            //价格介于300 到500之间的
            zk = 80;
            v = v - zk;
        }
        if (500 <= v ){
            //价格大于500
            zk = 150;
            v = v - zk;
        }
        System.out.println("最后的价格是"+v + "得到的折扣是"+zk);

    }

    @Test
    public void test02() {
        String s = formatDouble(88888888D);
//        System.out.println(Double.valueOf());
        System.out.println(s);
        double d = 88888888D;
        System.out.println(d);
        System.out.println(String.valueOf(d));
    }

    private static String formatDouble(double d) {
        NumberFormat nf = NumberFormat.getInstance();
        //设置保留多少位小数
        nf.setMaximumFractionDigits(20);
        // 取消科学计数法
        nf.setGroupingUsed(false);
        //返回结果
        return nf.format(d);
    }

    @Test
    public void test01() {
        String s = "2020-06-05";
        String substring = s.substring(0, 7);
        System.out.println(substring);
    }

    @Test
    public void test03() {
        String s = "你好java";
        System.out.println(s.getBytes().length);
        System.out.println(s.length());
        System.out.println(s.toCharArray().length);
        System.out.println(s.length());
    }

    @Test
    public void test04() {
        String str = "世外桃源居所";
        boolean flag = isSpecialChar(str);
        System.out.println("str包含特殊字符：" + flag);
    }

    @Test
    public void test05() {
        String time = "2020-06-06";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            format.parse("2020-06-06");
            for (byte aByte : time.getBytes()) {
                System.out.println(aByte);
            }
            if (time.getBytes().length != 7) {
                String substring = time.substring(0, 7);
                System.out.println(substring);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;

        }

    }


    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }


    @Test
    public void test06() {
//        Account a = new Account();
//        Account b = new Account();
//        b.setId(1);
//        boolean result = test06(a, b);
//        if (result){
//            System.out.println("成功");
//        }
//
//        System.out.println(a.getId());


        List<String> list = new ArrayList<>();
        list.add("1");
        System.err.println(list.size());
        int a = 1;
        if (!test06(a)) {
            System.out.println("error");
        }
        System.out.println(a);
    }

    public boolean test06(Account a, Account b) {
        a.setId(b.getId());
        if (1 == 1) {
            return false;
        }
        return true;
    }

    public boolean test06(int a) {
        a = a + 1;
        return true;
    }

    /**
     * 方法作用描述：循环实体操作字段
     *
     * @return void
     * @author xzj
     * @createDate 2020/9/22 17:00
     */
    @Test
    public void test08() throws Exception {
        Account account = new Account();
        account.setName("100");
        account.setId(1);
        account.setMoney("100");
        Account o = (Account) encryptBean(account.getClass(), account);
        System.out.println(o);

    }


    public Object encryptBean(Class aClass, Object o) throws Exception {
        Field[] fields = aClass.getDeclaredFields();
        List<Method> setMethods = new ArrayList<>();
        List<Method> getMethods = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            String convert = getConvert(fields[i].getName());
            if (fields[i].getType().toString().contains("java.lang.String")) {
                setMethods.add(aClass.getDeclaredMethod("set" + convert, String.class));
                getMethods.add(aClass.getDeclaredMethod("get" + convert));
            }
        }
        for (int i = 0; i < getMethods.size(); i++) {
            String invoke = (String) getMethods.get(i).invoke(o);
            setMethods.get(i).invoke(o, "1");
        }
        return o;

    }

    public static String getConvert(String str) {
        String first = str.substring(0, 1);
        String after = str.substring(1); //substring(1),获取索引位置1后面所有剩余的字符串
        first = first.toUpperCase();
        after = after.toLowerCase();
        return first + after;
    }

    @Test
    public void test09() throws Exception {
        String papersValidTime = "9999-12";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        Date dateStart = null;
        try {
            dateStart = formatter.parse(papersValidTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            infoBean.setPapersValidTime(dateStart);
        System.out.println(dateStart);

    }

    @Test
    public void test10() {
        List<Account> list = new ArrayList<>();
        Account account = new Account();
        account.setId(1);
        Account account1 = new Account();
        account1.setId(2);
        Account account2 = new Account();
        account2.setId(3);
        Account account3 = new Account();
        account3.setId(4);
        Account account4 = new Account();
        account4.setId(5);
        list.add(account);
        list.add(account1);
        list.add(account2);
        list.add(account3);
        list.add(account4);
        Iterator<Account> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == 1) {
                iterator.remove();
            }
        }


        System.out.println(list);
//        list.stream().peek(val -> {
//            if (val.getId() == 5) {
//                val.setMoney("1000");
//            }
//            if (val.getId() == 2) {
//                val.setName("许兆举");
//            }
//        }).collect(Collectors.toList());
//        System.out.println(list);
        List<Account> list1 = list.stream().filter(val -> val.getId() != 1).filter(val -> val.getId() != 2).collect(Collectors.toList());
//        System.err.println(list);
//        System.err.println(list1);
//        Runnable runnable = () -> list.stream().forEach(val -> {
//            if (val.getId() == 4) {
//                val.setName("许兆举");
//            }
//        });
//        runnable.run();
//        System.out.println(list);

    }

    @Test
    public void test11() throws Exception {
        List<Account> list = getData();


//        for (int i = 0; i < list.size(); i++) {
//            Account account4 = list.get(i);
//            if (i == list.size() -1){
//                System.out.println("最后一个");
//                continue;
//            }
//            for (int i1 = i+1; i1 < list.size(); i1++) {
//                Account account5 = list.get(i1);
//                if (account4.getId() == account5.getId() ){
//                    System.out.println("找到一样的了");
//                }
//            }
//        }
        /*Iterator<Account> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId() ==1 ){
                iterator.remove();
            }
            System.out.println(1);
        }
        Account next = iterator.next();
        System.out.println(next);
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
//        List<Account> collect = list.stream().filter(val -> val.getId() == 1).collect(Collectors.toList());
//        System.out.println(collect);
        list.stream().collect(Collectors.groupingBy(o -> o.getId(),Collectors.groupingBy(o -> o.getName()))).forEach((key, val) -> {
//            if (val.stream().anyMatch(v -> "1".equals(v.getId()))) {
//                val.forEach(item -> item.setLsrqBidStatus("1"));
//            }
            System.out.println(key);
//            val.get();
            if (val.size() > 1){
                System.out.println("此账单有重复数据");
                return;
            }
        });
        System.out.println(list);

    }
    @Test
    public void test12(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int zk = 0 ;
        if (100 <= v && v < 300){
            //价格介于100 到300之间的
            zk = 20;
            v = v - zk;
        }
        if (300 <= v && v < 500){
            //价格介于300 到500之间的
            zk = 80;
            v = v - zk;
        }
        if (500 <= v ){
            //价格大于500
            zk = 150;
            v = v - zk;
        }
        System.out.println("最后的价格是"+v + "得到的折扣是"+zk);
    }

    @Test
    public void test13(){
        System.out.println("请输入1-7的数字：");
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        boolean result = true;
        do {
            switch (v){
                case 1:
                    System.out.println("星期一");
                    result = false;
                    break;
                case 2:
                    System.out.println("星期二");
                    result = false;
                    break;
                case 3:
                    System.out.println("星期三");
                    result = false;
                    break;
                case 4:
                    System.out.println("星期四");
                    result = false;
                    break;
                case 5:
                    System.out.println("星期五");
                    result = false;
                    break;
                case 6:
                    System.out.println("星期六");
                    result = false;
                    break;
                case 7:
                    System.out.println("星期七");
                    result = false;
                    break;
                default:
                    System.out.println("您输入有误！请重新输入");
                    v = sc.nextInt();
                    break;
            }
        }while (result);

    }



    @Test
    public void test14(){
        List<Account> list = getData();
//        /*        List<Person> lst = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(
//                () -> new TreeSet<>(Comparator.comparing(o -> o.getName() + "#" + o.getAge() + "#" + o.getAddress()))),
//                ArrayList::new));*/
//        List<Account> collect = list.stream().filter(o -> o.getId() == 1).collect(Collectors.toList());
//        System.out.println(collect);
        ArrayList<Account> arrayList =
                list.stream().collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId() + "#" + o.getName()))), ArrayList::new));
        if (arrayList.size() != list.size()){
            System.out.println("有重复数据");
        }
        System.out.println(arrayList);

    }
    public static  List<Account> getData(){
        List<Account> list = new ArrayList<>();
        Account account = new Account();
        account.setId(1);
        account.setName("许兆举");
        Account account1 = new Account();
        account1.setId(1);
        account1.setName("许兆举");
        Account account2 = new Account();
        account2.setId(3);
        account2.setName("许兆举");
        Account account3 = new Account();
        account3.setId(4);
        account3.setName("许兆举");
        list.add(account);
        list.add(account1);
        list.add(account2);
        list.add(account3);
        return list;
    }

}
