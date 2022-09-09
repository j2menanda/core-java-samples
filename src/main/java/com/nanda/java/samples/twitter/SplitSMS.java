package com.nanda.java.samples.twitter;

import java.util.List;
import java.util.ArrayList;

public class SplitSMS {
    public static void main(String[] args) {
        String message = "Write a function that splits a long SMS string into smaller pieces. Each piece should be less than or equal to 160 characters and include a formatted index counter at the end (for example, � (2/5)�). The function  should avoid breaking words into pieces. If a word does not fit, it should  go to the next SMS";
        List<String> result = SplitSMS.getMessages(message);
        for(int i=0; i< result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    
    private static List<String> getMessages(String message) {
        List<String> list = new ArrayList<>();
        int maxLength = 160;
        if(message != null && message.length() < maxLength) {
            list.add(message);
            return list;
        }
        int count = 0;
        int length = 6;
        String[] msgs = message.split(" ");
        int lengthOfMessage = 0;
        int countOfMessages = (int)Math.ceil((double)message.length()/maxLength);
        System.out.println("Message Length {} "+message.length() +  "SMS COUNT {} "+ countOfMessages + "}" );
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < msgs.length; i++) {
            lengthOfMessage+=msgs[i].length() + 1;
            if(lengthOfMessage < maxLength-length) {
                sb.append(msgs[i]+" ");
            }
            if(lengthOfMessage >= maxLength-length) {
            	count++;
                list.add(sb.toString()+ " (" +count+"/"+countOfMessages+")");
				//list.add(sb.toString()+ " (" + i+1 +"/"+countOfMessages+")");
                lengthOfMessage=0;
            }
        }
        return list;
    }    
}