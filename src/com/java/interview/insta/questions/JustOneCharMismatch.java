package com.java.interview.insta.questions;

public class JustOneCharMismatch {
    public static void main(String[] args) {

        String[] array= {"bana","apple","banaba","bananza"};
        String matcher = "banana";
        //output: banaba
        //As one char mismatch banaba and banana(given matcher)

        for (String word:array){
            if(isOneCharMisMatch(word,matcher)){
                System.out.println(word);
            }
        }
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
