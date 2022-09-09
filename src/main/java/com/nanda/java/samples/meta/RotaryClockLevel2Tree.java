package com.nanda.java.samples.meta;
import java.util.*;
public class RotaryClockLevel2Tree{

     public static void main(String []args){
        System.out.println("Hello World");
        //int[] C = {1, 2, 3}; int N = 3; int M = 3; //sol = 2
        //int[] C = {9,4,4, 8}; int N = 10; int M = 4; //sol = 6
        int[] C = {9,4,4,8,6,2,5,1}; int N = 10; int M = 8; // sol =12
        //int[] C = {9, 4, 4, 8, 6, 56,77,88,4,34,5,7,23,41,77,34,34,34,34,34,34,55,68,90,21,17,83,48,92,55}; int N = 100; int M = 5; //sol=335
        ClockTwoWheelTree c = new ClockTwoWheelTree();
        System.out.println("seconds " + c.getMinCodeEntryTime(N, M, C));
        
     }
}

class ClockTwoWheelTree {
    public long getMinCodeEntryTime(int N, int M, int[] C) {
        long countAtPrevCode = 0, diff1 = 0, diff2 = 0, wt = 0;
        int median = (N/2);
        ClockNode root = new ClockNode(1, 1);
        HashMap<ClockNode, Long> nodesAtPrevCode = new HashMap<ClockNode, Long>();
        HashMap<ClockNode, Long> nodesAtCode = new HashMap<ClockNode, Long>();
        nodesAtPrevCode.put(root, 0L);
        for(int code : C){
        	countAtPrevCode += median;
            nodesAtCode.clear();
        	for(ClockNode node : nodesAtPrevCode.keySet()) {
	            if(code >= node.c1){
	                diff1 = code - node.c1;
	            } else {
	                diff1 = code+N - node.c1;
	            }
	            
	            if(code >= node.c2){
	                diff2 = code - node.c2;
	            } else {
	                diff2 = code+N - node.c2;
	            }
	            if(diff1 > median){
	                diff1 = N-diff1;
	            }
	            if(diff2 > median){
	                diff2 = N-diff2;
	            }
	            wt = nodesAtPrevCode.get(node) + diff1;
        		node.left = new ClockNode(code, node.c2);
        		if(wt < countAtPrevCode) {
        			countAtPrevCode = wt;
        		}
        		//System.out.println("Adding node with " + node.left.c1 + " " + node.left.c2);
        		if(nodesAtCode.containsKey(node.left)) {
        			if(nodesAtCode.get(node.left) > wt) {
        				nodesAtCode.replace(node.left, wt);
        			}
        		} else {
        			nodesAtCode.put(node.left, wt);
        		}
        		wt = nodesAtPrevCode.get(node) + diff2;
        		node.right = new ClockNode(node.c1, code);
        		if(wt < countAtPrevCode) {
        			countAtPrevCode = wt;
        		}
        		//System.out.println("Adding node with " + node.right.c1 + " " + node.right.c2);
        		if(nodesAtCode.containsKey(node.right)) {
        			if(nodesAtCode.get(node.right) > wt) {
        				nodesAtCode.replace(node.right, wt);
        			}
        		} else {
        			nodesAtCode.put(node.right, wt);
        		}
            }
            //System.out.println("nodes at code " + code + " is " + nodesAtCode.size());
        	//for(ClockNode node : nodesAtCode.keySet()) {
        	//	System.out.println(" Node is " + node.c1 + " " + node.c2 + " wt " + nodesAtCode.get(node));
        	//}
        	nodesAtPrevCode.clear();
            nodesAtPrevCode.putAll(nodesAtCode);
        }
        return countAtPrevCode;
    }
}

class ClockNode {
	public ClockNode(int i, int j) {
		c1 = i; c2 = j;
	}
	int c1;
	int c2;
	ClockNode left, right;
	@Override
	public boolean equals(Object obj) {
		ClockNode that = (ClockNode) obj;
		if(((this.c1 == that.c1 && this.c2 == that.c2) || (this.c1 == that.c2 && this.c2 == that.c1))) {
			return true;
		}
		return false;
	}
	public int hashCode() {
	  return 0;
	}
}