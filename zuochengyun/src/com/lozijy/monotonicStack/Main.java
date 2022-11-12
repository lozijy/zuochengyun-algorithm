package com.lozijy.monotonicStack;

import java.util.Stack;

public class Main {
    //在不重复数组中想找到每一个数的右边第一个更大的数的位置，如果没有则返回-1;
//    public static int[] findBigger(int [] arr){
//        int[] ret = new int[arr.length];
//        Stack<Integer> stack = new Stack<>();
//        int cnt=1;
//        stack.add(0);
//        while(!stack.isEmpty()&&cnt<arr.length){
//            if(arr[cnt]<arr[stack.peek()]){
//                stack.add(cnt);
//            }else {
//                ret[stack.pop()]=cnt;
//                if(stack.isEmpty()){
//                    stack.add(cnt);
//                }
//            }
//            cnt++;
//        }
//        //现在把栈清空
//        while(!stack.isEmpty()){
//            Integer integer = stack.pop();
//            ret[integer]=-1;
////            if(!stack.isEmpty()){
////                ret[integer]=stack.peek();
////            }else {
////                ret[integer]=-1;
////            }
//        }
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(ret[i]);
//        }
//        return ret;
//    }
//    //有重复元素的情况,我们只找下一个严格更大的元素[3,2,3,4]
//    public static int[] findBigger1(int [] arr){
//        int[] ret = new int[arr.length];
//        Stack<Integer> stack = new Stack<>();
//        int cnt=1;
//        stack.add(0);
//        while(!stack.isEmpty()&&cnt<arr.length){
//            if(arr[cnt]>arr[stack.peek()]){
//                stack.add(cnt);
//            }else {
//                while(!stack.isEmpty()&&arr[cnt]< arr[stack.peek()]){
//                    ret[stack.pop()]=cnt;
//                }
//                stack.add(cnt);
//            }
//            cnt++;
//        }
//        //现在把栈清空
//        while(!stack.isEmpty()){
//            Integer integer = stack.pop();
//            ret[integer]=-1;
//            }
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(ret[i]);
//        }
//        return ret;
//        }



        //对于一个可重复元素的数组中的每一个数找到右边更小或相等的元素和左边严格更小的元素
    public static void find(int [] arr,int[]leftSmaller,int[]rightSmaller){
        Stack<Integer> smallStk = new Stack<>();
        //处理右边更小
        int cnt=1;
        smallStk.add(0);
        while (!smallStk.isEmpty()&&cnt<arr.length){
            if(arr[cnt]<=arr[smallStk.peek()]){
                smallStk.add(cnt);
            }
            else {
                while(!smallStk.isEmpty()&&arr[smallStk.peek()]<=arr[cnt]){
                    rightSmaller[smallStk.pop()]=cnt;
                }
                smallStk.add(cnt);
            }
            cnt++;
        }
        //处理栈中剩余元素，他们已经没有更大的元素了，全部置-1
        while(!smallStk.isEmpty()){
            rightSmaller[smallStk.pop()]=-1;
        }
        cnt-=1;//原来的cnt是arr.length()
        //处理左边,此时cnt已经是arr.length()-1了
        smallStk.add(cnt);
        while (!smallStk.isEmpty()&&cnt>-1){
            if(arr[cnt]>=arr[smallStk.peek()]){
                smallStk.add(cnt);
            }
            else {
                while(!smallStk.isEmpty()&&arr[smallStk.peek()]<arr[cnt]){
                    leftSmaller[smallStk.pop()]=cnt;
                }
                smallStk.add(cnt);
            }
            cnt--;
        }
        while(!smallStk.isEmpty()){
            leftSmaller[smallStk.pop()]=-1;
        }
        for (int i = 0; i < rightSmaller.length; i++) {
            System.out.println(rightSmaller[i]);
        }
        for (int i = 0; i < leftSmaller.length; i++) {
            System.out.println(leftSmaller[i]);
        }

    }


    public int totalStrength(int[] strength) {
        int ret=0;
        int[] left = new int[strength.length];
        int[] right = new int[strength.length];
        find(strength,left,right);
        int i=0;
        int l=0;
        int r=0;
        while( i<strength.length){
            if(left[i]!=-1){
                while(l>=left[i]) {
                    ret += strength[i]*strength[i];
                    l--;
                }
            }
            if(right[i]!=-1){
                while(l>=left[i]) {
                    ret += strength[i]*strength[i];
                    l--;
                }
            }




            i++;
            l=i;
            r=i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[]ints= new int[]{1,3,1,2};
        int[] right = new int[4];
        int[] left = new int[4];
        find(ints,left,right);
    }
}
