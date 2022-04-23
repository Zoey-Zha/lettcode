package com.zoey.lettcode.string;

public class DecodeString {
    public String decodeString(String s) {

        String res = "";
        int num = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 0 && s.charAt(i) < 10) num = s.charAt(i);
            if(s.charAt(i) == '[') {
                start = i + 1;
            }
            if (s.charAt(i) == ']') {
                end = i-1;
            }


        }

        return res;
    }
}
