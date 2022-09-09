package com.nanda.java.samples.meta;

public class InterviewTest {

	public static void main(String[] args) {
		System.out.println("Hello World");
		Question q = new Question();
		q.printSth("Java");
		System.out.println("sum is " + q.returnSth(6, 9));
	}
}

class Question {
	
	public void printSth(String str) {
		System.out.println("Hello World : " + str);
	}

	public int returnSth(int i, int j) {
		return i+j;
	}
}