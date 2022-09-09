package com.nanda.java.samples.meta;
/*A positive integer is considered uniform if all of its digits are equal. For example, 222222 is uniform, while 223223 is not.
Given two positive integers A and B, determine the number of uniform integers between A and B, inclusive.
Please take care to write a solution which runs within the time limit.
Constraints
1 \le A \le B \le 10^{12}1≤A≤B≤10 
12
 
Sample test case #1
A = 75
B = 300
Expected Return Value = 5
Sample test case #2
A = 1
B = 9
Expected Return Value = 9
Sample test case #3
A = 999999999999
B = 999999999999
Expected Return Value = 1
Sample Explanation
In the first case, the uniform integers between 7575 and 300300 are 7777, 8888, 9999, 111111, and 222222.
In the second case, all 99 single-digit integers between 11 and 99 (inclusive) are uniform.
In the third case, the single integer under consideration (999{,}999{,}999{,}999999,999,999,999) is uniform.*/

// Write any import statements here

public class UniformIntegers{

     public static void main(String []args){
        long A = 75, B = 300;
        //long A = 1, B = 9;
        //long A = 77, B = 88;
        //long A = 55, B = 300;
        SolutionForUniformIntegers sol = new SolutionForUniformIntegers();
        System.out.println("Num is " + sol.getUniformIntegerCountInInterval(A, B));
     }
}

class SolutionForUniformIntegers {
  
  public int getUniformIntegerCountInInterval(long A, long B) {
    int count = 0;
    int num = 1;
    int digitsInA = getDigitsInN(A);
    int digitsInB = getDigitsInN(B);
    System.out.println("digits " + digitsInA);
    System.out.println("digits " + digitsInB);
    if(digitsInA == digitsInB){
      long multiplier = getMultiplier(digitsInA);
      for(int i=1; i<10; i++){
          if(multiplier*i >= A && multiplier*i <=B){
              count++;
          }
      }
    } else {
        int countForA = getCountForN(A, digitsInA);
        System.out.println("count for A " + countForA);
        count += countForA;
        int countForB = 9-getCountForN(B+1, digitsInB);
        System.out.println("count for B " + countForB);
        count += countForB;
        count += (digitsInB-digitsInA-1)*9;
    }
    
    return count;
  }
  
  public int getDigitsInN(long N){
      long num = 1;
      int count = 1;
      while(num < N){
          long quo = N/num;
          if(quo > 9){
              num *= 10;
              count++;
          }else {
              break;
          }
      }
      return count;
  }
  public int getCountForN(long A, int digits){
      long multiplier = getMultiplier(digits);
      int count = 0;
      for(int i=1; i<10; i++){
          if(multiplier*i >= A){
              count++;
          }
      }
      return count;
  }
  public long getMultiplier(int digits){
      long multiplier = 1;
      long prev = 1;
      for(int i=1; i< digits;i++){
          prev = prev*10;
          multiplier += prev;
      }
      return multiplier;
  }
}
