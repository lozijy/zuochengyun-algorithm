package com.lozijy.leetcode;

public class leetcode45 {
    //0 返回3
    //日，终于过了，艹!
    public static int jump(int[] nums) {
        //如果出生点就是终点，直接不需要跳咯..
        if(nums.length==1){
            return 0;
        }
        int ret=0;
        int now=0;
        int max=now+nums[now];
        int temp=0;
        //信息没到最大值时我们通过跳更新最大信息
        while(max<nums.length-1){
            //找到最远的信息,有个问题，如果最远的信息还不如不跳的时候大怎么办?不可能哟。。。。
            //这是信息战的问题，我们在每次while循环的过程中要尽可能拿到更多的信息才知道需要跳到哪里
            //不是跳到最远的地方，而是跳到信息最多的地方,max表示能收集到的最远的信息,temp表示能拿到最远信息的位置
            if(nums[now]==1){
                ret+=1;
                now+=1;
                max=now+nums[now];
                continue;
            }
            int temp2=max;//维护更新前的max
            for (int i = now+1; i <= temp2; i++) {
                if(max<i+nums[i]){
                    temp=i;
                    max=Math.max(max,i+nums[i]);
                }
            }
            ret += 1;
            now = temp;
        }
        //此时最远信息已经比nums的长度长了，我们直接跳一步到nums.length-1
        ret+=1;
        return ret;
    }

    public static void main(String[] args) {
        jump(new int[]{1,2,1,1,1});
    }
}
