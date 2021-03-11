package com.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Description:增强for循环  jdk5.0
 * date:2020-08-12 14:47
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class ForTest {
    @Test
    public void test1(){
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        c1.add(633);
        c1.add(false);
        c1.add(12);
       //for(集合元素类型 局部变量 ：集合对象)
        for(Object obj :c1){
            System.out.println(obj);

        }
    }
    @Test
    public void test2(){
        int[] arr=new int[]{1,2,3,5};
        for(int i:arr){
            System.out.println(i);
        }
    }
    @Test
    public void test3(){
         String[] arr = {"add", "dq", "qf", "free"};
////方式二 普通赋值
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i]="mm";
//
//        }
//方式二 增强for循环
         for(String s:arr){
             s="mm";
         }
        for (int i = 0; i <arr.length ; i++) {

            System.out.println(arr[i]);

        }

    }

}
