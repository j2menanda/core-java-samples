package com.nanda.java.samples.meta;
import java.util.*;
public class PalindromesInString {

	public static void main(String[] args) {
		String str = "aabbbaa";
		System.out.println("check "+ str.substring(0, 3));
		FindPalindromes fp = new FindPalindromes();
		System.out.println(" " + fp.findAllPalindromes(str));
	}

}
class FindPalindromes {
	public List<String> findAllPalindromes(String str) {
		List<String> outs = new ArrayList<String>();
		for(int i=0; i<str.length(); i++) {
			outs.addAll(findOddLengthStrs(str, i));
			outs.addAll(findEvenLengthStrs(str, i));
		}
		return outs;
	}

	private Collection<? extends String> findEvenLengthStrs(String str, int index) {
		int move = 0;
		List<String> outs = new ArrayList<String>();
		System.out.println("index " + index);
		while(index-move >= 0 && index+move+1 < str.length() && isPalindrome(str.substring(index-move, index+move+2))) {
			outs.add(str.substring(index-move, index+move+2));
			move++;
		}
		System.out.println(" outs " + outs);
		return outs;
	}

	private List<String> findOddLengthStrs(String str, int index) {
		int move = 1;
		List<String> outs = new ArrayList<String>();
		System.out.println("index " + index);
		while(index-move >= 0 && index+move < str.length() && isPalindrome(str.substring(index-move, index+move+1))) {
			outs.add(str.substring(index-move, index+move+1));
			move++;
		}
		System.out.println(" outs " + outs);
		return outs;
	}
	
	public boolean isPalindrome(String word) {
		System.out.println("check "+ word);
		int first = 0, last = word.length()-1;
		while(word.charAt(first) == word.charAt(last)) {
			if(first == last || first == last-1) {
				return true;
			}
			first++;
			last--;
		}
		return false;
	}
}
