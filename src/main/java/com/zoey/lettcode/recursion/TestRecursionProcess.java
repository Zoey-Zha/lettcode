package com.zoey.lettcode.recursion;

public class TestRecursionProcess {
    private static int abc(int a) {
        if (a == 0) return 1;
        System.out.println("before calls abc function, a = " + a);
        int b = abc(a=a-2)+1;
        System.out.println("after calls abc, abc(" + (a+2) + ") = " + b);
        return b;
    }

    public static void main(String[] args) {
        int i = 6;
        System.out.println(abc(i));
        // 执行过程分析
        // abc(6) = { int b = abc(4) + 1}; b= (abc(0) + 1) + 1 + 1;
        // abc(4) = { int b = abc(2) + 1}; b = (abc(0) + 1) + 1;
        // abc(2) = { int b = abc(0) + 1};
    }
}
