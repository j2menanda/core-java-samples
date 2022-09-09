package com.nanda.java.samples.meta;

import java.util.*;
public class FindPower {

	public static void main(String[] args) {
		PrivateFindPower p = new PrivateFindPower();
		List<Integer> power = new ArrayList<>();
		power.add(2);
		power.add(1);
		power.add(3);
		power.add(1);
		System.out.println("Total power is " + p.findTotalPower(power));
	}

}

class PrivateFindPower {

	public int findTotalPower(List<Integer> power) {
		int out = 0;
		int p = 0, min = 0, sum = 0;
		int m = 1000000007;
		for(int i=0; i<power.size(); i++) {
			min = power.get(i);
			sum = 0;
			for(int j=i; j<power.size(); j++) {
				min = Math.min(min,  power.get(j));
				sum += power.get(j);
				System.out.println("min is " + min + " sum = " + sum);
				p = (min*sum)%m;
				out += p;
			}
		}
		return out;
	}

	public int findTotalPower1(List<Integer> power) {
		int out = 0;
		int p = 0, min = 0, sum = 0;
		int m = 1000000007;
		for(int i=0; i<power.size(); i++) {
			for(int j=i; j<power.size(); j++) {
				min = power.get(i);
				sum = 0;
				for(int k=i ; k<=j; k++) {
					min = Math.min(min,  power.get(k));
					sum += power.get(k);
				}
				System.out.println("min is " + min + " sum = " + sum);
				p = (min*sum)%m;
				out += p;
			}
		}
		return out;
	}
}