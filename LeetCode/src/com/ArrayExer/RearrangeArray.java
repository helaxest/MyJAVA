package com.ArrayExer;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Description 给你一个数组 nums ，数组中有 2n 个元素，
 * 按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，
 * 返回重排后的数组。
 *
 * @author helaxest
 * @date 2020 08 30 18:42
 * @mail:
 * @since JDK 1.8
 */
public class RearrangeArray {

    Integer[] nums = {1,2,3,4,4,3,2,1};
    int n = nums.length / 2;
    int i;

    @Test
    public void test() {

        LinkedList x = new LinkedList();
        LinkedList y = new LinkedList();
        for ( i = 0; i < nums.length; i++) {
            if (i < n) {
                x.add(nums[i]);
            } else {
                y.add(nums[i]);
            }
        }
        Iterator iterator1 = x.iterator();
        Iterator iterator2 = y.iterator();
        i=0;
        while (iterator1.hasNext()&&iterator2.hasNext()) {
            if(i%2==0){
                nums[i]= (Integer) iterator1.next();
                i++;
            }
            if(i%2!=0){
                nums[i]= (Integer) iterator2.next();
                i++;
            }
        }
        System.out.print("[");
       for(i=0; i<nums.length;i++){

           System.out.print(nums[i]);
           if(i<nums.length-1){
               System.out.print(",");
           }
       }
        System.out.print("]");
    }

}



