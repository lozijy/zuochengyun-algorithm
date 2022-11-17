package com.lozijy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
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

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
    }
}
