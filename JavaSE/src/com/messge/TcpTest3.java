package com.messge;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * date:2020-08-15 11:19
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class TcpTest3 {
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
//        关闭数据的输出
        socket.shutdownOutput();


        InputStream is=socket.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] bufferr=new byte[1024];
        int len1;

        while((len1=is.read(bufferr))!=-1){

            baos.write(bufferr,0,len);

        }
        System.out.println(baos.toString());


        fis.close();
        os.close();
        socket.close();
        baos.close();
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

        System.out.println("图片传输完成");

        OutputStream os=socket.getOutputStream();
        os.write("你好，已收到".getBytes());


        fos.close();
        is.close();
        socket.close();
        os.close();
    }

}
