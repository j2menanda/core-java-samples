package com.nanda.java.samples.meta;


public class ScoreBoard{

     public static void main(String []args){
        //int[] S = {1,2,3,4,5,6}; int N = 6;
        int[] S = {4,3,3,4}; int N = 4;
        //int[] S = {2,4,6,8}; int N = 4;
        ScoreBoard1 c = new ScoreBoard1();
        System.out.println("problems " + c.getMinProblemCount(N, S));
        
     }
}

class ScoreBoard1 {
  
  public int getMinProblemCount(int N, int[] S) {
    int numOf2s = 0;
    int numOf1s = 0;
    for( int score : S){
        if(score/2 > numOf2s){
            numOf2s = score/2;
        }
        if(score % 2 != 0 && numOf1s == 0){
            numOf1s = 1;
        }
    }
    return numOf2s + numOf1s;
  }
}