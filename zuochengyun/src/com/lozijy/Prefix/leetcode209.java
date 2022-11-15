package com.lozijy.Prefix;

public class leetcode209 {
    //我的第一眼是滑动窗口呜呜呜还是做出来了
    public static int minSubArrayLen(int target, int[] nums) {
        int ret=Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int temp=nums[0];
        while(l<nums.length-1&&r<nums.length-1) {
            while (r < nums.length-1 && temp < target) {
                r++;
                temp += nums[r];
            }
            //从头到尾都够不上target
            if (temp < target) {
                return 0;
            } else {
                //收缩左边界,保证temp>=target
                while (l <= r) {
                    temp -= nums[l];
                    if (temp >= target) {
                        l++;
                    } else {
                        temp += nums[l];
                        break;
                    }
                }
            }
            ret = Math.min(ret, r - l + 1);
            //窗口继续下去
            if(r<nums.length-1) {
                r++;
                temp += nums[r];
            }
        }
        if(temp<target){
            return 0;
        }
        if(l<r-1) {
            temp -= nums[l];
            l += 1;
            if(temp < target){
                l--;
                temp+=nums[l];
            }
            //此时右边界到了最右边，我们收缩左边界
            while (l <= r && temp >= target) {
                temp -= nums[l];
                l++;
                if(temp<target){
                    l--;
                }
            }
        }
        ret = Math.min(ret, r - l + 1);
        return ret;
    }

    public static void main(String[] args) {
        int tar=4;
        int[]ints=new int[]{1,4,4};
        System.out.println(minSubArrayLen(tar,ints));
    }
}
