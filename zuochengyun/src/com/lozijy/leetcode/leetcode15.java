package com.lozijy.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    //三数之和
    //排序+双指针 //-2 ,0 ,1,1
    //排序+双指针超出时间限制，因为我没用到顺序关系
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length-2; first++) {
            if(first!=0&&nums[first]==nums[first-1]){
                continue;
            }
            int tar=-nums[first];
            for (int second = first+1; second < nums.length-1; second++) {
                if((second!=first+1)&&nums[second]==nums[second-1]){
                    continue;
                }
                for (int third = nums.length-1; third >second; third--) {
                    if(third!=nums.length-1&&nums[third]==nums[third+1]){
                        continue;
                    }
                    if(nums[second]+nums[third]==tar){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length-2; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int tar = -nums[first];
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {

                if (nums[second] + nums[third] < tar || ((second != first + 1) && nums[second] == nums[second - 1])){
                    second++;}
                else if (nums[second] + nums[third] > tar || (third != nums.length - 1 && nums[third] == nums[third + 1])) {
                    third--;
                }
                else if (nums[second] + nums[third] == tar) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ret.add(list);
                    second++;
                }
            }
        }

        return ret;
    }
    public static void main(String[] args) {
        int[]ints=new int[]{0,0,0,0};
        threeSum2(ints);
    }

}
