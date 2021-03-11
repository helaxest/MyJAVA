package com.ArrayExer;

import org.junit.Test;

/**
 * Description:两数之和
 * @date: 2020-08-12 7:51 *
 * @Author helaxest   @mail:
 * @Version
 * @Since JDK 1.8
 */
public class TwoNumSum {

    @Test//暴力解法
    public void Test1() {
        int[] arr = new int[]{5, 8, 6, 7, 3,12};
        int target = 15;

        for (int i = 0; i<arr.length-1 ; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (j>i&&target - arr[i] == arr[j]) {// j>i 保证了 不会重复有效结果

                    System.out.println("[" + i + "," + j + "]");

                }
            }
        }
    }
}
