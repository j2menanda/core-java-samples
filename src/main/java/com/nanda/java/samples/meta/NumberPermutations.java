package com.nanda.java.samples.meta;
import java.util.*;

public class NumberPermutations {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		ArrayList<Integer> array = new ArrayList<>();
		array.add(1);
		array.add(2);
		array.add(3);
		System.out.println(getPermutations1(array));
	}
	
	public static List<List<Integer>> getPermutations(Integer num, List<Integer> array) {
		if(array.size() <= 2) {
			ArrayList<List<Integer>> out = new ArrayList<>();
			out.add(array);
			ArrayList<Integer> comb = new ArrayList<>();
			comb.add(array.get(1));
			comb.add(array.get(0));
			out.add(comb);
			return out;
		} else {
			ArrayList<List<Integer>> out = new ArrayList<>();
			List<List<Integer>> temp = getPermutations(array.get(0), array.subList(1, array.size()-1));
			for(List<Integer> list : temp) {
				ArrayList<Integer> comb = new ArrayList<>();
				comb.add(num);
				comb.addAll(list);
				out.add(comb);
				comb = new ArrayList<>();
				comb.addAll(list);
				comb.add(num);
				out.add(comb);
			}
			return out;
		}
	}
	
	public static List<List<Integer>> getPermutations1(List<Integer> array) {
		if(array.size() == 2) {
			ArrayList<List<Integer>> out = new ArrayList<>();
			out.add(array);
			ArrayList<Integer> comb = new ArrayList<>();
			comb.add(array.get(1));
			comb.add(array.get(0));
			out.add(comb);
			return out;
		} else {
			ArrayList<List<Integer>> out = new ArrayList<>();
			List<List<Integer>> temp = getPermutations1(array.subList(1, array.size()));
			int num = array.get(0);
			for(List<Integer> list : temp) {
				ArrayList<Integer> comb = new ArrayList<>();
				comb.add(num);
				comb.addAll(list);
				out.add(comb);
				comb = new ArrayList<>();
				comb.addAll(list);
				comb.add(num);
				out.add(comb);
			}
			return out;
		}
	}
}
