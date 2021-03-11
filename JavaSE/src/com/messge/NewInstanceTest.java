package com.messge;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Random;

/**
 * Description:
 * date:2020-08-15 13:57
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class NewInstanceTest {


    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz= Person.class;
        /*
        newInstance():调用此方法，创建运行时类的对象,内部调用了运行时累的空参构造器的构造方法

        要想此方法正常创建运行时累的对象，要求

        1.运行时类必须提供空参的构造器
        2.空参构造器的访问权限的够，通常设置为public


        在javabean中要求提供一个public的空参构造器，原因
        1.便于通过反射，创建运行时的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
        */
        Person o = clazz.newInstance();
        System.out.println(o);

    }
    @Test//反射的动态性
    public void  test2(){
        int num=new Random().nextInt(3);
        String classpath="";
        switch (num){
            case 0:
                classpath="java.util.Date";
            break;
            case 1:
                classpath="java.lang.Object";
//                classpath="com.java1.Person";
                break;

            case 2:
                classpath="com.java1.Person";
            break;

        }
        try {
            Object obj=getInstance(classpath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Object getInstance(String classpath) throws Exception {
        Class clazz=Class.forName(classpath);

        return clazz.newInstance();

    }




    //    获取运行类的带泛型的父类的泛型
    /*
     代码：逻辑性代码  vs  功能性代码
     */
    @Test
    public void test3(){

        Class clazz= Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameter = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameter.getActualTypeArguments();
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }
//    获取运行时的接口
    @Test
    public void test4(){
        Class clazz= Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.println(c);
        }

    }
}
