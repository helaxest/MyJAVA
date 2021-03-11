package com.messge;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * date:2020-08-15 10:55
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class TcpTest2 {
/*
            这里涉及异常，用try catch finally处理
 */

    @Test
    public void client() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os=socket.getOutputStream();

        FileInputStream fis=new FileInputStream(new File("输入.jpg"));

        byte[] buffer =new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);

        }
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss=new ServerSocket(9090);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        FileOutputStream fos=new FileOutputStream(new File("输出.jpg"));
        byte[] buffer =new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);

        }
        fos.close();
        is.close();
        socket.close();
    }
}


