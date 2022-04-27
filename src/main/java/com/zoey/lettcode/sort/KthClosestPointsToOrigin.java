package com.zoey.lettcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        // PriorityQueue存什么，如果只存length 那么不满足返回条件
        // 存成array, 每次计算？然后把

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->
                (b[0]*b[0]+b[1]*b[1] - a[0]*a[0] - a[1]*a[1]));

        for (int[] row : points) {
            if (heap.size() < k) heap.add(row);
            else {
                if ((pow(row[0],row[1]) < pow(heap.peek()[0],heap.peek()[1]))) {
                    heap.poll();
                    heap.add(row);
                }
            }
        }
        int[][] res = new int[heap.size()][2];
        while (heap.size() > 0) {
            res[heap.size()-1] = heap.peek();
            heap.poll();
        }
        return res;
    }

    public static int pow(int a, int b) {
        return a*a + b*b;
    }

    public static void main(String[] args) {
        // points = [[1,3],[-2,2]], k = 1
        int[][] points = {
                {1,3},
                {-2,2}
        };
        // points = [[3,3],[5,-1],[-2,4]], k = 2
        int[][] points1 = {
                {3,3},
                {5,-1},
                {-2,4}
        };
        // points = [[3,3],[5,-1],[-2,4],[0,1]], k = 2
        // 有两个想等的，但是必须扔掉一个，扔哪个呢？
        int[][] points2 = {
                {3,3},
                {5,-1},
                {-2,4},
                {0,1}
        };
        KthClosestPointsToOrigin example = new KthClosestPointsToOrigin();
        int[][] res = example.kClosest(points,1);
        int[][] res1 = example.kClosest(points1,2);
        int[][] res2 = example.kClosest(points2,2);


        // System.out.println(Arrays.deepToString(res));
        // System.out.println(Arrays.deepToString(res1));
        System.out.println(Arrays.deepToString(res2));
    }
}
