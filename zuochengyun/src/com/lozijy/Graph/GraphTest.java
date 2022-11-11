package com.lozijy.Graph;

public class GraphTest {
    public static void main(String[] args) {
        Node node1 = new Node(1, 0, 2);
        Node node2 = new Node(2, 1, 1);
        Node node3 = new Node(3, 1, 1);
        Node node4 = new Node(4, 2, 2);
        Node node5 = new Node(5, 1, 0);
        Node node6 = new Node(6, 2, 0);
        Node node7 = new Node(7, 0, 1);
        node1.nexts.add(node2);
        node1.nexts.add(node4);
        node2.nexts.add(node3);
        node3.nexts.add(node4);
        node4.nexts.add(node5);
        node4.nexts.add(node6);
        node7.nexts.add(node6);
        Edge edge1 = new Edge(1, node1, node2);
        Edge edge2 =new Edge(1,node2,node3);
        Edge edge3 =new Edge(1,node3,node4);
        Edge edge4 =new Edge(1,node1,node4);
        Edge edge5 =new Edge(1,node4,node5);
        Edge edge6 =new Edge(1,node4,node6);
        Edge edge7 = new Edge(1, node7, node6);
        Graph graph = new Graph();
        graph.Nodes.add(node1);
        graph.Nodes.add(node2);
        graph.Nodes.add(node3);
        graph.Nodes.add(node4);
        graph.Nodes.add(node5);
        graph.Nodes.add(node6);
        graph.Nodes.add(node7);
        graph.Edges.add(edge1);
        graph.Edges.add(edge2);
        graph.Edges.add(edge3);
        graph.Edges.add(edge4);
        graph.Edges.add(edge5);
        graph.Edges.add(edge6);
        graph.Edges.add(edge7);
        graph.Tolologic(node1);

    }
}
