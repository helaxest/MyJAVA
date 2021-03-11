package com.ArrayExer;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Description  35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * @author helaxest
 * @date 2020/09/01  7:55
 * @mail:
 * @since JDK 1.8
 */
public class SearchInsertionLocation {

    //    [1,3,5,6], 5
    int[] arr = new int[]{1, 3, 5, 6};
    int target = 2;
    int index;
    @Test
    public void test1() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(arr[i]);
        }
        Iterator iterator = linkedList.iterator();
        if (linkedList.contains(target)) {
            System.out.println(linkedList.indexOf(target));
        }
        else{
            if(target<arr[0]){
                linkedList.addFirst(target);
               index= linkedList.indexOf(target);
                System.out.println(index);
                return;
            }
            if(target>arr[arr.length-1]){
                linkedList.addLast(target);
                index=linkedList.indexOf(target);
                System.out.println(index);
                return;
            }
            for (int i = 0; i <arr.length ; i++) {
                if(target>arr[i]&&target<arr[i+1]){
                    index=i+1;
                    System.out.println(index);
                }

            }

        }


    }
    @Test
    public void test2() {

            if(target<arr[0]){
                System.out.println(0);
                return;
            }
            if(target>arr[arr.length-1]){
                System.out.println(arr.length-1);
                return;
            }
            for (int i = 0; i <arr.length ; i++) {

                if(target>arr[i]&&target<arr[i+1]){

                    System.out.println(i+1);
                }
                if(target==arr[i]){
                    System.out.println(i);
                }
            }
    }
}


