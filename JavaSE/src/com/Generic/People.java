package com.Generic;

/**
 * Description
 *
 * @author helaxest
 * @date 2020/10/17  15:21
 * @mail:
 * @since JDK 1.8
 */
public class People<T1,T2,T3,T4,T5>{
    T1 id;
    T2 name;
    T3 age;
    T4 mail;
    T5 gender;

    public People() {
    }

    public People(T1 id, T2 name, T3 age, T4 mail, T5 gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", mail=" + mail +
                ", gender=" + gender +
                '}';
    }

    public T1 getId() {
        return id;
    }

    public void setId(T1 id) {
        this.id = id;
    }

    public T2 getName() {
        return name;
    }

    public void setName(T2 name) {
        this.name = name;
    }

    public T3 getAge() {
        return age;
    }

    public void setAge(T3 age) {
        this.age = age;
    }

    public T4 getMail() {
        return mail;
    }

    public void setMail(T4 mail) {
        this.mail = mail;
    }

    public T5 getGender() {
        return gender;
    }

    public void setGender(T5 gender) {
        this.gender = gender;
    }
}
