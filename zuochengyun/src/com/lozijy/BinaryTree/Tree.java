package com.lozijy.BinaryTree;

import com.lozijy.BinaryTree.TreeNode;

public interface Tree {

    //二叉树的前序中序后序遍历
    public void PreOrderTraversal(TreeNode head);
    public void InOrderTraversal(TreeNode head);
    public void PosOrderTraversal(TreeNode head);
    public void LevelOrderTraversal(TreeNode head);
    public void PreOrderTraversal1(TreeNode head);
    public void InOrderTraversal1(TreeNode head);
    public void PosOrderTraversal1(TreeNode head);

    //检查是否是二叉查找树
    public boolean isBST1(TreeNode head);
    public boolean isBST2(TreeNode head);
    public boolean isBST3(TreeNode head);

    //检查是否是完全二叉树
    public boolean checkCBT(TreeNode head);

    //检查是否是满二叉树
    public boolean checkFBT(TreeNode head);

    //寻找两个节点的最低公共组先
    public TreeNode lowestCommonAncestor1(TreeNode head,TreeNode o1,TreeNode o2);
    public TreeNode lowestCommonAncestor2(TreeNode head,TreeNode o1,TreeNode o2);

    //序列化和反序列化
    public String serialByPre(TreeNode head);
    public TreeNode reconByPreString(String preStr);



}
