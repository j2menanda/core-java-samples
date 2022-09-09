package com.nanda.java.samples.meta;
import java.util.*;
public class KthSmallest {

	public static void main(String[] args) {
		int[] arr = {7,10,4,20,15}; int k = 4;
		System.out.println("keth is " + findKthSmallest(arr, k));
	}

	public static int findKthSmallest(int[] arr, int k) {
		int kth = -1;
		
		return kth;
	}
}
/* Stack approach
 * 
	public static int findKthSmallest(int[] arr, int k) {
		Stack<Integer> st = new Stack<Integer>();
		int top = -1;
		st.push(arr[0]);
		System.out.println(" pushed " + arr[0]);
		for(int i=1; i<arr.length; i++) {
			top = st.peek();
			if(top < arr[i]) {
				if(st.size() < k) {
					st.push(arr[i]);
					System.out.println(" pushed " + arr[i]);
				}
			} else {
				removeAndAddToStack(st, arr[i], k);
			}
		}
		System.out.println("stack is " + st.toString());
		return st.peek();
	}

	private static void removeAndAddToStack(Stack<Integer> st, int i, int k) {
		int removed = st.pop();
		System.out.println(" removed " + removed);
		if(st.size() == 0) {
			st.push(i);
			System.out.println(" pushed " + i);
		} else {
			int top = st.peek();
			if(top > i) {
				removeAndAddToStack(st, i, k);
			} else {
				if(st.size() < k) {
					st.push(i);
					System.out.println(" pushed " + i);
				}
			}
		}
		if(st.size() < k) {
			st.push(removed);
			System.out.println(" pushed " + removed);
		}
	}
}*/
