package com.nanda.java.samples.meta;

public class ScoreBoardLevel2 {

	public static void main(String[] args) {
        //int[] S = {1,2,3,4,5,6}; int N = 6; // sol = 3
        //int[] S = {4,3,3,4}; int N = 4; // sol = 2
        //int[] S = {2,4,6,8}; int N = 4; // sol = 4
        //int[] S = {8}; int N = 4; // sol = 3
        //int[] S = {1,9,2}; int N = 3; //sol = 4
        //int[] S = {10, 2}; // sol = 4 
        //int[] S = {1,2,3}; // sol = 2
        int[] S = {4,9,5}; // sol = 5
		//int[] S = {2,3,4}; // sol = 3
		//int[] S = {4,5,6}; // sol = 3
        ScoreBoardLevel2Solution c = new ScoreBoardLevel2Solution();
        System.out.println("problems " + c.getMinProblemCount(S));
	}

}

class ScoreBoardLevel2Solution {
	  
	  public int getMinProblemCount(int[] S) {
	    int numOf3 = 0, numOf2 = 0, numOf1 = 0;
	    int high = 0;
	    boolean oneIsPresent = false;
	    for(int i : S) {
	    	if(high < i) {
	    		high = i;
	    	}
	    	if( i == 1) {
	    		oneIsPresent = true;
	    	}
	    	if(numOf3 < (i / 3)) {
	    		numOf3 = i/3;
	    	}
	    	i = i % 3;
	    	if(numOf2 < (i/2) && numOf2 == 0) {
	    		numOf2 = i / 2;
	    	}
	    	i = i % 2;
	    	if(i == 1 && numOf1 == 0) {
	    		numOf1 = 1;
	    	}
	    }
	    
	    if((numOf1 == 1 && numOf2 == 1 && numOf3 >= 1 && high%3 == 0)) {
	    	numOf3--;
	    }
	    if(!oneIsPresent && numOf2 == 1 && high%3 == 1) {
	    	numOf3--;
	    	numOf1--;
	    	numOf2++;
	    }
	    return numOf3 + numOf2 + numOf1;
	  }
	  
}