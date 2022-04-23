package com.zoey.lettcode.string;

import static java.lang.Math.abs;

public class Test {

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n%2 == 0) {
            int a = n/2;
            return isPowerOfTwo(a);
        }
        else return false;
    }
    public static void main(String[] args) {
        int a = 33;
        // int count = Integer.bitCount(1);
        System.out.println(isPowerOfTwo(33));

//        int a = Math.abs(-32);
//        String result = Integer.toBinaryString(a);
//        System.out.println("result=-32的二进制位分别是:" + result);
//        int length = result.length();
//        char c = result.charAt(0); // 第一个位置数字
//        System.out.println("第一个字符：" + c);
//        result = result.replaceAll("0","");
//        System.out.println("替换0后result: " + result);
//        System.out.println("result长度：" + result.length());
//
//        double test = Math.pow(2,-1);
//        System.out.println("pow(2,):" + test);


    }
}



