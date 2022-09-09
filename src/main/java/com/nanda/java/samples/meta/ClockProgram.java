package com.nanda.java.samples.meta;
/*Rotary Lock (Chapter 1)
Level 1
Time limit: 5s
Not started
Note: Chapter 2 is a harder version of this puzzle.
You're trying to open a lock. The lock comes with a wheel which has the integers from 11 to NN arranged in a circle in order around it (with integers 11 and NN adjacent to one another). The wheel is initially pointing at 11.
For example, the following depicts the lock for N = 10N=10 (as is presented in the second sample case).

It takes 11 second to rotate the wheel by 11 unit to an adjacent integer in either direction, and it takes no time to select an integer once the wheel is pointing at it.
The lock will open if you enter a certain code. The code consists of a sequence of MM integers, the iith of which is C_iC 
i
​
 . Determine the minimum number of seconds required to select all MM of the code's integers in order.
Please take care to write a solution which runs within the time limit.

Constraints
3≤N≤50,000,000
1≤M≤1,000
1≤Ci≤N

Sample test case #1
N = 3
M = 3
C = [1, 2, 3]
Expected Return Value = 2
Sample test case #2
N = 10
M = 4
C = [9, 4, 4, 8]
Expected Return Value = 11
Sample Explanation
In the first case, there are 3 integers on the lock, and the sequence of integers to be selected is [1, 2, 3][1,2,3]. One optimal way to enter the code is: select 1 \rightarrow→ rotate to 2 (1 second) \rightarrow→ select 2 \rightarrow→ rotate to 3 (1 second) \rightarrow→ select 3. The total time taken is 1 + 1 = 1+1=2 seconds.

In the second case, the lock consists of the integers 11 through 1010, and the sequence to be selected is [9, 4, 4, 8][9,4,4,8]. One optimal way to enter the code is: rotate from 11 backwards to 99 (22 seconds) \rightarrow→ select 99 \rightarrow→ rotate forwards to 44 (55 seconds) \rightarrow→ select 44 twice \rightarrow→ rotate forwards to 88 (44 seconds) \rightarrow→ select 88. The total time taken is 2 + 5 + 4 = 112+5+4=11 seconds.*/

public class ClockProgram{

     public static void main(String []args){
        System.out.println("Hello World");
        //int[] C = {1, 2, 3}; int N = 3; int M = 3;
        int[] C = {9,4,4, 8}; int N = 10; int M = 4;
        Clock c = new Clock();
        System.out.println("seconds " + c.getMinCodeEntryTime(N, M, C));
        
     }
}

class Clock {
    public long getMinCodeEntryTime(int N, int M, int[] C) {
        int count = 0;
        int median = (N/2);
        int curIndex = 1;
        System.out.println("median is " + median);
        for(int code : C){
            int diff = 0;
            if(code > curIndex){
                diff = code - curIndex;
            } else {
                diff = code+N - curIndex;
            }
            
            if(diff <= median){
                count += diff;
            } else {
                count += (N-diff);
            }
            curIndex = code;
            System.out.println("" + diff);
        }
        return count;
    }
}