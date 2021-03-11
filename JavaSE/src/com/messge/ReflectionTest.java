package com.messge;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Description: 反射调用运行时类的中指定的结构： 属性 方法  构造器
 * date:2020-08-16 9:40
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */

public class ReflectionTest {
    /*
    如何操作运行时指定的类的属性---掌握
    */
    @Test
    public void  test1() throws Exception {
        Class clazz=Person.class;

//        创建运行时类的对象
        Person p= (Person) clazz.newInstance();
//         1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name =clazz.getDeclaredField("name");
//          2.保证当前属性时可访问的
        name.setAccessible(true);
//          3.获取、设置指定对象的此属性值
        name.set(p,"tom");

        System.out.println(name.get(p));

    }
/*
    如何操作运行时类的指定的方法---掌握
    */
    @Test
    public void  test2() throws Exception {
        Class clazz=Person.class;
//        创建运行时类的对象
        Person p= (Person) clazz.newInstance();
//      1.getDeclaredMethod()  参数1：方法名称 参数2：指名获取方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
//      2.保证当前方法时可访问的
        show.setAccessible(true);
//      3.调用方法的invoke():参数1：方法的使用者 参数2：给方法形参赋值的实参
//        invoke()的返回值即为对应类中调用的方法的返回值
        Object returnValue=show.invoke(p,"CHN");//String nation =p.show("CHN")
        System.out.println(returnValue);

        System.out.println("---------调用静态方法-------");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
//        如果调用运行时类中方法没有返回值，则此invoke()返回Null

//        Object returnVal=showDesc.invoke(null);
        Object returnVal=showDesc.invoke(Person.class);

        System.out.println(returnVal);

    }
    /*
    如何操作运行时类的指定的构造器
    */
    @Test
    public void  test3() throws Exception {
        Class clazz=Person.class;
//        1.获取指定的构造器  getConstructor() ：参数指明否早期的形参列表
        Constructor constructor = clazz.getConstructor(String.class);

//        2.保证此构造器是可以访问的
        constructor.setAccessible(true);

//        调用此构造器建造运行时类的对象
        Person per = (Person) constructor.newInstance("jack");

        System.out.println(per);


    }

}
