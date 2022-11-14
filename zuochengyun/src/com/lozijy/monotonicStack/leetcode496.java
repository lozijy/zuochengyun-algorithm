package com.lozijy.monotonicStack;

import java.util.Stack;

public class leetcode496 {
    //题理解错了，讲究做一下,给定两个数组,求数组一中每一个元素在数组二对应下标的元素的下一个更大的元素.
    //创建一个单调栈,左指针i右指针j，每次往单调栈里放左元素
    //基本上过了
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        stack.add(0);
        int i=1;
        int j=1;
        while (!stack.isEmpty()&&j<nums2.length){
            //判断下一个更大的数0对1,1对2
            while (!stack.isEmpty()&&nums1[stack.peek()]<nums2[j]){
                ret[stack.pop()]=nums2[j];
            }
            if(stack.isEmpty()){
                stack.add(i);
            }
            //往栈里放元素保持单调性，借用一个辅助栈
            else if(nums1[stack.peek()]>=nums1[i]){
                stack.add(i);
            }else {
                while (!stack.isEmpty()&&nums1[stack.peek()]<nums1[i]){
                    stack1.add(stack.pop());
                }
                stack.add(i);
                while (!stack1.isEmpty()){
                    stack.add(stack1.pop());
                }
            }
            if(i<nums1.length-1) {
                i++;
            }
            j++;
        }
        //剩下的元素已经没有最大元素了
        while(!stack.isEmpty()){
            ret[stack.pop()]=-1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] int1=new int[]{4,1,2};
        int[] int2=new int[]{1,3,4,2};
        for (int i = 0; i < 3; i++) {
            System.out.println(nextGreaterElement(int1,int2)[i]);
        }
    }
}
