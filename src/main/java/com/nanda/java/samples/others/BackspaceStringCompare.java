package com.nanda.java.samples.others;

import java.util.Stack;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        return format(s).equals(format(t));
    }

    private static String format(String str) {
        char c[] = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '#' && !stack.isEmpty()) {
                stack.pop();
            }
            if (c[i] != '#') {
                stack.push(c[i]);
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] s) {
        System.out.println(" {} "+BackspaceStringCompare.backspaceCompare("ab##", "c#d#"));
    }
}