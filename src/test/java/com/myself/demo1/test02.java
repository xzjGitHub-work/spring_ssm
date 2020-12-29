package com.myself.demo1;

import com.myself.util.DateUtils;
import com.myself.util.EmptyUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/11/16 16:28
 */
public class test02 {
    @Test
    public void demo01() {
        Map<String, String> map = new HashMap<>();
        map.put("Aa", "Aa");
        map.put("BB", "BB");
        map.put("C#", "C#");
        String s = "AA";
        System.out.println(s.equalsIgnoreCase("aa"));
        System.out.println(s.equals("aa"));
    }


    @Test
    public void demo02() {
        for (int i = 0; i < 6; i++) {
            System.out.println(1);
            if (1 == 1) {
                if (2 > 1) {
                    continue;
                }
            }
            System.out.println(2);
        }
    }

    @Test
    public void demo03() throws ParseException {
        String str = "yyyy-MM-dd HH:mm:ss:SSS";
        String str2 = "yyyy-MM-dd HH:mm:ss:SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        System.out.println(simpleDateFormat.format(new Date()));
//        Date date = simpleDateFormat.parse("2020-09-10");
        Date date = simpleDateFormat.parse("2020-11-20 11:31:03:426");
        System.out.println(date);
    }

    public static void main(String[] args) {
        String str = StringEscapeUtils.unescapeHtml4("&lt;p&gt;【产品名称】艾酷维多种维生素锌软糖&lt;/p&gt;");
        System.out.println(str);
        String str2 = StringEscapeUtils.escapeHtml4("<p>【产品名称】艾酷维多种维生素锌软糖</p>");
        System.out.println(str2);
        if (null == null) {
            System.out.println(11);
        }
    }


    @Test
    public void demo04() throws Exception {
        File file = null;
        try (FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\img\\2.jpg"));) {
        } catch (Exception e) {
            System.out.println("报错了");
        }
    }

    @Test
    public void demo05() throws Exception {

        try(FileInputStream fileInputStream = new FileInputStream(new File(""))){

        }
        catch(Exception a){
            System.out.println("try catch结束会自动的关闭流");
        }

        try{
            FileInputStream fileInputStream = new FileInputStream(new File(""));
        }
        catch(Exception e){
            System.out.println("这样需要手动的关闭");

        }
    }


    public static byte[] getByteByFile(File file) throws Exception {
        byte[] buffer = null;
        try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return buffer;
    }
    @Test
    public void test09(){
        Calendar instance = Calendar.getInstance();
        instance.set(2020,9,10);
        Date time = instance.getTime();
        System.out.println(DateTimeFormatter.ISO_WEEK_DATE);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//        TemporalAccessor temporalAccessor = new TemporalAccessor();
//        dateTimeFormatter.format(instance.get);
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(DateTimeFormatter.ISO_WEEK_DATE);
        Date date = DateUtils.asDate(LocalDateTime.now());
        System.out.println(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd");
        dateFormat.format(new Date());
    }


    @Test
    public void test10(){
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd");
        System.out.println(dateFormat.format(date));
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);

String s ="select " +
        "nec.serial_number," +
        "nec.title," +
        "nec.memo," +
        "nec.offereeA_name," +
        "nec.offereeB_name," +
        "nec.CREATE_TIME," +
        "nec.start_date," +
        "nec.end_date, " +
        "necc.category_name" +
        "from nft_electronic_contract nec" +
        "left join nft_electronic_contract_category necc on nec.contranct_id = necc.category_id";
        System.out.println(s);



    }


    public static String uploadFile(String url , MultipartFile file, String fileParamName, Map<String,String> headerParams) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {
            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(url);
            //添加header
            for (Map.Entry<String, String> e : headerParams.entrySet()) {
                httpPost.addHeader(e.getKey(), e.getValue());
            }
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setCharset(Charset.forName("utf-8"));
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//加上此行代码解决返回中文乱码问题
            builder.addBinaryBody(fileParamName, file.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);// 文件流
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);// 执行提交
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static final String FREIGHT_LIST_FILE_SQL = "SELECT\n" +
            "\tfl.id,\n" +
            "\tfl.supplier_name AS owner_name,\n" +
            "\tfl.channel,\n" +
            "\tfl.order_no,\n" +
            "\tfl.waybill_no,\n" +
            "\tfl.child_nos,\n" +
            "\tfl.customer_acct_code,\n" +
            "\tfl.meterage_weight_qty,\n" +
            "\tfl.volume,\n" +
            "\tfl.product_name,\n" +
            "\tfl.quantity,\n" +
            "\tROUND(fl.fee_amt,2) AS feeAmtTemp,\n" +
            "\tfl.pay_discount,\n" +
            "\tROUND(fl.pay_price,2) AS payPriceTemp,\n" +
            "\tfl.receive_discount,\n" +
            "\tROUND(fl.receive_price,2) AS receivePriceTemp, \n" +
            "\t(CASE fl.payment_type_code WHEN '1' THEN '寄付' WHEN '2' THEN '到付' WHEN '3' THEN '第三方付' WHEN '4' THEN '月结' END) as payment_type_code,\n" +
            "\tDATE_FORMAT(fl.generate_date,'%Y-%m-%d') as generate_date,\n" +
            "\tfl.consignor_name,\n" +
            "\tfl.consignor_tel,\n" +
            "\tfl.deliver_place,\n" +
            "\tfl.receiver_name,\n" +
            "\tfl.receiver_tel,\n" +
            "\tfl.receive_place,\n" +
            "\tfl.CREATOR,\n" +
            "\tfl.CREATE_TIME,\n" +
            "\tfl.MODIFIER,\n" +
            "\tfl.MODIFY_TIME,\n" +
            "\tIFNULL( cc.FEE_TYPE_NAME, fl.fee_type_code ) as fee_type_code,\n" +
            "\t(CASE fl.waybill_type WHEN '1' THEN '清单' WHEN '2' THEN '回单' END) as waybillTypeTemp,\n" +
            "\tIF(fl.business_type='00','国网物流','询报价') as business_type,\n" +
            "\t(CASE fl.push_status WHEN '00' THEN '已推送' WHEN '01' THEN '未推送' WHEN '02' THEN '推送失败' END) as push_status,\n" +
            "\tlcs.username as target_platform,\n" +
            "\tfl.supplier_code,\n" +
            "\tfl.pay_account,\n" +
            "\tfl.SOCIAL_CREDIT_CODE\n" +
            "FROM\n" +
            "\tfreight_list fl\n" +
            "LEFT JOIN lsp_cre_sign lcs on fl.target_platform=lcs.from_code\n" +
            "LEFT JOIN cost_comparison cc on fl.fee_type_code = cc.FEE_TYPE_CODE";



    private String supplierContractJoinMsql(FreightListCondition condition) {
        StringBuilder msql = new StringBuilder(FREIGHT_LIST_FILE_SQL);
        msql.append(" WHERE 1=1");
        // 收货人
        if (EmptyUtils.isNotEmpty(condition.getReceiverName())) {
            msql.append(" AND fl.receiver_name LIKE '%").append(condition.getReceiverName()).append("%'");
        }
        // 收货人电话
        if (EmptyUtils.isNotEmpty(condition.getReceiverTel())) {
            msql.append(" AND fl.receiver_tel LIKE '%").append(condition.getReceiverTel()).append("%'");
        }
        // 收货地
        if (EmptyUtils.isNotEmpty(condition.getReceivePlace())) {
            msql.append(" AND fl.receive_place LIKE '%").append(condition.getReceivePlace()).append("%'");
        }
        // 订单号
        if (EmptyUtils.isNotEmpty(condition.getOrderNo())) {
            msql.append(" AND fl.order_no LIKE '%").append(condition.getOrderNo()).append("%'");
        }
        // 运单号
        if (EmptyUtils.isNotEmpty(condition.getWaybillNo())) {
            msql.append(" AND fl.waybill_no LIKE '%").append(condition.getWaybillNo()).append("%'");
        }
        // 发货人
        if (EmptyUtils.isNotEmpty(condition.getConsignorName())) {
            msql.append(" AND fl.consignor_name LIKE '%").append(condition.getConsignorName()).append("%'");
        }
        // 发货人电话
        if (EmptyUtils.isNotEmpty(condition.getConsignorTel())) {
            msql.append(" AND fl.consignor_tel LIKE '%").append(condition.getConsignorTel()).append("%'");
        }
        // 发货地
        if (EmptyUtils.isNotEmpty(condition.getDeliverPlace())) {
            msql.append(" AND fl.deliver_place LIKE '%").append(condition.getDeliverPlace()).append("%'");
        }
        // 开始日期
        if (EmptyUtils.isNotEmpty(condition.getBeginTimeStr())) {
            msql.append(String.format(" AND fl.generate_date >= '%s'", condition.getBeginTimeStr()));
        }
        // 结束日期
        if (EmptyUtils.isNotEmpty(condition.getEndTimeStr())) {
            msql.append(String.format(" AND fl.generate_date <= '%s'", condition.getEndTimeStr()));
        }
        // 推送状态
        if (EmptyUtils.isNotEmpty(condition.getPushStatus())) {
            msql.append(String.format(" AND fl.push_status = '%s'", condition.getPushStatus()));
        }
        // 货主名称
        if (EmptyUtils.isNotEmpty(condition.getOwnerName())) {
            msql.append(" AND fl.owner_name LIKE '%").append(condition.getOwnerName()).append("%'");
        }
        // 所属业务
        if (EmptyUtils.isNotEmpty(condition.getBusinessType())) {
            msql.append(String.format(" AND fl.business_type = '%s'", condition.getBusinessType()));
        }
        msql.append(" ORDER BY fl.generate_date DESC");

        return msql.toString();
    }
    @Test
    public void test11(){
        FreightListCondition freightListCondition = new FreightListCondition();
        freightListCondition.setBeginTimeStr("2020-11-25 00:00:00");
        freightListCondition.setEndTimeStr("2020-12-10 23:59:59");
        String s = supplierContractJoinMsql(freightListCondition);
        System.out.println(s);
    }



}
