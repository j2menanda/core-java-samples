package com.nanda.java.samples.meta;

import java.util.*;
public class StringBreak {

	public static void main(String[] args) {
		//String str = "Imagine that this is a long message with a large number of characters..";
		/*String str = "Write a function that splits a long SMS string into smaller pieces."
				+ " Each piece should be less than or equal to 160 characters and include"
				+ " a formatted index counter at the end (for example, � (2/5)�). The function"
				+ " should avoid breaking words into pieces. If a word does not fit, it should"
				+ " go to the next SMS.";*/
		String str = "This is not a book, it is a pencil and therefore we begin."; int l = 15;
		BreakString bs = new BreakString();
		List<String> parts = bs.getStringParts(str, l);
		int j = 0;
		for(int i=0; i<parts.size(); i++) {
			j = i+1;
			System.out.println(parts.get(i) + "(" + j + "/" + parts.size() + ")");
		}
		//System.out.println(str);
	}

}

class BreakString {
	public List<String> getStringParts(String str, int length){
		List<String> parts = new ArrayList<>();
		//int numOfParts = 0;
		int space = 0, prevSpace = 0, prevStr = 0;
		while(space != -1) {
			space++;
			space = str.indexOf(" ", space);
			//System.out.println("Space is at " + space + "prevSpace at " + prevSpace + " prevstr at " + prevStr);
			if(space-prevStr > length) {
				parts.add(str.substring(prevStr, prevSpace));
				//System.out.println(str.substring(prevStr, prevSpace));
				prevStr = prevSpace;
				space = prevSpace;
			}
			if(space != -1) {
			prevSpace = space;
			}
			//System.out.println("Space is at " + space + "prevSpace at " + prevSpace + " prevstr at " + prevStr);
		}
		if(str.length()-prevStr < length) {
			parts.add(str.substring(prevStr));
			//System.out.println(str.substring(prevStr));
		} else {
			parts.add(str.substring(prevStr, prevSpace));
			//System.out.println(str.substring(prevStr, prevSpace));
			parts.add(str.substring(prevSpace));
			//System.out.println(str.substring(prevSpace));
		}
		return parts;
	}
}
