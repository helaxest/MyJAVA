package com.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author helaxest
 * @date 2020/10/17  16:02
 * @mail:
 * @since JDK 1.8
 */
public class GenericMethod {

    public static <E>List <E>add(E[] arr){
        ArrayList<E> list=new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }
        return list;
    }
}
