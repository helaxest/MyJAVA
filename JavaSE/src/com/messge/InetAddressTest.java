package com.messge;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description:
 * date:2020-08-15 8:30
 *  ip和端口号
 *  ip：
 * 在java类中使用InetAddress类代表ip
 * 本地回路地址127.0.0.1 对应localhost
 *
 * 端口号：正在计算机上运行的程序
 *         要求：不同进程有不同端口号
 *         范围被规定为16为的整数0~65536
 *
 *   端口号与ip地址得出一个网络套接字socket
 *
 *
 *
 *
 *
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1=InetAddress.getByName("192.168.10.14");//实例化
            System.out.println(inet1);

            InetAddress inet2=InetAddress.getByName("localhost");
            System.out.println(inet2);

            System.out.println(InetAddress.getLocalHost());
            inet2=InetAddress.getLocalHost();

            inet2.getHostAddress();//

            inet2.getHostName();//

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
