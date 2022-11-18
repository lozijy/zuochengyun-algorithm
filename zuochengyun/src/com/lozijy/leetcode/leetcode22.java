package com.lozijy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {

    //my method to solve the problem
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("()");
        backtrack(ret,buffer,n,1,0);
        return ret;
    }
    public static void backtrack(List<String>ret,StringBuffer temp,int n,int now,int count){
        if(now==n){
            ret.add(temp.toString());
            return;
        }else {
            temp.append("()");
            backtrack(ret,temp,n,now+1,0);
            temp.delete(temp.length()-2,temp.length());
            for (int i = 0; i < now; i++) {
                temp.delete(temp.length()-1-i,temp.length());
                temp.append("()");
                for (int j = 0; j < i+1; j++) {
                    temp.append(")");
                }
                backtrack(ret,temp,n,now+1,1);
                temp.delete(temp.length()-i-3,temp.length());
                temp.append(")");
            }
        }
    }

    //the standard method
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis1(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }


    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
    }
}
