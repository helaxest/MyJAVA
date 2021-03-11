package com.messge;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Description:URL的网络编程
 * 1.URL：统一资源定位符，对应互联网的某一资源地址
 * 2.格式：http：//localhost：8080 /example/xxYYcc
 *          协议    主机名   端口号 资源地址  参数列表
 *
 * date:2020-08-15 12:04
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url=new URL("http//localhost:8080/example/xxYYcc");

            System.out.println(url.getProtocol());

            System.out.println(url.getHost());

            System.out.println(url.getPort());

            System.out.println(url.getFile());

            System.out.println(url.getPath());

            url.getQuery();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }




}
