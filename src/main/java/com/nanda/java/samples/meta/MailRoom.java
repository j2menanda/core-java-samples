package com.nanda.java.samples.meta;
/*
You are the manager of a mail room which is frequently subject to theft. A period of NN days is about to occur, such that on the iith day, the following sequence of events will occur in order:
A package with a value of V_iV 
i
​
  dollars will get delivered to the mail room (unless V_i = 0V 
i
​
 =0, in which case no package will get delivered).
You can choose to pay CC dollars to enter the mail room and collect all of the packages there (removing them from the room), and then leave the room
With probability SS, all packages currently in the mail room will get stolen (and therefore removed from the room).
Note that you're aware of the delivery schedule V_{1..N}V 
1..N
​
 , but can only observe the state of the mail room when you choose to enter it, meaning that you won't immediately be aware of whether or not packages were stolen at the end of any given day.
Your profit after the NNth day will be equal to the total value of all packages which you collected up to that point, minus the total amount of money you spent on entering the mail room.
Please determine the maximum expected profit you can achieve (in dollars).
Note: Your return value must have an absolute or relative error of at most 10^{-6}10 
−6
  to be considered correct.
Constraints
1 \le N \le 4{,}0001≤N≤4,000
0 \le V_i \le 1{,}0000≤V 
i
​
 ≤1,000
1\le C \le 1{,}0001≤C≤1,000
0.0 \le S \le 1.00.0≤S≤1.0
Sample test case #1
N = 5
V = [10, 2, 8, 6, 4]
C = 5
S = 0.0
Expected Return Value = 25.00000000
Sample test case #2
N = 5
V = [10, 2, 8, 6, 4]
C = 5
S = 1.0
Expected Return Value = 9.00000000
Sample test case #3
N = 5
V = [10, 2, 8, 6, 4]
C = 3
S = 0.5
Expected Return Value = 17.00000000
Sample test case #4
N = 5
V = [10, 2, 8, 6, 4]
C = 3
S = 0.15
Expected Return Value = 20.10825000
*/