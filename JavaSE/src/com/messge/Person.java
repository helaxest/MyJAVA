package com.messge;

/**
 * Description:
 * date:2020-08-15 13:58
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class Person {
    private String name;
    int age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }
    private  static void showDesc(){

        System.out.println("你好");
    }
}
