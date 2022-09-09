package com.nanda.java.samples.meta;

public class FruitsAndBaskets {

	public static void main(String[] args) {
		char[] in = {'A', 'B', 'C','B', 'B', 'C'};
		FarmTraverse f = new FarmTraverse();
		System.out.println("max is " + f.getMaxFruits(in));
	}

}

class FarmTraverse {
	public int getMaxFruits(char[] in) {
		int max = 0, fi1 = 0, fi2 = 0, fc1 = 1, fc2 = 0;
		char f1 = in[0], f2 = '0';
		for(int i=1; i<in.length; i++) {
			if(in[i] == f1) {
				System.out.println("fruit 1 is " + f1);
				fc1++;
				fi1 = i;
			} else {
				if(f2 == '0') {
					f2 = in[i];
					System.out.println("fruit 2 is " + f2);
					fc2++;
					fi2 = i;
				} else {
					if(in[i] == f2) {
						fc2++;
						fi2 = i;
					} else {
						f1 = f2;
						f2 = in[i];
						if(max < (fc1+fc2)) {
							max = fc1+fc2;
						}
						System.out.println("max is " + max + " resetting fruits " + f1 + " " + f2);
						fc1= fc2;
						fc2 = 1;
						fi1=fi2;
						fi2=i;
					}
				}
			}
			System.out.println("fruits are  " + f1 + " " + f2);
		}
		return max;
	}
}