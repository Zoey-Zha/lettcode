package com.zoey.lettcode.sort;

import java.util.*;

public class KthWeakestRowsInMatrix {

    // bucket sort
    public int[] kWeakestRowsBucket(int[][] mat, int k) {
        int[] res = new int[k];
        List<Integer>[] lists = new List[mat[0].length+1];
        // 一直报空指针错误，原来这个的问题,下面的是错的
//        for (List<Integer> list:lists) list = new ArrayList<>();
        for (int i = 1; i < lists.length; i++)
            lists[i] = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            // int sum = Arrays.stream(mat[i]).sum();
            int sum = numOnes(mat[i]);
            lists[sum].add(i);
        }
        for (int i = 1; i < lists.length; i++) {
            lists[i].sort((a, b) -> (a-b));
        }
        int index = 0;
        for (int i = 0; i< lists.length; i++){
            // lists[i]是arraylist,先要判断是否lists[i]是否为空
            if(lists[i] != null) {
                for (int n : lists[i]) {
                    if (index < k) res[index++] = n;
                    if (index == k) return res;
                }
            }
        }

        return res;

    }


    // heap
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }



    public int[] kWeakestRows(int[][] mat, int k) {

        int[] soldiersOfRow = new int[mat.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (soldiersOfRow[o1] == soldiersOfRow[o2]) {
                    return o2-o1;
                } else {
                    return soldiersOfRow[o2] - soldiersOfRow[o1];
                }
            }
        });

        int index = 0;

        for (int[] row : mat) {
            soldiersOfRow[index] = numOnes(row);
            int count = soldiersOfRow[index];
            if (heap.size() < k) {
                heap.add(index);
            } else {
                heap.add(index);
                heap.poll();
            }
            index ++;
        }

        int[] res = new int[k];
        int indexRes = k-1;
        while(heap.size() > 0) {
            res[indexRes--] = heap.poll();
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1},
        };

        KthWeakestRowsInMatrix matrix = new KthWeakestRowsInMatrix();
        int[] res = matrix.kWeakestRows(mat,3);
        System.out.println("res = " + Arrays.toString(res));

    }
}
