package com.nanda.java.samples.others;

public class Pairs {
    public static void main(String[] args) {
        int sum = 4;
        int[] numbers = {1, 2, 3, 4};
        
        System.out.println(new Pairs().getNumberOfPairs(numbers, sum));
    }
    
    private int getNumberOfPairs(int[] numbers, int sum) {
        int count = 0;
        if(null != numbers && numbers.length > 0) {
            for(int i = 0; i < numbers.length - 1; i++) {
                int j = i+1;
                do {
                    if((numbers[i] + numbers[j]) == sum)
                        count++;
                    
                    j++;
                } while(j < numbers.length);
            }
        }
        return count;
    }    
}
