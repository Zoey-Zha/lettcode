package com.zoey.lettcode.dp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {

        int count = 0;
        int left = amount;
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b-a));
//        for (int coin : coins) {
//            heap.add(coin);
//        }
        Arrays.sort(coins);

        for (int i = coins.length - 1; i >=0; i++ ) {
            for (int j = i; j >=0; j++) {
                int den = coins[j];
                count += left/den;
                left = left%den;
                if (left == 0) return count;
            }
        }

        // 可能的情况是：尽可能使用了大额，但是导致最后无法找到合适的替换方法
        // 这个时候需要尝试别的替换方式


        return amount == 0 ? count : -1;
    }

    public static void main(String[] args) {
//        int[] coins = {2};
//        int amount = 3;

        int[] coins = {186,419,83,408};
        int amount = 6249;
//        int res = coinChange(coins,amount);
        System.out.println(6249-408*14);
        System.out.println(537-419);
        //System.out.println(6249%408);


    }
}
