package com.lozijy.Graph;

import java.util.*;

public class Graph {
    HashSet<Node> Nodes;
    HashSet<Edge> Edges;

    //广度优先遍历
    public void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node n:node.nexts){
                if(!set.contains(n)) {
                    queue.add(n);
                    set.add(n);
                }
            }
        }
    }
    //深度优先遍历
    public void dfs(Node node){
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        while (!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.value);
            for(Node n:node.nexts){
                if(!set.contains(n)){
                    stack.add(cur);
                    stack.add(n);
                    set.add(n);
                    break;
                }
            }
        }
    }
    //拓扑排序
    public void Tolologic(Node node){

    }

}
