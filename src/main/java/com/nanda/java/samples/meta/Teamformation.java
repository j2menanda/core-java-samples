package com.nanda.java.samples.meta;
import java.util.List;
import java.util.ArrayList;
public class Teamformation{

     public static void main(String []args){
        System.out.println("Hello World");
        int teamSize = 8;
        int k = 3;
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(8);
        nums.add(6);
        nums.add(18);
        nums.add(8);
        nums.add(14);
        nums.add(10);
        nums.add(12);
        nums.add(18);
        nums.add(9);
        
        
        System.out.println("score " + getScore(nums, teamSize, k));
     }
     
     public static int getScore(List<Integer> nums, int teamSize, int k){
         int score = 0;
         for(int i = 0 ; i < teamSize; i++ ){
            int index = getIndexForHighScore(nums, k);
            System.out.println("high index " + index);
            System.out.println("high score " + nums.get(index));
            score += nums.get(index);
            nums.remove(index);
         }
         return score;
     }
     
     public static int getIndexForHighScore(List<Integer> nums, int k){
        int score = 0;
        int index = 0;
        if(nums.size() < k){
            k = nums.size();
        }
        for(int i = 0 ; i < k; i ++) {
            if(score < nums.get(i)){
                score = nums.get(i);
                index = i;
            }
            if(score < nums.get(nums.size()-i-1)) {
                score = nums.get(nums.size()-i-1);
                index = nums.size()-i-1;
            }
        }
        return index;
     }
     
}