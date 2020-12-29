package com.myself.test.one;

import org.jsoup.Jsoup;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/10/20 14:36
 */

public class two {
        public static final String NFT_ELECTRONIC_CONTRACT_SQL= "select nec.serial_number,nec.title,nec.memo,nec.offereeA_name,nec.offereeB_name,nec.CREATE_TIME,nec.start_date,nec.end_date, necc.category_name ,\n" +
                "case nec.state \n" +
                "when 0 then '未签署'\n" +
                "when 2 then '已签署'\n" +
                "else '异常合同' end as state\n" +
                "from nft_electronic_contract nec \n" +
                "left join nft_electronic_contract_category necc on nec.contranct_id = necc.category_id";
        public static void main(String[] args) throws Exception {
                String path = two.class.getClassLoader().getResource("log4j.properties").getPath();
                System.out.println(NFT_ELECTRONIC_CONTRACT_SQL);
        }
}
