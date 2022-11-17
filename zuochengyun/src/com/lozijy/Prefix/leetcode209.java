package com.lozijy.Prefix;

import java.util.Arrays;

public class leetcode209 {
    //我的第一眼是滑动窗口好不熟，各种情况给我绕晕了,呜呜呜还是做出来了
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
    
    //优雅的滑动窗口
    public int minSubArrayLen3(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int start = 0, end = 0;
            int sum = 0;
            while (end < n) {
                sum += nums[end];
                while (sum >= s) {
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //前缀和解法
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int tar=4;
        int[]ints=new int[]{1,4,4};
        System.out.println(minSubArrayLen(tar,ints));
    }
}
