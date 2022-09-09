package com.nanda.java.samples.meta;

public class RotaryClockLevel2{

     public static void main(String []args){
        System.out.println("Hello World");
        //int[] C = {1, 2, 3}; int N = 3; int M = 3;
        //int[] C = {9,4,4, 8}; int N = 10; int M = 4;
        int[] C = {9, 4, 4, 8, 6, 2, 5, 1}; int N = 10; int M = 8;
        ClockTwoWheel c = new ClockTwoWheel();
        System.out.println("seconds " + c.getMinCodeEntryTime(N, M, C));
        
     }
}

class ClockTwoWheel {
    public long getMinCodeEntryTime(int N, int M, int[] C) {
        int count = 0;
        int median = (N/2);
        int curIndex1 = 1, curIndex2 = 1;
        System.out.println("median is " + median);
        for(int code : C){
            int diff1 = 0, diff2 = 0;
            if(code >= curIndex1){
                diff1 = code - curIndex1;
            } else {
                diff1 = code+N - curIndex1;
            }
            
            if(code >= curIndex2){
                diff2 = code - curIndex2;
            } else {
                diff2 = code+N - curIndex2;
            }
            if(diff1 > median){
                diff1 = N-diff1;
            }
            if(diff2 > median){
                diff2 = N-diff1;
            }
            if(diff1 < diff2) {
            	count += diff1;
            	curIndex1 = code;
            } else {
            	count += diff2;
            	curIndex2 = code;
            }
            System.out.println("" + count);

        }
        return count;
    }
}