package com.messge;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Description:
 * Udp的协议网络编程
 * date:2020-08-15 11:44
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class UdpTest {
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str="我是udp方式发送的数据";
        byte[] data=str.getBytes();
        InetAddress inet=InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);
        socket.send(packet);
        socket.close();

    }




    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer=new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();


    }
}
