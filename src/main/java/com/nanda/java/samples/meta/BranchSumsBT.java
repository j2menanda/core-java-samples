package com.nanda.java.samples.meta;

import java.util.*;

class BranchSumsBT {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    ArrayList<Integer> sums = new ArrayList<>();
    calculateSums(root, 0, sums);
    return sums;
  }

  private static void calculateSums(BinaryTree root, int i, ArrayList<Integer> sums) {
	  if(root == null) {
		  return;
	  }
	  int curSum = i+root.value;
	  if(root.left == null && root.right == null) {
		  sums.add(curSum);
		  return;
	  }
	  calculateSums(root.left, curSum, sums);
	  calculateSums(root.right, curSum, sums);
  }

}