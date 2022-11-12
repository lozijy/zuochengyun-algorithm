package com.lozijy.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public int[] slidingWindow(int[]arr,int w){
        int[] res = new int[arr.length - w + 1];
        int biggest=Integer.MIN_VALUE;
        int bigI=0;
        int secondBig=Integer.MIN_VALUE+1;
        int secondI=0;
        int cnt=2;
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        queue.add(arr[0]);
        queue.add(arr[1]);
        for (int i = 0; i < arr.length-w; i++) {
            for (int j = i; j < i+w; j++) {
                biggest=queue.poll();
                secondBig=queue.poll();
                if(cnt<w) {
                    if(arr[j]>queue.peek()){
                        bigI=j;
                    }
                    queue.add(arr[i]);
                    cnt++;
                }
            }
        }
        return res;
    }
}
