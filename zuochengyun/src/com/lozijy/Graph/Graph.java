package com.lozijy.Graph;

import java.util.*;

public class Graph {
    HashSet<Node> Nodes;
    HashSet<Edge> Edges;

    public Graph() {
        this.Nodes=new HashSet<Node>();
        this.Edges=new HashSet<Edge>();
    }

    //广度优先遍历
    public void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node n:cur.nexts){
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
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node cur=stack.pop();
            for(Node n:cur.nexts){
                if(!set.contains(n)){
                    stack.add(cur);
                    stack.add(n);
                    set.add(n);
                    System.out.println(n.value);
                    break;
                }
            }
        }
    }
    //拓扑排序
    public void Tolologic(Node node){
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node n:this.Nodes){
            if(n.in==0) {
                queue.add(n);
            }
            inMap.put(n, n.in);
        }
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            System.out.println(cur.value);
            for (Node n:cur.nexts){
                inMap.put(n,inMap.get(n)-1);
                if(inMap.get(n)==0){
                    queue.add(n);
                }
            }
        }
    }

}
