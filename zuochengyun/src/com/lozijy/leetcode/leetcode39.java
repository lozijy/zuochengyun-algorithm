package com.lozijy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode39 {
    //由于可重复使用，我们采用递归的形式解决,回溯+剪枝
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates,target,ret,new ArrayList<Integer>(),-1,0);
        return ret;
    }
    // 8 8
    public static void backtrack(int[]candidates,int tar,List<List<Integer>> ret,List<Integer>temp,int index,int now){
        if(tar==0){
            ret.add(new ArrayList<>(temp));
            return;
        }
        //开启分支的时候很帅，但return之后就不知道干嘛了这个i有问题
        //java是面向对象的语言，当我在temp中remove后ret中的temp也要变，怎么办?这里我们add的是一个new的Arraylist.
        //画图之后发现出现了重复问题，我又添加了一个now变量，使其开启分支的时候for循环不会从0开始，而是直接从这个i之后开始
        for (int i = now; i < candidates.length; i++) {
            if(candidates[now]>tar){
                return;
            }
            if(candidates[i]<=tar){
                temp.add(candidates[i]);
                backtrack(candidates,tar-candidates[i],ret,temp,index+1,i);
                temp.remove(index+1);
            }
            else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[]ints=new int[]{2,3,6,7};
        int target=7;
        combinationSum(ints,target);
    }
}
