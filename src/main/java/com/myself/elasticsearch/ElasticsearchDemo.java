package com.myself.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: 作用描述
 * @Author: Administrator
 * @CreateDate: 2020/7/8 10:00
 */
public class ElasticsearchDemo {

    private final static String indexName = "xzjindexbase";

    public String elasticsearchTest() {
        //默认配置Setting.EMpty创建客户端
        TransportClient client = null;
        try {
            //创建数据

            //创建客户端
            client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
            client.prepareIndex(indexName, "student");


        } catch (Exception e) {
            e.printStackTrace();
        }
        client.close();
        return null;
    }
}
