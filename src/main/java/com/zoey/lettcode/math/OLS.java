package com.zoey.lettcode.math;

import java.util.Arrays;

public class OLS {

    public static void main(String[] args) {
        double[] prices = {5.87,6.38,6.44, 6.28, 6.68, 7.02, 7.08};

        double aveY = Arrays.stream(prices).sum()/prices.length;
        System.out.println("Average of Y = " + aveY);

        double aveX = 4;
        System.out.println("Average of X = " + aveX);

        double up = 0;
        double down = 0;

        for (int i = 0; i < prices.length; i ++) {
            up = up + (i+1-aveX)*(prices[i]-aveY);
            down = down + (i+1-aveX)*(i+1-aveX);
        }
        double a = up/down;
        double b = aveY - a*aveX;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("The price of 1979 : " + (a*8+b));
        System.out.println("The price of 1980 : " + (a*9+b));

    }
}
