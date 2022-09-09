package com.nanda.java.samples.meta;
import java.util.List;
import java.util.ArrayList;
public class SmallerDivisor{

     public static void main(String []args){
        System.out.println("Hello World");
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(12);
        nums.add(5);
        System.out.println("solution : " + minDiv(nums, 6));
        
     }
     
     public static int minDiv(List<Integer> nums, int threshold){
        boolean solutionFound = false;
        int j = 0;
        int sum = 0;
        while(!solutionFound){
            sum = 0;
            j++;
            for(int i = 0; i < nums.size(); i++){
                double a = nums.get(i);
                double div = Math.ceil(a/j);
                sum += div;
                System.out.println("div is " + div + " sum " + sum);
            }
            if(sum < threshold) {
                solutionFound = true;
            }
            
        }
        return j;
     }
}