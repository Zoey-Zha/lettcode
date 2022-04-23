package com.zoey.lettcode.math;

public class ClimbingStairs {
    public static void main(String[] args) {

         int i = climbStairs(5);
         System.out.println(i);

        //int n = 1;
        // while (n-- > 0) System.out.println("n-- 测试" + n);
        // 对于n-- > 0，从这里看是先判断n是否大于0，然后再执行n--

    }
    public static int climbStairs(int n) {

            int a = 1, b = 1;
            int tmp;
//            while (n-- > 0) {
//                System.out.println("测试n--的值" + n);
//                a = (b += a) - a;
//            }
            while (n > 0) {
                System.out.println("测试n--的值" + n);
                a = (b += a) - a;
                n--;
            }
            return a;

    }

}
