package com.lozijy.monotonicStack;

import java.util.Stack;

public class Main {
    //在不重复数组中想找到每一个数的右边第一个更大的数的位置，如果没有则返回-1;
    public static int[] findBigger(int [] arr){
        int[] ret = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int cnt=1;
        stack.add(0);
        while(!stack.isEmpty()&&cnt<arr.length){
            if(arr[cnt]<arr[stack.peek()]){
                stack.add(cnt);
            }else {
                ret[stack.pop()]=cnt;
                if(stack.isEmpty()){
                    stack.add(cnt);
                }
            }
            cnt++;
        }
        //现在把栈清空
        while(!stack.isEmpty()){
            Integer integer = stack.pop();
            ret[integer]=-1;
//            if(!stack.isEmpty()){
//                ret[integer]=stack.peek();
//            }else {
//                ret[integer]=-1;
//            }
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
        return ret;
    }
    //有重复元素的情况,我们只找下一个严格更大的元素[3,2,3,4]
    public static int[] findBigger1(int [] arr){
        int[] ret = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int cnt=1;
        stack.add(0);
        while(!stack.isEmpty()&&cnt<arr.length){
            if(arr[cnt]>arr[stack.peek()]){
                stack.add(cnt);
            }else {
                while(!stack.isEmpty()&&arr[cnt]< arr[stack.peek()]){
                    ret[stack.pop()]=cnt;
                }
                stack.add(cnt);
            }
            cnt++;
        }
        //现在把栈清空
        while(!stack.isEmpty()){
            Integer integer = stack.pop();
            ret[integer]=-1;
            }
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
        return ret;
        }


    public static void main(String[] args) {
        int[]ints= new int[]{1000000009};
        int[] left = new int[4];
        int[] right = new int[4];
        System.out.println((ints));
    }
}
