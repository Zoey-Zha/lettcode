package com.zoey.lettcode.string;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int front = 0;
        int end = s.length() -1;
        int count1 = 1;
        while (count1 >= 0 && front <= end) {
            System.out.println("start = " + front + "[" + s.charAt(front) + ", end = " + end + "[" + s.charAt(end));
            if(s.charAt(front) == s.charAt(end)) {
                front++;
                end --;
            }
            else if (s.charAt((front+1)) == s.charAt(end)) {
                count1--;
                front = front + 2;
                end --;
            }
            else {
                count1 = -1;
            }
        }
        // boolean res1 = count<0?false:true;
        int count2 = 1;
        front = 0;
        end = s.length() -1;
        while (count2 >= 0 && front <= end) {
            System.out.println("start = " + front + "[" + s.charAt(front) + ", end = " + end + "[" + s.charAt(end));
            if(s.charAt(front) == s.charAt(end)) {
                front++;
                end --;
            }
            else if (s.charAt(front) == s.charAt((end -1))) {
                count2--;
                front++;
                end = end - 2;
            }
            else {
                count2 = -1;
            }
        }
        return (count1>=0 || count2>=0);

    }

    public static void main(String[] args) {
        ValidPalindrome2 palindrome2 = new ValidPalindrome2();
        String s = "abcdefdcba";



        String test = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println("result of " + palindrome2.validPalindrome(test));
        //System.out.println(test.length());
        // System.out.println(test.charAt(99));
//        for (int i = 0,j = test.length()-1; i <= j;i++,j-- ){
//            System.out.println("i = " + i + "[" + test.charAt(i) + ", j = " + j + "[" + test.charAt(j));
//        }
    }
}
