package com.Generic;

import org.junit.Test;

import java.util.*;

/**
 * Description
 *
 * @author helaxest
 * @date 2020/10/17  19:33
 * @mail:
 * @since JDK 1.8
 */
public class GenericTest {
    @Test
    public void testApple() {
        Apple<String> a1 = new Apple<>("500克");
        Apple<Integer> a2 = new Apple<>(500);
        Apple<Double> a3 = new Apple<>(500.0);
        System.out.println(a1.getClass() + " " + a1.getWeight());
        System.out.println(a2.getClass() + " " + a2.getWeight());
        System.out.println(a3.getClass() + " " + a3.getWeight());
    }

    @Test
    public void testNews() {
        ArrayList<News> list = new ArrayList<>();
        News<String, String, String> n1 = new News<>("标题一二三四五六七二三四五六七", "作者1", "内容1");
        News<String, String, String> n2 = new News<>("标二三四七题五六1五六五六五六五六五六", "作者2", "内容2");
        News<String, String, String> n3 = new News<>("标题3", "作者3", "内容3");

        System.out.println(n1.title == n2.title);
        System.out.println(n1.title == n3.title);
        System.out.println(n2.title == n3.title);

        list.add(n1);
        list.add(n2);
        list.add(n3);

        Iterator<News> iterator = list.iterator();
        for (News O : list) {
            O = iterator.next();
            int index = 10;
            if ((O.title).toString().length() >= index) {
                System.out.println(O + "\n" + (O.title).toString().substring(0, index));
            } else {
                System.out.println(O + "\n" + (O.title).toString());
            }
        }
    }

    @Test
    public void testSalary() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三", 800);
        map.put("李四", 1500);
        map.put("王五",1600);
        map.put("王六", 3000);
        map.put("王七", 2000);
        map.put("王八", 5500);
        map.put("王九", 4000);

        map.replace("张三", 2600);
        System.out.println("张三"+map.get("张三"));
        for (Object O:map.entrySet()){
            System.out.print(O);
            System.out.print("\t");
        }
        System.out.println();

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> It1 = set.iterator();
        Iterator<Map.Entry<String, Integer>> It2 = set.iterator();
               while (It1.hasNext()) {
          map.replace(It1.next().getKey(),It2.next().getValue()+100);
        }
        Iterator<Map.Entry<String, Integer>> It3 = set.iterator();
        while (It3.hasNext()){
            System.out.print(It3.next().getKey());
            System.out.print("\t");
        }
        System.out.println(" ");
        Iterator<Map.Entry<String, Integer>> It4 = set.iterator();
        while (It4.hasNext()){
            System.out.print(It4.next().getValue());
            System.out.print("\t");
        }
        System.out.println();
        Iterator<Map.Entry<String, Integer>> It5 = set.iterator();
        Iterator<Map.Entry<String, Integer>> It6 = set.iterator();
        while(It5.hasNext()&&It5.hasNext()){
            //set 里面数据已经放好了，不会因为迭代器的存在而改变对象顺序,set放置是无序的，一旦set初始化完成，就是是有序的
            // iterator类似指针，特点：一次性，单向性
//            System.out.print(It5.next()==It6.next());//true
//            System.out.print("\t");
            System.out.print((It5.next()).equals(It6.next())); //true
            System.out.print("\t");
        }
    }
}
