package com.zoey.lettcode.sort;

import java.util.*;

public class TopKFrequentE {
    private static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        // 取K个值存到heap中
        int peek = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
            if (map.get(key) >= map.getOrDefault(peek,0)) {
                heap.add(key);
                peek = heap.peek();
                System.out.println("peek = " + peek);
                if (heap.size() > k) heap.poll();
            }
        }

        // heap中的值放入list中
        int index = 0;
        while (heap.size() > 0) {
            System.out.println("res = " + heap.peek());
            res[index++] = heap.poll();

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3};
        int[] res = topKFrequent(nums,2);
        System.out.println(Arrays.toString(res));

    }
}
