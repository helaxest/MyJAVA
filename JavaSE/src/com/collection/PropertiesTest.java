package com.collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Description:  Properties
 * date:2020-08-13 17:36
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class PropertiesTest {
//    Properties常用来处理配置文件，key和value都是String类型
    public static void main(String[] args) {
        FileInputStream fis= null;
        try {
            Properties pros=new   Properties();
            fis = new FileInputStream("ada.properties");
            pros.load(fis);//加载对应流的文件
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name="+name+","+"password="+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null)
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
