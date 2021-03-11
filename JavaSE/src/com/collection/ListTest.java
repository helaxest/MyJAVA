package com.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Description: Collection 的子接口list
 * ArrayList   作为list接口主要实现类 效率高 安全性低；底层使用Object[],elementData存储
 * LinkedList   对于频繁的插入删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 * Vector 古老实现类 效率低 安全性高;底层使用Object[]，elementData存储
 * <p>
 *
 *     ArrayList源码分析
 * ArrayList jdk7  情况下
 * ArrayList list =new ArrayList（）；//底层创建了创建了10的object[]数组elementData
 * list.add(123);// elementData[0]=new Integer(123);
 * .....
 * list.add(11);如果此次添加导致底层elementData数组容量不够，则扩容
 * 默认情况扩容为原来的1.5倍，同时将原有 的数组复制到性的数组中
 * <p>
 * 结论：建议开发中使用代餐的构造器 ArrayList list =new ArrayList（int capacity）；
 * <p>
 * ArrayList jdk8 的变化
 * ArrayList list =new ArrayList（）；//底层object[]数组elementData初始化为{},并没有创建长度为10的数组
 * list.add(123);// 第一次调用add()；底层才开始创建长度10的数组，并把123存入数组
 * <p>
 *    LinkedList源码分析
 *    LinkedList list=new LinkedList();//内部声明了Node类型的first和last属性，默认值为null
 *    list.add(123);//将123装到Node里，创建了Node对象
 *
 *    其中Node定义为，体现了LinkedList的双向链表
 *       private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 * <p>
 *     vector 源码分析 jdk7和jdk8通过vector()构造器创建对象时，底层创建了长度为10的数组
 *     扩容方面 默认为原来的2倍
 * <p>
 * <p>
 *     面试题 ArrayList LinkedList Vector的异同
 *  * 同： 三个类都是list接口存储数据的特点相同；存储有序的，可重复的数据
 *  * 异：见上面
 *
 *
 *  list中常用方法
 *  增：add(Object obj)
 *  删:remove(int index)/remove(Object obj) 区分
 *  改:set(int index,Object ele)
 *  查:get(it index)
 *  插:add(int index,Object obj)
 *  长度:size
 *  遍历:① Iterator迭代器方式
 *      ②增强for循环
 *      ③普通for循环
 *
 * <p>
 * date:2020-08-13 8:57
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(12);
        list.add(23);
        list.add(13);
        list.add(3);
        list.add(2);
        System.out.println(list);

//        void add(int index,Object obj );//在index位置插入ele元素
        list.add(1,"dad");
        System.out.println(list);
//
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
//        list.add(list1);

        System.out.println(list.size());

        System.out.println(list.get(2));//获取指定index的元素

        System.out.println(list.indexOf(123));//返回obj 在当前集合中首次出现的位置，没有则返回-1
        System.out.println(list.lastIndexOf(3));///返回obj 在当前集合中最后出现的位置，没有则返回-1
        list.remove(3);
        Object obj=list.remove(3);
        list.remove(obj);//返回删除的元素
        System.out.println(obj);
        System.out.println(list);

//        set(int index,Object ele) 设置指定的index位置元素为ele
        list.set(1,"dq");
        System.out.println(list);
//        list subList(int fromIndex ,int toIndex);//返回从fromIndex 到 toIndex位置的左闭右开区间的子集合
        System.out.println(list.subList(1, 5));
        System.out.println(list);
    }
    @Test //遍历
    public void test2(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(12);
        list.add(23);
        list.add(13);
//        方式一
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        方式二 增强for循环
        for(Object obj:list){
            System.out.println(obj);
        }
//        方式三 普通for循环
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));

        }
    }
}
