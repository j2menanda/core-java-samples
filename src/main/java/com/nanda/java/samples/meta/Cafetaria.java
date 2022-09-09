package com.nanda.java.samples.meta;
/*A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. 
Social distancing guidelines require that every diner be seated such that K seats to their left and K seats to their right (or all the remaining seats to that side if there are fewer than K) remain empty.
There are currently M diners seated at the table, the ith of whom is in seat Si 

 . No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 
 
Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
Please take care to write a solution which runs within the time limit.
Constraints
1 \le N \le 10^{15}1≤N≤10 
15
 
1 \le K \le N1≤K≤N
1 \le M \le 500{,}0001≤M≤500,000
M \le NM≤N
1 \le S_i \le N1≤S 
i
​
 ≤N
Sample test case #1
N = 10
K = 1
M = 2
S = [2, 6]
Expected Return Value = 3
Sample test case #2
N = 15
K = 2
M = 3
S = [11, 6, 14]
Expected Return Value = 1
Sample Explanation
In the first case, the cafeteria table has N = 10N=10 seats, with two diners currently at seats 22 and 66 respectively. The table initially looks as follows, with brackets covering the K = 1K=1 seat to the left and right of each existing diner that may not be taken.
  1 2 3 4 5 6 7 8 9 10
  [   ]   [   ]
Three additional diners may sit at seats 44, 88, and 1010 without violating the social distancing guidelines.
In the second case, only 11 additional diner is able to join the table, by sitting in any of the first 33 seats.*/

public class Cafetaria {

     public static void main(String []args){
        Test a = new Test();
        long[] S = {2, 6};
        long n = 10;
        long k = 1;
        //System.out.println(a.getMaxAdditionalDinersCount1(n, k, S));
        long[] S1 = {1};
        long n1 = 3;
        long k1 = 1;
        //System.out.println(a.getMaxAdditionalDinersCount(n1, k1, S1));
        System.out.println(a.getMaxAdditionalDinersCount1(n1, k1, S1));
     }

}

class Test{

  public long getMaxAdditionalDinersCount1(long N, long K, long[] S) {
      long[] seats = new long[(int)N];
      long sol = 0;
      for(int i = 0; i< N; i++){
          seats[i] = 0;
      }
      for(int i = 0; i < S.length; i ++){
          for(int j = 0; j <= K; j ++){
              if((int)S[i]+j >0 && (int)S[i]+j <= N){
                seats[(int)S[i]+j-1] = 1;
              }
              if((int)S[i]-j >0 && (int)S[i]-j <= N){
                seats[(int)S[i]-j-1] = 1;
              }
          }
      }
      for(int i = 0; i < N;i++){
          System.out.println(seats[i]);
      }
      for(int i = 0; i < N; i++){
          if(seats[i] == 0) {
              sol+=1;
              seats[i] = 1;
              for(int j = 0; j <= K; j ++){
              if((i+j) >=0 && (i+j) < N){
                seats[i+j] = 1;
              }
              if((i-j) >=0 && (i-j) < N){
                seats[i-j] = 1;
              }
          }
    
          }
      } 
      return sol;
  }
    public long getMaxAdditionalDinersCount(long n, long k, long[] s) {
    int sol = 0;
    long prevIndex = 0l;
    long seats = 0;
    for(int i = 0; i < s.length; i++){
        long index = s[i];
        if(prevIndex == 0){
            seats = (index-1)/(k+1);
        } else {
            seats = (index-prevIndex-k-1)/(k+1);
        }
        System.out.println("index " + index + "prev " + prevIndex);
        System.out.println("seats " + seats);
        prevIndex = index;
        sol += seats;
    }
    System.out.println("index " + n + "prev " + prevIndex);
    seats = (n-prevIndex)/(k+1);
    System.out.println("seats " + seats);
    sol += seats;
    return sol;
  } 
  
}
