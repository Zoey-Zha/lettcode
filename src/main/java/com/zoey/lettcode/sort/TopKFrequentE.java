package com.zoey.lettcode.sort;

import java.util.*;

public class TopKFrequentE {

    private static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int[] res = {1,2};


        int[] test = {1};
        heap.contains(test);


        return res;
    }
    private static int[] topKFrequent1(int[] nums, int k) {
        int[] res = new int[k];

        PriorityQueue<int[]> heap = helper(nums,k);
        int n = heap.size();
        for (int i = 0; i < n; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    public static PriorityQueue<int[]> helper(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<int[]> heap1= new PriorityQueue<>((a,b)->(a[1]-b[1]));

        for (int key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));

            int[] a = {key,map.get(key)};

            if (heap1.size() < k) heap1.add(a);
            else {
                int newValue = map.get(key);
                // heap1.peek()[0];
                int peekValue = map.get(heap1.peek()[0]);
                if (newValue > peekValue) {
                    int[] poll = heap1.poll();
                    System.out.println("poll = " + Arrays.toString(poll));
                    heap1.add(a);
                }
            }
        }
        return heap1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3};
        int[] res = topKFrequent(nums,2);
        System.out.println(Arrays.toString(res));

        // test heap || map
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        map1.put(1,5);
        map1.put(2,1);
        map1.put(3,10);
        map1.put(4,6);

        map2.put(1,3);
        map2.put(2,4);

        // merge two maps with duplicates and add the values
        for (int key : map2.keySet()) {
            map1.replace(key,map1.getOrDefault(key,0) + map2.get(key));
        }
        // map1.forEach();

//        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }
        // 升序排列
        // PriorityQueue<>
        // PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->(a-b));
        PriorityQueue<int[]> heap1= new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int limit = 2;
        for (int key : map1.keySet()) {
            // System.out.println("key = " + key + ", value = " + map1.get(key));

            int[] a = {key,map1.get(key)};

            if (heap1.size() < limit) heap1.add(a);
            else {
                int newValue = map1.get(key);
                // heap1.peek()[0];
                int peekValue = map1.get(heap1.peek()[0]);
                if (newValue > peekValue) {
                    int[] poll = heap1.poll();
                    // System.out.println("poll = " + Arrays.toString(poll));
                    heap1.add(a);
                }
            }
        }

        // System.out.println("heap1.size = " + heap1.size());
        int n = heap1.size();
        for (int i = 0; i < n; i++) {
            // System.out.println("TopK keys = " + heap1.poll()[0]);
        }



    }
}
