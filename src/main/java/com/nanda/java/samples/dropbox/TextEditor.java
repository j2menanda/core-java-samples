package com.nanda.java.samples.dropbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextEditor {
    public static void main(String[] args) {
        String[]output = TextEditor.solution(new String[][]{{"APPEND", "Hey "}, {"APPEND", "You, n"}, {"MOVE", "2"}, {"BACKSPACE"}});
        Arrays.stream(output).forEach(s -> System.out.println(s));
    }

    private static String[] solution(String[][] queries) {
        List<String> texts = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int cursorPosition = 0;
        for(String[] query : queries) {
            String text = query[0];
            if("append".equalsIgnoreCase(text)) {
                sb.append(query[1]);
                cursorPosition = sb.capacity();
            } else if ("move".equalsIgnoreCase(text)) {
                cursorPosition = Integer.valueOf(query[1]);
            } else if("backspace".equalsIgnoreCase(text)) {
                if(cursorPosition > 0) {
                    sb.deleteCharAt(cursorPosition);
                }
            }
            texts.add(sb.toString());
        }
        return texts.toArray(new String[texts.size()]);
    }
}
