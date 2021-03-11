package com.Project2;

/**
 * Description:
 * date:2020-08-17 11:11
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class Customer {
//    用户的属性
    String name;//姓名
    char gender;//性别
    int age;//年龄
    String phone;//电话号码
    String email;//邮箱

//    构造器
    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    //    get/set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



