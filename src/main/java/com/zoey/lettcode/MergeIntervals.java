package com.zoey.lettcode;

public class MergeIntervals {
    public static void main(String[] args) {


    }

    public int[][] merge(int[][] intervals) {
        //System.out.println(intervals.length);
        for (int[] innerArray: intervals) {
            // second for...each loop access each element inside the row
            for(int data: innerArray) {
                System.out.println(data);
            }
        }
        int[][] res = {{1,4}};
        return res;
    }
}
