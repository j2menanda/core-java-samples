package com.nanda.java.samples.meta;
/*
Reverse to Make Equal
Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
Signature
bool areTheyEqual(int[] arr_a, int[] arr_b)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if B can be made equal to A, return false otherwise.
Example
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
output = true
After reversing the subarray of B from indices 1 to 3, array B will equal array A
*/

import java.io.*; 
import java.util.*;
public class ReverseToEqual {
  boolean areTheyEqual(int[] array_a, int[] array_b) {
       // Write your code here
    if(array_a.length != array_b.length) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int i: array_a) {
      Integer newcount = (Integer)map.get(i);
      if(newcount != null) {
        map.put(i, (newcount.intValue())+1);
      } else {
        map.put(i, 1);
      }
    }
    
   for(int i: array_b) {
      Integer newcount = (Integer)map.get(i);
      if(newcount != null) {
        map.put(i, (newcount.intValue())-1);
      } else {
        map.put(i, 1);
      }
    }
    
    for (Map.Entry<Integer, Integer> value: map.entrySet()) {
      if(value.getValue() != 0) {
        return false;
      }
    }
    return true;

  }
  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected); 
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  public void run() {
    int[] array_a_1 = {1, 2, 3, 4};
    int[] array_b_1 = {1, 4, 3, 2};
    boolean expected_1 = true;
    boolean output_1 = areTheyEqual(array_a_1, array_b_1); 
    check(expected_1, output_1); 

    int[] array_a_2 = {1, 2, 3, 4};
    int[] array_b_2 = {1, 4, 3, 3};
    boolean expected_2 = false;
    boolean output_2 = areTheyEqual(array_a_2, array_b_2); 
    check(expected_2, output_2); 
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new ReverseToEqual().run();
  }
}