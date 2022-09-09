package com.nanda.java.samples.meta;
import java.util.*;

public class RabbitHolesV2 {

	public static void main(String[] args) {
        System.out.println("Hello World");
        //Solution s = new Solution();
        //int N = 4; int[] L = {4,1,2,1}; //sol = 4
        //int N = 5; int[] L = {4,3,5,1,2}; //sol = 3;
        //int N = 5; int[] L = {2,4,2,2,3}; //sol = 4;
        int N = 8; int[] L = {2,4,2,2,3,1,5,3}; // sol = 5;
        //int N = 5; int[] L = {2,4,2,2,4}; // sol = 3
        System.out.println(getMaxVisitableWebpages(N, L));
	}

    public static int getMaxVisitableWebpages(int N, int[] L) {
        int count = 0;
        HashMap<Integer, Set<Integer>> srcnodes = new HashMap<>();
        HashMap<Integer, Set<Integer>> destnodes = new HashMap<>();
        for(int i=1; i<=N; i++) {
        	Set<Integer> srcpages = srcnodes.getOrDefault(i, new HashSet<>());
       		srcpages.add(i);
        	srcnodes.put(i, srcpages);
       		if(count < srcpages.size()) {
        		count = srcpages.size();
        	}

        	Set<Integer> destpages = destnodes.getOrDefault(i, new HashSet<>());
       		destpages.add(i);
       		destpages.add(L[(i-1)]);
       		destnodes.put(L[(i-1)], destpages);
       		if(count < destpages.size()) {
        		count = destpages.size();
        	}
        }
        return count;
    }
    
}
