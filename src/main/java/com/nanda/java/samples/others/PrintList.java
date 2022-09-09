package com.nanda.java.samples.others;

import java.util.ArrayList;
import java.util.List;

public class PrintList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B12");
		list.add("C");
		list.set(1, "B");
		list.add(1, "D");
		
		System.out.println(list);
	}
}