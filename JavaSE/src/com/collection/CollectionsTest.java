package com.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:Collections：操作collection map 的工具类
 * date:2020-08-13 18:05
 *
 *
 *
 * 面试题：Collections和collection区别？
 *
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */

public class CollectionsTest {
    @Test
    public void test1(){

        List list =new ArrayList();
        list.add(35);
        list.add(5);
        list.add(15);
        list.add(1);
        list.add(25);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        System.out.println(list);
//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.swap(list,5,2);
//        Collections.sort(list);
        int frequency = Collections.frequency(list, 12);
        System.out.println(list);
        System.out.println(frequency);

    }
    @Test
    public void test2(){
        List list =new ArrayList();
        list.add(35);
        list.add(5);
        list.add(15);
        list.add(1);

//        List dest=new ArrayList();     错误方式,报异常IndexOutOfBoundsException: Source does not fit in dest
//        Collections.copy(dest,list);


       List dest=Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);


//        返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);

    }



}
