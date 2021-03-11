package com.messge;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:实现TCP网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台
 * date:2020-08-15 9:34
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class TcpTest {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
//            1.创建socket对象，指明服务器短的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8889);
//            2.获取有关输出流，用于输出数据
            os = socket.getOutputStream();
//          3.写出数据的操作
            os.write("你好，我是客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            4.资源的关闭

            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void server() {
//
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
//            1.创建服务端的ServerSocket：指明自己的端口号
            ss = new ServerSocket(8889);
//            2.请用accept()表示接收客户端的socket
            socket = ss.accept();
//            3.获取输入
            is = socket.getInputStream();
            //  不建议一下写法，可能会乱码
//        byte[] buffer=new byte[200];
//        int len;
//        while((len=is.read(buffer))!=-1){
//            String str=new String(buffer,0,len);
//            System.out.print(str);
//        }
//            4.读取输入流的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {

                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自：" + socket.getInetAddress().getHostName() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}

