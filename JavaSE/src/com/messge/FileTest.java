package com.messge;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Description:
 * File类的使用 废了类的的一个对象代表一个文件或者文件目录
 * 如果涉及读取或写入文件内容必须用到IO流
 * file类的对象会作为参数传递给留的构造器中，指明读取或写入的中点
 *
 * 相对路径 绝对路径
 *
 * 路径分隔符:
 * windows ： \\
 * unix  : /
 *
 *
 *
 * date:2020-08-14 17:22
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class FileTest {
    @Test
    public void test1() {
//        构造器1
        File file1 = new File("hello");
        File file2 = new File("D:\\hello.txt");
        System.out.println(file1);
        System.out.println(file2);

//        构造器2
        File file3 = new File("D:", "test.txt");
        System.out.println(file3);

//         构造器3
        File file4 = new File(file1, "hi.txt");
        System.out.println(file4);


    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getName());
        System.out.println(file1.getParent());
        System.out.println(file2.getName());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

    }


    @Test   //文件目录方法
    public void test3() {
        File file = new File("D:\\eclipse-workplace\\Servers");
//        方法1
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
//        方法2
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    //     file1.renameTo(file2)
//    要想返回true 需要file1 在硬盘中存在，且file2在硬盘中不存在
    @Test
    public void teat3() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);


    }

    /*
     一些常用方法
     */
    @Test
    public void teat4() {
        File file1 = new File("hello.txt");
        System.out.println(file1.isFile());
        System.out.println(file1.isHidden());
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());

    }

    /*
            创建磁盘中的文件或文件目录



            删除磁盘中的文件或文件目录


     */
    @Test
    public void test5() throws IOException {
//        文件的创建和删除
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\Ad\\fr");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        } else {
            file1.delete();
            System.out.println("删除成功");
        }
        System.out.println(file2.mkdir());//方式一 创建目录
        System.out.println(file2.mkdirs());//方式二创建目录

    }

}
