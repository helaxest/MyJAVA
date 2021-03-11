package com.collection;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *          Collection子接口set
 *          set接口：存储无序 不可重复的数据  ---->数学中的集合
 *          Hashset ：作为Set接口主要实现类：线程不是安全的，可以存储null
 *                  linkHashSet：作为HashSet的子类，遍历内部数据，可以按照添加的
 *                  频繁遍历操作linkHashSet比Hashset
 *          TreeSet：可以按照添加对象的指定属性，进行排序
 *
 *         set接口中没有定义额外的新方法，使用的都是Collection中声明过的方法
 *         要求 向set里添加的数据，器所在的类必须重写equals()和hashCode()方法
 *              重写的equals()和hashCode()方法要保持一致性；相等的对象必须为相等的散列码
 *
 *
 * date:2020-08-13 11:04
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class SetTest {
    /*
    一、set 无序性 ，不可重复性。
    1.无序性：不等于随机性，存储的数据在底层数组中并非按照数组索引的顺序添加，二十根据数据的hash值添加

    2.不可重复性：保证添加的元素按照equals()判断，不能返回true，即相同的元素只能添加一个。

    二、添加元素的过程：
    向HashSet中添加元素a，首先调用元素a所在类的HashCode()方法，计算元素a的hash值
    此哈希值接着通过某种算法计算出HashSet底层数组中的存放位置（即 索引位置），判断数组在此位置上是否有元素
    如果此位置没有元素，则元素a添加成功
    如果此位置上有其他元素b（或者以链表存在的多个元素），则比较元素a 与元素b的hash值：
     哈希值不相同 则a成功
     相同进而掉元素a的equals（）方法
      equals返回true 则元素a添加失败
      equals返回false 则元素a添加成功
      jdk7：元素a放到数组中，指向原来的数组
      jdk8：原来的元素放到数组中，指向元素a

      七上八下
      HashSet底层：数组+链表的结构
     */
    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(46);
        set.add("dad");
        set.add(22);
        set.add(42);
        set.add(4);
        set.add(41);
        System.out.println(set);


    }
    @Test//LinkedHashSet的使用
//    LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前后顺序
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(46);
        set.add("dad");
        set.add(22);
        set.add(42);
        set.add(4);
        set.add(41);
        System.out.println(set);


    }
    /*
    1.向TreeSet中添加数据，要求时相同类的对象
    2.两种排序 自然排序(实现CompareTo接口) 定制排序

    3.自然排序中，比较两个对象是否相同标准为compareTO() 返回0 ，不再是equals()
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()
     */
    @Test
    public  void test3(){
        TreeSet set=new TreeSet();
//        失败不能添加不同类的对象
        set.add(46);
//        set.add("dad");
        set.add(22);
        set.add(42);
        set.add(4);

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public  void test5(){
        Comparator com=new Comparator() {
//      按照xxx从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        TreeSet set=new TreeSet(com);

    }
}
