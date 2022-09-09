package com.nanda.java.samples.others;

import java.util.List;
import java.util.ArrayList;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		System.out.println(reverseString.reverseText("My name is Nanda", " "));
	}
	
	public String reverseText(String input, String separator) {
		String text = "";
		if(null == input || input.length() == 0)
			return text;
		
		List list = new ArrayList();
		int length = separator.length();
		int index = input.indexOf(separator);
		
		while(index >= 0) {
			list.add(input.substring(0, index));
			input = input.substring(index+length);
			index = input.indexOf(separator);
		}
		list.add(input);
		
		for(int i = list.size() -1; i >= 0; i--) {
			text += (String)list.get(i);
			text += separator;
		}
		return text.trim();
	}
}
