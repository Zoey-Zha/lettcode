package com.zoey.lettcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0]-o1[0];
                } else {
                    return o2[1]-o1[1];
                }
            }
        });

        int[] soldiersOfRow = new int[mat.length];
        int index = 0;

        for (int[] row : mat) {
            soldiersOfRow[index] = Arrays.stream(row).sum();
            int[] count = {index,soldiersOfRow[index]};
            if (heap.size() < k) {
                heap.add(count);
            } else {
                if (count[1] < heap.peek()[1] || (count[1] == heap.peek()[1] && count[0] < heap.peek()[0])) {
                    heap.poll();
                    heap.add(count);
                }
            }
            index ++;
        }

        int[] res = new int[heap.size()];
        int indexRes = heap.size()-1;
        while(heap.size() > 0) {
            res[indexRes--] = heap.poll()[0];
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
