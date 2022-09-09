package com.nanda.java.samples.meta;

import java.util.*;

public class TunnelTime {

	public static void main(String[] args) {
		long C = 10, K = 7; int N = 2; long[] A = {1,6}, B = {3,7}; //Sol = 22
		//long C = 50, K = 15; int N = 3; long[] A = {39, 19, 28}, B = {49, 27, 35}; //Sol = 35
		Traintrack t = new Traintrack();
		System.out.println("Total time is " +  t.getSecondsElapsed(C, N, A, B, K));
	}
}

class Traintrack {
	public long getSecondsElapsed(long C, int N, long[] A, long[] B, long K) {
		List<Long> sortedA = new ArrayList<Long>();
		List<Long> sortedB = new ArrayList<Long>();
		sortArrays(A, B, sortedA, sortedB);
	    long totalTime = 0L, tunnelTime = 0L, prevEnd = 0L, curTunnel = 0L;
	    boolean stop = false;
	    while(!stop) {
	    	for(int i=0; i<sortedA.size(); i++) {
	    		curTunnel = sortedB.get(i)-sortedA.get(i);
	    		if((tunnelTime + curTunnel) >= K) {
	    			stop = true;
	    			totalTime += K - tunnelTime;
	    			totalTime += sortedA.get(i) - prevEnd;
	    			break;
	    		} else {
	    			tunnelTime += curTunnel;
	    			totalTime += sortedB.get(i) - prevEnd;
	    			prevEnd = sortedB.get(i);
	    		}
	    	}
	    	if(!stop) {
	    		totalTime += (C-prevEnd);
	    		prevEnd = 0L;
	    	}
	    }
	    return totalTime;
	} 
	
	public void sortArrays(long[] A, long[] B, List<Long> sortedA, List<Long> sortedB) {
		Node root = null;
		for(int i=0; i<A.length; i++) {
			if(root == null) {
				root = new Node(A[0], B[0]);
			} else {
				addNode(root, A[i], B[i]);
			}
		}
		sortNodes(root, sortedA, sortedB);
	}

	private void sortNodes(Node root, List<Long> sortedA, List<Long> sortedB) {
		if(root.left != null) {
			sortNodes(root.left, sortedA, sortedB);
		}
		sortedA.add(root.a);
		sortedB.add(root.b);
		if(root.right != null) {
			sortNodes(root.right, sortedA, sortedB);
		}
	}

	private void addNode(Node root, long l, long m) {
		if(l < root.a) {
			if(root.left != null) {
				addNode(root.left, l, m);
			} else {
				root.left = new Node(l,m);
			}
		} else {
			if(root.right != null) {
				addNode(root.right, l, m);
			} else {
				root.right = new Node(l,m);
			}
		}
	}
}
class Node {
	public Node(long l, long m) {
		a = l; b = m;
	}
	long a, b;
	Node left, right;
}