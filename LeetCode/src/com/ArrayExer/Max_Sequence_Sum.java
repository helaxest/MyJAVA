package com.ArrayExer;

/**
 * Description   53.最大子序和  分治法
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author helaxest
 * @date 2020/09/02  8:25
 * @mail:
 * @since JDK 1.8
 */
public class Max_Sequence_Sum {
    int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = 0;
//i belongs to [0, arr.length) , j belongs to [i, arr.length) 这样，就代表了所有的子序列
//    @Test
//    public void test() {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int sum = 0;
//                for (int k = i; k <= j; k++) {
//                    sum += nums[k];
//                    if (sum > maxSum) {
//                        maxSum = sum;
//                    }
//                }
//            }
//        }
//        System.out.println(maxSum);
//    }
}



