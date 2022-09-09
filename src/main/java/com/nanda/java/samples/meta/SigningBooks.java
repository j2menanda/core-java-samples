package com.nanda.java.samples.meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SigningBooks {

    public static void main(String[] args) {
        int[] input = {3, 2, 4, 1};
        int[] output = SigningBooks.findSignatureCounts(input);
        Arrays.stream(output).forEach(System.out :: print);
    }

    private static int[] findSignatureCounts(int[] sa) {
        if(null == sa || sa.length == 0)
            return null;

        Map<Integer, Integer> signatureCounts = new HashMap<>();
        int[] ca = new int[sa.length];
        int[] ta = new int[sa.length];
        for (int i=0; i < sa.length; i++) {
            ca[i] = i+1;
        }
        int count = 1;
        for (int i=0; i < sa.length; i++) {
            ta[sa[i]-1]=ca[i];
            if(i+1 != ca[i]) {
                ta[sa[i]-1]=ca[i];
            //    ca[sa[i]] = ca[i];

//                int temp = sa[i] + ca[sa[i]-1];
//                ca[sa[i]-1] = temp - ca[sa[i]];
//                sa[i] = temp - ca[sa[i]-1];

//                tempSigns[signatures[i]-1] = signatures[i];
                Integer updatedCount = signatureCounts.get(i+1);
                if(updatedCount != null) {
                    signatureCounts.put(i+1, ++updatedCount);
                } else {
                    signatureCounts.put(i+1, count);
                }
            }

            System.out.println(signatureCounts.size() + " {} " + signatureCounts);
        }

        return signatureCounts.values().stream().mapToInt(j -> j)./*filter(t -> t != null).mapToInt(t -> t).*/toArray();
    }
}
