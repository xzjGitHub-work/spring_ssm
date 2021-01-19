package com.myself.Socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2021/1/17 9:29
 */
public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端 发送数据");
// 1.创建 Socket ( ip , port ) , 确定连接到哪里.
        Socket client = new Socket("localhost", 6666);
// 2.获取流对象 . 输出流
        OutputStream os = client.getOutputStream();
// 3.写出数据.
        os.write("你好么? tcp ,我来了".getBytes());
// 4. 关闭资源 .
        os.close();
        client.close();

    }
}
