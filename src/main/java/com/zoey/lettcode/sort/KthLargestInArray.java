package com.zoey.lettcode.sort;

import java.util.PriorityQueue;

public class KthLargestInArray {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<>((str1, str2) -> (Integer.parseInt(str1)-Integer.parseInt(str2)));
        for (String i : nums) {
            if (heap.size() < k) heap.add(i);
            else {
                int a = Integer.parseInt(i);
                int b = Integer.parseInt(heap.peek());
                if (a > b) {
                    heap.poll();
                    heap.add(i);
                }
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestInArray strInt = new KthLargestInArray();
        String[] nums = {"3", "6", "7", "10"};
        //System.out.println(strInt.kthLargestNumber(nums,4));

        String[] nums1 = {"2", "21", "12", "1"};
        //System.out.println(strInt.kthLargestNumber(nums1,3));

        String[] nums2 = {"0", "0"};
        //System.out.println(strInt.kthLargestNumber(nums2,2));

        String[] test = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        // System.out.println("test " + Integer.parseInt("723091307"));
        // System.out.println(Long.parseLong("6888794705"));
        System.out.println(Double.parseDouble("688879470568887947056888794705"));
        // System.out.println("Max Integer = " + Integer.MAX_VALUE);
    }
}
