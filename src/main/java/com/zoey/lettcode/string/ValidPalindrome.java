package com.zoey.lettcode.string;

import java.util.regex.Pattern;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        int begin = 0;
        int end = s.length()-1;
        boolean flag = true;
        System.out.println("s = " + s);
        System.out.println(s.length());
        System.out.println("mid: " + (s.length()/2-1));
        while(begin <= (s.length()/2-1)) {
            if (s.charAt(begin) != s.charAt(end)) flag = false;
            begin ++;
            end --;
        }
        if (flag) System.out.println("对称的");
        else System.out.println("不对称的");

    }
}
