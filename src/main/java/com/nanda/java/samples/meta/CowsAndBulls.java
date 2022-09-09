package com.nanda.java.samples.meta;
/*
You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.

Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
*/
import java.util.List;
import java.util.ArrayList;
public class CowsAndBulls{

     public static void main(String []args){
        System.out.println("Hello World");
        Solution s = new Solution();
        //String secret = "1807", guess = "7810";
        String secret = "1123", guess = "0111";
        System.out.println(s.getHint(secret, guess));
     }
}
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        List<Character> charsInSecret = new ArrayList<Character>();
        List<Character> charsInGuess = new ArrayList<Character>();
        for(int i=0; i< secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else {
                charsInSecret.add(secret.charAt(i));
                charsInGuess.add(guess.charAt(i));
            }
        }
        for(Character ch : charsInGuess){
            if(charsInSecret.contains(ch)){
                cows++;
                charsInSecret.remove(ch);
            }
        }
        return "" + bulls + "A" + cows + "B";
    }
}