package com.lozijy.Graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value, int in, int out) {
        this.value = value;
        this.in = in;
        this.out = out;
        this.nexts=new ArrayList<Node>();
        this.edges=new ArrayList<Edge>();
    }
}
