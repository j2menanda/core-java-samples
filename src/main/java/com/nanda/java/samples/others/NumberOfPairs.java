package com.nanda.java.samples.others;

public class NumberOfPairs {
    public static void main(String[] args) {
        int[] numbers = null;
        int difference = 2;
        if(null != args && args.length > 0) {
            numbers = new int[args.length];

            for (int i=0; i < args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }
        }
        System.out.println(new NumberOfPairs().getNumberOfPairs(numbers, difference));
    }

    private int getNumberOfPairs(final int[] numbers, int difference) {
        int count = 0;
        if(null != numbers && numbers.length > 0) {
            for (int i=0; i < numbers.length; i++) {
                int j = 0;
                do {
                    if(((numbers[i] - numbers[j]) == difference))
                        count++;

                    j++;
                } while (j < numbers.length);
            }
        }
        return count;
    }
}