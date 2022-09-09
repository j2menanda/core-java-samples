package com.nanda.java.samples.meta;
import java.util.*;
public class OptimizeShipment {

	public static void main(String[] args) {
		Shipment s = new Shipment();
		List<List<String>> vals = new ArrayList<List<String>>();
		List<String> in1 = new ArrayList<>();
		in1.add("Input");
		in1.add("P1");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Input");
		in1.add("P2");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Ship");
		in1.add("-");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Input");
		in1.add("P3");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Input");
		in1.add("P4");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Input");
		in1.add("P5");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Input");
		in1.add("P6");
		vals.add(in1);
		in1 = new ArrayList<>();
		in1.add("Ship");
		in1.add("-");
		vals.add(in1);
		in1.add("Ship");
		in1.add("-");
		vals.add(in1);
		in1.add("Ship");
		in1.add("-");
		vals.add(in1);
		List<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(3);
		nums.add(3);
		nums.add(3);
		System.out.println(nums);
		List<List<String>> out = s.getOptimizedList(vals, 3);
		System.out.println(out);
	}

}

class Shipment {
	
	public List<List<String>> getOptimizedList(List<List<String>> vals, int len) {
		List<List<String>> out = new ArrayList<List<String>>();
		ArrayDeque<String> out1 = new ArrayDeque<>();
		List<String> ship = new ArrayList<>();
		for(List<String> in : vals) {
			if(in.get(0).equals("Input")) {
				System.out.println("adding to out1" + in.get(1));
				out1.add(in.get(1));
			} else if(in.get(0).equals("Ship")) {
				System.out.println("check shipping");
				if(out1.size() < len) {
					out.add(Arrays.asList("N/A"));
				} else {
					ship.add(out1.poll());
					ship.add(out1.poll());
					ship.add(out1.poll());
					out.add(ship);
					ship = new ArrayList<>();
				}
			}
		}
		
		/*out1.add("N/A");
		out.add(out1);
		out1 = new ArrayList<>();
		out1.add("P1");
		out1.add("P2");
		out1.add("P3");
		out.add(out1);*/
		return out;
	}
}