package com.nanda.java.samples.meta;

import java.util.*;
public class FindParentInBinaryTree{

    public static void main(String []args){
        System.out.println("Hello World");
        int[] N = {50, 40, 80, 48, 2, 10, 60, 35, 12, 4, 70, 25, 28};
        SolutionForFindParentInBinaryTree s = new SolutionForFindParentInBinaryTree();
        NodeBT root = s.constructBinaryTreeAndReturnRoot(N);
        System.out.println("root is " + root.val);
        System.out.println("Ascending order is ");
        s.inOrderTraverse(root);
        int v1 = 35, v2 = 70;
        List<Integer> vals = new ArrayList<>();
        System.out.println("Bottom up order is ");
        s.traverseUp(root, v1, v2, vals);
    }
}
class SolutionForFindParentInBinaryTree {
    public NodeBT constructBinaryTreeAndReturnRoot(int[] values){
        NodeBT root = new NodeBT(values[0]);
        for(int i=1; i<values.length; i++){
            insertValInTree(values[i], root);
        }
        return root;
    }
    public void insertValInTree(int val, NodeBT cur){
        if(val < cur.val){
            if(cur.left == null){
                cur.left = new NodeBT(val);
            } else {
                insertValInTree(val, cur.left);
            }
        } else {
            if(cur.right == null){
                cur.right = new NodeBT(val);
            } else {
                insertValInTree(val, cur.right);
            }
        }
    }
    public void inOrderTraverse(NodeBT root){
        if(root.left != null) {
            inOrderTraverse(root.left);
        }
        System.out.println(root.val);
        if(root.right != null) {
            inOrderTraverse(root.right);
        }
    }
    public void traverseUp(NodeBT root, int v1, int v2, List<Integer> vals){
        if(root.left != null){
            traverseUp(root.left, v1, v2,vals);
        }if(root.right != null){
            traverseUp(root.right, v1, v2, vals);
        }
        vals.add(root.val);
        System.out.println(vals);
    }
}
class NodeBT {
    int val;
    NodeBT left, right;
    public NodeBT(int v){
        val = v;
    }
}