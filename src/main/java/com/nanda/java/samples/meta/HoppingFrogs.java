package com.nanda.java.samples.meta;
/*
A family of frogs in a pond are traveling towards dry land to hibernate. They hope to do so by hopping across a trail of NN lily pads, numbered from 11 to NN in order.
There are FF frogs, numbered from 11 to FF. Frog ii is currently perched atop lily pad P_iP 
i
​
 . No two frogs are currently on the same lily pad. Lily pad NN is right next to the shore, and none of the frogs are initially on lily pad NN.
Each second, one frog may hop along the trail towards lily pad NN. When a frog hops, it moves to the nearest lily pad after its current lily pad which is not currently occupied by another frog (hopping over any other frogs on intermediate lily pads along the way). If this causes it to reach lily pad NN, it will immediately exit onto the shore. Multiple frogs may not simultaneously hop during the same second.
Assuming the frogs work together optimally when deciding which frog should hop during each second, determine the minimum number of seconds required for all FF of them to reach the shore.
Constraints
2 \le N \le 10^{12}2≤N≤10 
12
 
1 \le F \le 500{,}0001≤F≤500,000
1 \le P_i \le N-11≤P 
i
​
 ≤N−1
Sample test case #1
N = 3
F = 1
P = [1]
Expected Return Value = 2
Sample test case #2
N = 6
F = 3
P = [5, 2, 4]
Expected Return Value = 4
Sample Explanation
In the first case, there are 33 lily pads and 11 frog. The frog is initially atop lily pad 11 and will take 22 hops to reach lily pad 33.
In the second case, there are 66 lily pads, with frogs on lily pads 55, 22, and 44. Initially the lily pads and frog numbers can be represented as .2.31.
One optimal sequence of hops is:
Frog 22 hops forward to lily pad 33: 
..231.
Frog 22 hops over frogs 11 and 33, onto lily pad 66 and exiting onto the shore: 
...31.
Frog 33 hops over frog 11, onto lily pad 66 and exiting onto the shore: 
....1.
Frog 11 hops onto lily pad 66, exiting onto the shore.
*/

// Write any import statements here

import java.util.*;
public class HoppingFrogs{

     public static void main(String []args){
        System.out.println("Hello World");
        //long N = 18; int F = 4; long[] P = {16, 4, 5, 7};
        long N = 3; int F = 1; long[] P = {1};
        SolutionForHoppingFrogs s = new SolutionForHoppingFrogs();
        System.out.println("seconds " + s.getSecondsRequired(N, F, P));
     }
}

// Write any import statements here

class SolutionForHoppingFrogs {
  
  public long getSecondsRequired(long N, int F, long[] P) {
    // Write your code here
    long seconds = 0L;
    Map<Long, Integer> frogs = new HashMap();
    for (long value : P) {
        frogs.put(value, 1);
    }
    LinkedList<Integer> pads = new LinkedList<Integer>();
    for(long i=0; i<N; i++){
		if(frogs.get(i+1) != null){
			pads.add(1);
		}else {
			pads.add(0);
		}
    }
    Iterator iter = pads.iterator();
    long prevIndex = -1;
    long index = 0;
    while(iter.hasNext()){
        int val = (int)iter.next();
        if( val != 0){
            if(prevIndex != -1){
                System.out.println("ind " + index + " prev " + prevIndex);
                seconds += index-prevIndex-1;
            }
            prevIndex = index;
        }
        index++;
    }
    seconds += N-1-1-prevIndex+F;
    return seconds;
  }
  
}