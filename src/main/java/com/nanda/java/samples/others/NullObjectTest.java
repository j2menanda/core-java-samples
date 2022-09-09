package com.nanda.java.samples.others;

class NullObject
{
}
public class NullObjectTest {
	public static void main(String[] args) {
		NullObject test = new NullObject();
		NullObject t = test;
		test = null;
	}
}