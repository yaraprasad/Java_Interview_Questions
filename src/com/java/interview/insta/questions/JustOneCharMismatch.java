package com.java.interview.insta.questions;

import java.util.Arrays;
import java.util.Optional;

public class JustOneCharMismatch {
    public static void main(String[] args) {

        String[] array= {"bana","apple","banaba","bananza"};
        String matcher = "banana";
        //output: banaba
        //As one char mismatch banaba and banana(given matcher)

        //Approach 1
        for (String word:array){
            if(isOneCharMisMatch(word,matcher)){
                System.out.println(word);
            }
        }

        //Approach 2
        Optional<String> result =
                Arrays.stream(array)
                        .filter(s -> s.length() == matcher.length())
                        .filter(s -> {
                            int mismatches = 0;
                            for (int i = 0; i < s.length(); i++) {
                                if (s.charAt(i) != matcher.charAt(i)) {
                                    mismatches++;
                                    if (mismatches > 1) return false;
                                }
                            }
                            return mismatches == 1;
                        })
                        .findFirst();

        result.ifPresent(System.out::println);
    }

    public static  boolean isOneCharMisMatch(String word, String matcher){
        if(word.length()!=matcher.length()){
            return false;
        }
        int mismatchCount=0;
        for (int i = 0; i < matcher.length() ; i++) {
            if(word.charAt(i)!=matcher.charAt(i)){
                mismatchCount++;
                if(mismatchCount>1){
                    return false;
                }
            }
        }
        return true;
    }


}
