package com.collection;

import org.junit.Test;

import java.util.*;

/**
 * Description: 集合
 * Collection接口的实现类的对象中添加数据obj时，要求obj所在的类要重写equals()
 * date:2020-08-12 13:07
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */




public class CollectionTest {
    @Test
    public void test1() {
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        c1.add(new Date());
        System.out.println(c1.size());

        Collection c2 = new ArrayList();
        c2.add("asa");
        c2.add("wr");
        c2.addAll(c1);
        System.out.println(c2.size());
        System.out.println(c2);
        c1.clear();
        System.out.println(c1.isEmpty());


    }

    @Test
    public void test2() {
        //contains (object obj)判断当前集合是否包含obj
        //我们在判断时调用obj对象所在类的equals()
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        c1.add(new Date());
        Collection c2 = new ArrayList();
        c2.add("asa");
        c2.add("wr");
        c2.addAll(c1);
        boolean contains =c1.contains("a");
        System.out.println(contains);
        System.out.println(c1.containsAll(c2));//判断c2中所有元素是否存在于当前集合中


    }
    @Test
    public void test3() {
        //remove（object obj）从当前集合中移除obj元素
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        Collection c2 = new ArrayList();
        c2.add("asa");
        c2.add(123);
        c2.addAll(c1);
        System.out.println(c1);
//        c1.remove(123);
//        removeAll()   差集
//        c2.removeAll(c1);
//        retainAll() 交集
//        equals(object obj):要想返回true 当前集合和形参集合包含的元素相同
        System.out.println(c1.equals(c2));
        c2.retainAll(c1);
        System.out.println(c1);
        System.out.println(c2);

    }
    @Test
    public void test4() {
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        Collection c2 = new ArrayList();
        c2.add("asa");
        c2.add(123);
        c2.addAll(c1);
        System.out.println(c1.hashCode());//返回当前对象的哈希值
//        集合-->数组：array()
        Object[] arr=c1.toArray();
//        拓展：数组-->集合 调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"ad", "ada", "qq"});
        System.out.println(list.size());//1


        List<int[]> list1 = Arrays.asList(new int[]{12,65,66,56});//注意 int改为 Integer
        System.out.println(list1.size());//2



    }
    //Iterator() 返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中
//    Iterator迭代器接口 迭代器模式
    //1.内部的方法 hasNext next
//    2.每调用iterator()方法会生成一个新的迭代器对象 默认游标在集合第一个元素之前
//    3.内部定义了remove() 可以在遍历的时候删除集合中元素，不同与集合直接调用remove()

    @Test
    public void test5() {
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        Iterator iterator = c1.iterator();

//        方式1：
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

//        方式2：不推荐
        for (int i = 0; i <c1.size() ; i++) {
            System.out.println(iterator.next());
        }

//         方式3：推荐
        while(iterator.hasNext()){//hasNext是否还有下一个值
            System.out.println(iterator.next());//next() ①指针下移 ②将下移以后集合位置上元素返回
        }

//         错误方式1
        while(iterator.next()!=null)        {
            System.out.println(iterator.next());//next() ①指针下移 ②将下移以后集合位置上元素返回
        }

//        错误方式2     每调用一次iterator() 会生成一个性的迭代器对象
        while(c1.iterator().hasNext())        {
            System.out.println(c1.iterator().hasNext());//next() ①指针下移 ②将下移以后集合位置上元素返回
        }

    }

    @Test//iterator中 remove()
    public void test6() {
        Collection c1 = new ArrayList();
        c1.add("aa");
        c1.add(123);
        Iterator iterator = c1.iterator();
//          s删除集合中"aa"
        while(iterator.hasNext()){//hasNext是否还有下一个值
            Object obj=iterator.next();
            if("aa".equals(obj)){
                iterator.remove();
            }
        }
        //遍历
        iterator =c1.iterator();
        while(iterator.hasNext()){//hasNext是否还有下一个值
            System.out.println(iterator.next());//next() ①指针下移 ②将下移以后集合位置上元素返回
        }

    }



}
