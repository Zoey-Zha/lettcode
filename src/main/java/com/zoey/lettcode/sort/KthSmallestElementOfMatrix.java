package com.zoey.lettcode.sort;

import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementOfMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int[] rows : matrix) {
            for (int i : rows) {
                if (heap.size() < k) {
                    heap.add(i);
                }
                else {
                    if (i < heap.peek()) {
                        heap.poll();
                        heap.add(i);
                    }
                }
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthSmallestElementOfMatrix kSmall = new KthSmallestElementOfMatrix();
        int[][] matrix = {
                {1,5,9},{10,11,13},{12,13,15}
        };

        int[][] test = {{-5}};
        int res = kSmall.kthSmallest(matrix, 8);
        int res1 = kSmall.kthSmallest(test, 1);
        // System.out.println("res = " + res1);
        System.out.println( "wide = " + test.length + "length = " + test[0].length);
        int colIndex = 8/(matrix[0].length);
        int rowIndex = 8%(matrix[0].length) - 1;

        System.out.println("test = " + matrix[rowIndex][colIndex]);
    }
}
