package com.ArrayExer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Description 删除数组中的重复项
 *
 * @author helaxest
 * @date 2020 08 29 22:32
 * @mail:
 * @since JDK 1.8
 */
public class DeleteSameNum {
    @Test
    public void test(){
        Integer [] nums={0,0,1,1,1,2,2,3,3,4};
        HashSet hashSet=new HashSet();

        for (Object obj:nums) {
         hashSet.add(obj);
        }
        Iterator iterator=hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }

}
