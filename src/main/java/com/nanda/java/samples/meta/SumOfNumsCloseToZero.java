package com.nanda.java.samples.meta;

import java.util.*;
public class SumOfNumsCloseToZero {

	public static void main(String[] args) {
		//int[] input = {3, 1, 0, 2, 4, -1, -3};
		int[] input = {2,8,7,-1,-5,0,3,-2,1};
		SumOfNums s = new SumOfNums();
		System.out.println("min is " + s.getPairsWhoseAbsSumIsClosestToZero(input));
	}

}
class SumOfNums {
	public Map<Integer, Integer> getPairsWhoseAbsSumIsClosestToZero(int[] input) {
		Map<Integer, Integer> map = new HashMap<>();
		int min = 100000, sum = 0;
		for(int i=0; i<input.length-1; i++) {
			for(int j=i+1; j<input.length; j++) {
				sum = Math.abs(input[i]+input[j]); 
				if(sum < min) {
					min = sum;
					map.clear();
					map.put(input[i], input[j]);
				} else if(sum == min) {
					map.put(input[i], input[j]);
				}
			}
		}
		return map;
	}
}