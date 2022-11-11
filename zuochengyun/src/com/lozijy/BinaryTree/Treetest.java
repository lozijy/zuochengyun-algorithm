package com.lozijy.BinaryTree;

public class Treetest {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.leftChild=node1;
        node2.rightChild=node3;
        Tree tree1 = new TreeImpl(node2);

//        tree.InOrderTraversal(node);
//        tree.InOrderTraversal1(node);

//        System.out.println(tree1.isBST1(node2));
//        System.out.println(tree1.isBST2(node2));
        System.out.println(tree1.checkFBT(node2));
    }
}
