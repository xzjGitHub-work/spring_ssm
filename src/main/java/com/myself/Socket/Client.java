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
        // 读取服务端返回的信息
        InputStream stream = client.getInputStream();
        byte[] bytes = new byte[100];
        int read = stream.read(bytes);
        System.out.println(new String(bytes, 0, read));
        os.close();
        client.close();

    }

    /**
     * @describe:向服务端传输文件
     * @author:xzj
     * @createDate:2021/2/1 11:25
     * @param:[args]
     * @return:void
     */
    @Test
    public void test01() throws Exception {
        // 1.创建流对象
        // 1.1 创建输入流,读取本地文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\bg.jpg"));
        // 1.2 创建输出流,写到服务端
        Socket socket = new Socket("localhost", 6666);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //2.写出数据.
        byte[] b = new byte[1024 * 8];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        // 关闭输出流,通知服务端,写出数据完毕
        socket.shutdownOutput();
        System.out.println("文件发送完毕");
        // 3. =====解析回写============
        InputStream in = socket.getInputStream();
        byte[] back = new byte[20];
        in.read(back);
        System.out.println(new String(back));
        in.close();
        // ============================
        // 4.释放资源
        socket.close();
        bis.close();
    }
    /**
     * @describe:测试当读取流数据的时候 当读到最后一行的时候 返回值为负数（-1）
     *
     * @author:xzj
     * @createDate:2021/2/1 14:32
     * @param:[]
     * @return:void
     */
    @Test
    public void test02() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\bg.jpg"));
        byte[] b = new byte[1024*8];
        int len;
        System.out.println(bis.read(b));
        System.out.println(len = bis.read(b));
        while ((len = bis.read(b)) != -1) {
            System.out.println(len = bis.read(b));
        }
        System.out.println(len);
        bis.close();
    }
}
