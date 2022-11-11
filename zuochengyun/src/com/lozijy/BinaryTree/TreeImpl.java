package com.lozijy.BinaryTree;

import com.lozijy.Graph.Node;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class TreeImpl implements Tree{
    public TreeNode head;
    public TreeImpl (TreeNode node){
        this.head=node;
    }
    @Override
    public void PreOrderTraversal(TreeNode head) {
        if(head==null){
            return;
        }
        System.out.println(head.value);
        PreOrderTraversal(head.leftChild);
        PreOrderTraversal(head.rightChild);

    }

    @Override
    public void InOrderTraversal(TreeNode head) {
        if(head==null){
            return;
        }
        InOrderTraversal(head.leftChild);
        System.out.println(head.value);
        InOrderTraversal(head.rightChild);
    }

    @Override
    public void PosOrderTraversal(TreeNode head) {
        if(head==null){
            return;
        }
        PosOrderTraversal(head.leftChild);
        PosOrderTraversal(head.rightChild);
        System.out.println(head.value);
    }

    @Override
    public void LevelOrderTraversal(TreeNode head) {
        PriorityQueue<TreeNode> queue = new PriorityQueue<>();
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            System.out.println(head.value);
            if(head.leftChild!=null) {
                queue.add(head.leftChild);
            }
            if(head.rightChild!=null) {
                queue.add(head.rightChild);
            }
        }

    }

    @Override
    public void PreOrderTraversal1(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            head=stack.pop();
            System.out.println(head.value);
            if(head.leftChild!=null) {
                stack.add(head.rightChild);
            }
            if(head.rightChild!=null) {
                stack.add(head.leftChild);
            }
        }
    }

    @Override
    public void InOrderTraversal1(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            while(head.leftChild!=null) {
                stack.add(head.leftChild);
                head = head.leftChild;
            }
            head=stack.pop();
            System.out.println(head.value);
            if(head.rightChild!=null){
                head=head.rightChild;
                stack.add(head);
            }
        }

    }

    @Override
    public void PosOrderTraversal1(TreeNode head) {

    }
    //是否是二叉搜索树
    //第一种，把所有节点放进数组
    @Override
    public boolean isBST1(TreeNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        process(head,list);
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void process(TreeNode node,ArrayList<Integer> list){
        if(node==null){
            return;
        }
        process(node.leftChild,list);
        list.add(node.value);
        process(node.rightChild,list);
    }

    //递归判断
    @Override
    public boolean isBST2(TreeNode head) {
        if(head==null){
            return true;
        }else {
            if(!isBST1(head.leftChild)){
                return false;
            }
            if(head.value<preValue){
                return false;
            }else {
                preValue= head.value;
                return isBST2(head.rightChild);
            }
        }
    }
    public int preValue=Integer.MIN_VALUE;

    @Override
    public boolean isBST3(TreeNode head) {
        return false;
    }

    @Override
    public boolean checkCBT(TreeNode head) {
        return false;
    }

    @Override
    public boolean checkFBT(TreeNode head) {
        Info info = process1(head);
        return Math.pow(2,info.height)-1==info.num;
    }
    public Info process1(TreeNode node){
        if(node==null){
            return new Info(0,0);
        }
        Info leftInfo = process1(node.leftChild);
        Info rightInfo = process1(node.rightChild);
        return new Info(Math.max(leftInfo.height,rightInfo.height)+1,leftInfo.num+rightInfo.num+1);
    }
    class Info{
        int height;
        int num;
        public Info(int height,int num){
            this.height=height;
            this.num=num;
        }
    }

    @Override
    public TreeNode lowestCommonAncestor1(TreeNode head, TreeNode o1, TreeNode o2) {
        return null;
    }

    @Override
    public TreeNode lowestCommonAncestor2(TreeNode head, TreeNode o1, TreeNode o2) {
        return null;
    }

    @Override
    public String serialByPre(TreeNode head) {
        return null;
    }

    @Override
    public TreeNode reconByPreString(String preStr) {
        return null;
    }

}
