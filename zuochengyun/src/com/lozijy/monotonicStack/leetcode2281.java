package com.lozijy.monotonicStack;

import java.util.Stack;

public class leetcode2281 {
    //基本上过了,但是对于大数据取余的情况还是会出错,暂时解决不了.
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/sum-of-total-strength-of-wizards
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //对于一个可重复元素的数组中的每一个数找到右边更小或相等的元素和左边严格更小的元素
    public static void find(int [] arr,int[]leftSmaller,int[]rightSmaller){
        Stack<Integer> smallStk = new Stack<>();
        //处理右边更小
        int cnt=1;
        smallStk.add(0);
        while (!smallStk.isEmpty()&&cnt<arr.length){
            if(arr[cnt]>arr[smallStk.peek()]){
                smallStk.add(cnt);
            }
            else {
                while(!smallStk.isEmpty()&&arr[smallStk.peek()]>=arr[cnt]){
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
                while(!smallStk.isEmpty()&&arr[smallStk.peek()]>arr[cnt]){
                    leftSmaller[smallStk.pop()]=cnt;
                }
                smallStk.add(cnt);
            }
            cnt--;
        }
        while(!smallStk.isEmpty()){
            leftSmaller[smallStk.pop()]=-1;
        }
        for (int i = 0; i < leftSmaller.length; i++) {
            System.out.println(leftSmaller[i]);
        }
        for (int i = 0; i < rightSmaller.length; i++) {
            System.out.println(rightSmaller[i]);
        }

    }
    public static int totalStrength(int[] strength) {
        final int mod = (int) 1e9 + 7;
        long  ret=0;
        int[] left = new int[strength.length];
        int[] right = new int[strength.length];
        find(strength,left,right);
        int i=0;
        int temp=0;
        while( i<strength.length){
            temp=0;//清空
            //前缀和
            if(left[i]==-1&&right[i]==-1){
                for (int j = i; j >= 0; j--) {
                    for (int k = i; k < strength.length; k++) {
                        for (int m = j; m <= k; m++) {
                            temp += strength[m];
                            temp = temp%mod;
                        }
                    }
                }
            }
            //问题:右边的时候在相等和严格小的情况无法区分,相等我们应该开启这个分支，不相等应取消这个分支。，弄个标记，相等标记为1
            else if(left[i]==-1){
                for (int j = i; j >=0 ; j--) {
                    for (int k = i; k < right[i]; k++) {
                        for (int m = j; m <= k; m++) {
                            temp+=strength[m];
                            temp = temp%mod;
                        }
                    }
                }
            }
            else if(right[i]==-1){
                for (int j = i; j >left[i] ; j--) {
                    for (int k = i; k < strength.length; k++) {
                        for (int m = j; m <= k; m++) {
                            temp+=strength[m];
                            temp = temp%mod;
                        }
                    }
                }
            }
            else {
                for (int j = i; j > left[i]; j--) {
                    for (int k = i; k < right[i]; k++) {
                        for (int m = j; m <= k; m++) {
                            temp += strength[m];
                            temp = temp%mod;
                        }
                    }
                }
            }
            temp=temp %mod;
            ret+=((strength[i]*temp)%mod);
            i++;
            ret= (ret ) % mod;
        }
        return (int) (ret ) % mod;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,1,2};
        System.out.println(totalStrength(ints));
    }
}
