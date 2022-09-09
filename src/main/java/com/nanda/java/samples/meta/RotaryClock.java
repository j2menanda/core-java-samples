package com.nanda.java.samples.meta;

public class RotaryClock{

     public static void main(String []args){
        System.out.println("Hello World");
        //int[] C = {1, 2, 3}; int N = 3; int M = 3;
        int[] C = {9,4,4, 8}; int N = 10; int M = 4;
        ClockOneWheel c = new ClockOneWheel();
        System.out.println("seconds " + c.getMinCodeEntryTime(N, M, C));
        
     }
}

class ClockOneWheel {
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