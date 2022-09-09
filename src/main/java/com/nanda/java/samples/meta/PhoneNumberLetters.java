package com.nanda.java.samples.meta;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
2-abc, 3-def, 4-ghi, 5-jkl, 6-mno, 7-pqrs, 8-tuv, 9-wxyz.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
*/
public class PhoneNumberLetters {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        for(int i=0; i<digits.length(); i++){
            int digit = Integer.parseInt(digits.substring(i,i+1));
            results = getStrings(results, digit);
        }
        return results;
    }
    
    public List<String> getStrings(List<String> curResults, int d){
        List<String> results = new ArrayList<String>();
        int[] numOfLetters = {3,3,3,3,3,4,3,4};
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0; i< numOfLetters[d-2]; i++){
            String letter = letters[d-2].substring(i, i+1);
            if(curResults.isEmpty()){
                results.add(letter);
            } else{
                for(String str : curResults){
                    results.add(str+letter);
                }
            }
        }
        return results;
    }
}