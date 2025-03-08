package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(twoSum(nums,target)[0]+""+twoSum(nums,target)[1]);
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i]+nums[j]) == target){
                    int[] temp = {i,j};
                    return temp ;
                }
            }
        }
        return null;
    }
}