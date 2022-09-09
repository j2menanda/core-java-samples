package com.nanda.java.samples.goldmansachs;/* Problem Name is &&& First NonRepeating &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  2) Consider adding some additional tests in doTestsPass().
 *  3) Implement findFirst() correctly.
 *  4) If time permits, try to improve the efficiency of your implementation
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {

  /**
  * char findFirst(String input)
  * Finds the first character that does not repeat anywhere in the input string
  * Given "apple", the answer is "a"
  * Given "racecars", the answer is "e"
  * Given "ababdc", the answer is "d"
  **/
  public static char findFirst(String input)
  {
    Map<Character, Integer> charFrequency = new HashMap<>(input.length());
    for(char c : input.toCharArray())
    {
      charFrequency.merge(c, 1, Integer::sum);
    }

    for(char i : input.toCharArray())
    {
      if(charFrequency.get(i) == 1)
        return(i);
    }

    throw(new IllegalArgumentException("no non-repeating character found"));
  }

  public static boolean doTestsPass()
  {
    String[] inputs = {"apple","racecars", "ababdc"};
    char[] outputs = {'a', 'e', 'd' };

    boolean result = true;
    for(int i = 0; i < inputs.length; i++ )
    {
      result = result && findFirst(inputs[i]) == outputs[i];
      if(!result)
        System.out.println("Test failed for: " + inputs[i]);
      else
        System.out.println("Test passed for: " + inputs[i]);
    }
    return(result);
  }

  public static void main(String args[])
  {
    doTestsPass();
  }
}