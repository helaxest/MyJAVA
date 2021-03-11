package com.collection;

import org.junit.Test;

import java.util.*;

/**
 * Description:  Map接口
 *  Map：双列数据 存储 key-value 对的数据  ---------类似与y=f（x）
 *          HashMap：作为Map的主要实现类,线程不安全的，效率高，可以存储Nul的key-value
 *                LinkHashMap:保证在遍历Map元素可以按照添加顺序遍历
 *                原因：原有的HashMap的基础上，添加了一对指针，指向前一个和后一个元素
 *                对于频繁的遍历操作，此类执行效率高于HashMap
 *          TreeMap:保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序和定制排序
 *          底层使用红黑树
 *          HashTable:作为古老的实现类，线程安全 效率低，不可以存储Nul的key-value
 *              Properties:常用来处理配置文件 key-value 都是String类型
 *
 *      HashMap底层 ：数组+链表       jdk7之前
 *                    数组+链表  +红黑树 jk8
 *
 * 面试题：
 * 1.HashMap底层实现原理
 * 2.HashMap与HashTable的异同？
 * 3.CurrentHashMap与HashMap的异同？
 *
 *      Map中的key：无序的 ，不可重复的 ，使用set存储所有的key ----->key所在的要重写equals()和hashCode()    //以HasMap为例
 *      Map中的value：无序的 ，可重复的 ，使用collection存储所有的value ---->value所在的类要重写equals()
 *      一个键值对：key-value构成了一个Entry对象
 *      Map中的Entry：无序的，不可重复的 ，使用set存储所有的Entry
 *
 *   HashMap的底层实现原理？ jdk7
 *    HashMap map =new HashMap();
 *    在实例化以后 ，底层创建长度时16的一维数组Entry[] Table
 *    ...可能执行多次put..
 *    map.put(key1,value1): 首先，调用key1所在类的hashCode() 计算key1的值，此哈希值经过某种算法计算后，得到在Entry数组中的存放位置
 *   如果此位置上数据为空，此时的key1-value添加成功
 *   如果此位置上数据不为空，意味着此位置上存在一个或者多个数据（以链表存在），比较key1和已经存在一个或者多个数据的哈希值
 *
 *   如果key1与已存在的数据的哈希值都不相同，此时key1-value1添加成功 ---情况1
 *   如果key1与已存在某个的数据(key2-value2)的哈希值相同，继续比较:调用key1的所在类的equals(key2)
 *      如果equals()返回false：此时key1-value1添加成功--情况2
 *      如果equals()返回true：使用value1替换value2--情况3
 *
 *      补充：关于情况2和情况3：此时key1-value1和原来数据以链表的方式存储
 *
 *      在不断的添加过程中，会涉及扩容问题，当超出临界值（且存放的位置不为空 ）默认的扩容方式：扩容为原来的2倍，并将原有的数据封住过来
 *
                jdk8与jdk7在底层实现方面不同
 *    1.new HashMap();底层是没有创建长度为16的数组
 *    2.jdk8底层数组是Node[] 而非Entry[]
 *    3.首次调用put()方法，底层创建长度为16的数组
 *    4.jdk7底层结构：数组+链表   jdk8中底层结构：数组+链表+红黑树
 *      当数组某个索引微商以链表形式存在色数据个数>8且当前数组长度>64,
 *      此时此索引位置上的所有数据改为使用红黑树存储
 *
 *
 *      LinkedHashMap底层原理(了解)
 *      //源码
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;//能够记录添加元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *
 *
 *
 *
 *   Map接口中的方法
 *   添加：put (Object key,Object value);
 *   删除：remove(Object key)
 *   修改：put(Object key,Object value)
 *   查询：get(Object key)
 *   长度：size()
 *   遍历:keySet()/values()/entrySet()
 *
 *
 *
 *
 *
 * date:2020-08-13 14:48
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class MapTest {
    @Test//添加、删除、修改
    public void test1(){
        Map map =new HashMap();
        map.put(null,9);//添加
        map.put("la",9);
        map.put("l",9);
        map.put("ad",9);
        System.out.println(map);

        map.put("ad",98);//修改



        System.out.println(map);

//      移除
        Object obj= map.remove("la");//remove(object key)
        System.out.println(obj);
        System.out.println(map);

//        clear()
        map.clear();
        System.out.println(map);

    }
    @Test//查询操作
    public void test2(){
        Map map =new HashMap();
        map.put(null,9);//添加
        map.put("la",9);
        map.put("l",9);
        map.put("ad",9);
        System.out.println(map.get("l"));
//        map.containsKey(object key)
        System.out.println(map.containsKey("ad"));
//      map.containsValue(object value)
        System.out.println(map.containsValue(9));
//      isEmpty() 判断map是否为空
        System.out.println(map.isEmpty());

//        equals() 判断当前map和参数对象obj是否相等


    }
/*

 */

    @Test
    public void test3(){
        Map map =new HashMap();
        map.put("d",9);//添加
        map.put("la",6);
        map.put("l",8);
        map.put("ad",1);
//        遍历所有的key  keySet()
        Set set=map.keySet();
        Iterator  iterator=set.iterator();
        while( iterator.hasNext()){

            System.out.println(iterator.next());
        }

//         遍历所有的value values()
        Collection collection=map.values();
      for(Object obj:collection ){
          System.out.println(obj);
      }
//         遍历所有的key-value    entrySet()
//        方式一

        Set entrySet=map.entrySet();
        Iterator  iterator1=entrySet.iterator();
        while( iterator1.hasNext()){
            Object obj=iterator1.next();
            Map.Entry entry= (Map.Entry) obj;
            System.out.println(entry.getKey()+"--->  "+entry.getValue());
        }
//        方式二
        Set KeySet=map.keySet();
        Iterator  iterator2=KeySet.iterator();
        while( iterator2.hasNext()){
            Object key=iterator2.next();
            Object value=map.get(key);

            System.out.println(key+ "====>  "+value);
        }



    }

}
