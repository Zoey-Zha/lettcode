package com.zoey.lettcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class SubarraySumEquals {

    // 这个方法subarray可以跳
    public int subarraySum_old(int[] nums, int k) {
        int count = 0;
        // HashMap<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        HashSet<Integer> hashSet = new HashSet<>();

        // 所有等待的元素，以满足加和等于k
        HashMap<Integer,Integer> waiList = new HashMap<>();


        for (int num : nums) {
            // 判断新的一个元素和HashMap wait list中
            count = num == k ? count+1:count+0;
            count  += waiList.getOrDefault(num,0);
            // hashMap.put(num,hashMap.getOrDefault(num,1));

            HashMap<Integer,Integer> tmp = new HashMap<>();
            // 这样map会无限循环
            for (int key: waiList.keySet()) {
                // 放入新元素与历史的差值，更新新的wait numbers
                tmp.put(key - num, tmp.getOrDefault(key-num,0) + 1);
            }
            for (int key: tmp.keySet()) {
                waiList.put(key, waiList.getOrDefault(key,0) + 1);
            }
            // 把新的num 加入wait
            waiList.put(k-num, waiList.getOrDefault(k-num,0) + 1);

        }
        for (Map.Entry<Integer,Integer> entry: waiList.entrySet())
          System.out.println("Key " + entry.getKey() + ", Value = " + entry.getValue());

        return count;

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int sum = 0;
            if (num == k) count ++;

        }

        return 1;
    }
    public static void main(String[] args) {
        SubarraySumEquals equals = new SubarraySumEquals();
        int[] nums = {1,2,3};
        System.out.println("count = " + equals.subarraySum(nums,2));

//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(1,1);
//        map.put(2,1);
//        map.put(3,1);
//
//        for (int key: map.keySet()) {
//            System.out.println("test key: " + key);
//        }


    }
}
