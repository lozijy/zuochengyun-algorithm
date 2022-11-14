package com.lozijy.monotonicStack;

import java.util.Stack;

//过了
public class leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int cnt=1;
        stack.add(0);
        int[] mark = new int[nums.length];
        while(!stack.isEmpty()&&cnt<nums.length){
            if(nums[cnt]<=nums[stack.peek()]){
                stack.add(cnt);
            }else{
                while(!stack.isEmpty()&&nums[cnt]>nums[stack.peek()]){
                    int c=stack.pop();
                    ret[c]=nums[cnt];
                    mark[c]=1;
                }
                stack.add(cnt);
            }
            cnt++;
        }
        cnt=0;
        while(!stack.isEmpty()&&cnt<nums.length){
            if(nums[cnt]<=nums[stack.peek()]){
                stack.add(cnt);
            }else{
                while(!stack.isEmpty()&&nums[cnt]>nums[stack.peek()]){
                    int c=stack.pop();
                    ret[c]=nums[cnt];
                    mark[c]=1;
                }
                stack.add(cnt);
            }
            cnt++;
        }
        while(!stack.isEmpty()){
            int c=stack.pop();
            if(mark[c]==0){
                ret[c]=-1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[]ints=new int[]{1,2,1};
    }
}
