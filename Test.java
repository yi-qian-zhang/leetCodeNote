package com.zyq;

import java.util.Arrays;

/**
 * @author clap of thunder
 * @date 2023-10-08 15:33
 * @description
 */
public class Test {
//    public static void main(String[] args) {
//        int[]nums = {
//                2,3,1,2,4,3};
//        int target =7;
//        int[]nums1={1,1,1,1,1,1,1,1};
//        int target1=11;
//        System.out.println(minSubArrayLen(target,nums));
//        System.out.println(minSubArrayLen(target1,nums1));
//    }
public static void main(String[] args) {
    int n=3;
    int[][] generateMatrix = generateMatrix(3);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(generateMatrix[i][j] + " ");
        }
        System.out.println();
    }
}
    public static int minSubArrayLen(int target, int[] nums) {

        int res = nums.length;
        //数组非空
        int left = 0;
        // int right = left;
        int sum = 0;
        int ArraySum = 0;
        int temp;
        int right = 0;
        //特殊情况：target大于数组内总和
        while (right < nums.length) {
            sum += nums[right];//得到了sum的值
            right++;
        }
        if (nums.length <= 0 || sum < target) {
            return 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                 ArraySum+=nums[i];
            }
//            for (right = 0; right < nums.length; right++) {
//
//                ArraySum += nums[right];//得到了sum的值
//                while (ArraySum >= target) {
//                    temp = right - left + 1;
//                    if (temp < res) {
//                        res = temp;
//                    }
//                    ArraySum -= nums[left];
//                    left++;
//                }
//            }
        }
        return res;
    }

//    public static int[][] generateMatrix(int n) {
//        int up=0;int off=n-1;int left=0;int right=n-1;
//        int[][]res = new int[n][n];
//        int temp=1;
//        while(temp<=n*n){
//            for(int i=left;i<=right;i++){
//                res[up][i]=temp;
//                temp++;
//            }
//            up++;
//            for(int i=up;i<=off;i++){
//                res[i][right]=temp;
//                temp++;
//            }
//            right--;
//            for(int i=right;i>=left;i--){
//                res[off][i]=temp;
//                temp++;
//            }
//            off--;
//            for(int i=off;i>=up;i--){
//                res[i][left]=temp;
//                temp++;
//            }
//            left++;
//        }
//        return res;
//    }
public static int[][] generateMatrix(int n) {
    int up=0;int off=n;int left=0;int right=n;
    int[][]res = new int[n][n];
    int temp=1;
    while(temp<=n*n){
        for(int i=left;i<right;i++){
            res[up][i]=temp;
            temp++;
        }
        up++;
        for(int i=up;i<off;i++){
            res[i][right-1]=temp;
            temp++;
        }
        right--;
        for(int i=right-1;i>=left;i--){
            res[off-1][i]=temp;
            temp++;
        }
        off--;
        for(int i=off-1;i>=up;i--){
            res[i][left]=temp;
            temp++;
        }
        left++;
    }
    return res;
}
}
