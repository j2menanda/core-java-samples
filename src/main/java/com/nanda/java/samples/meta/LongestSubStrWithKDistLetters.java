package com.nanda.java.samples.meta;

import java.util.*;
public class LongestSubStrWithKDistLetters {

	public static void main(String[] args) {
		//String str = "araaci"; int k = 2; // output = 4
		String str = "araaci"; int k = 1; // output = 4
		//String str = "araaci"; int k = 2; // output = 4
		//String str = "araaci"; int k = 2; // output = 4
		LongestSubstringKDistinct l = new LongestSubstringKDistinct();
		System.out.println("max is " + l.findLength(str, k));
	}

}

class LongestSubstringKDistinct {
  public int findLength(String str, int k) {
    Stack<Character> s1 = new Stack<Character>();
    Stack<Character> s2 = new Stack<Character>();
    List<Character> dis = new ArrayList<Character>();
    int max = 0;
    for(Character c : str.toCharArray()) {
    	if(dis.size() < k) {
    		dis.add(c);
    		s1.push(c);
    		System.out.println(" add to stack " + c);
    	} else {
    		if(dis.contains(c)) {
    			s1.push(c);
        		System.out.println(" add to stack " + c);
    		} else {
    			max = Math.max(max,  s1.size());
    			Character prev = s1.pop();
    			s2.push(prev);
        		System.out.println(" add to stack2 " + prev);
    			while(!s1.empty()) {
    				if(prev.equals(s1.peek())) {
    		    		System.out.println(" add to stack2 " + s1.peek());
    					s2.push(s1.pop());
    				} else {
    					break;
    				}
    			}
    			s1.clear();
    			s1.addAll(s2);
    			s2.clear();
	    		System.out.println(" size of stack1 " + s1.size());
    		}
    	}
    }
    return max;
  }
}