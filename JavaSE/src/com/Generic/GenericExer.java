package com.Generic;

import java.util.*;

/**
 * Description:泛型嵌套
 *
 * @author helaxest
 * @date 2020/10/17  17:09
 * @mail:
 * @since JDK 1.8
 */
public class GenericExer {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<>();
        ArrayList<Citizen> list = new ArrayList<>();
        list.add(new Citizen("刘恺威"));
        list.add(new Citizen("杨幂"));
        list.add(new Citizen("小糯米"));
        map.put("刘恺威", list);
        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<Citizen>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<Citizen> value = entry.getValue();
            System.out.println("户主：" + key);
            System.out.println("家庭成员：" + value);
        } }
}
class Citizen{
    String name;

    public Citizen(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                '}';
    }
}
