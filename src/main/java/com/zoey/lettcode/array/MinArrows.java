package com.zoey.lettcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MinArrows {
    public int findMinArrowShots(int[][] points) {

        if (points.length ==0 ) return 0;

        // Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int res = Integer.compare(o1[0],o2[0]);
                if (res == 0) {
                    res = Integer.compare(o1[1],o2[1]);
                }
                return res;
            }
        });

        // 打印多维数组
        System.out.println(Arrays.deepToString(points));

        LinkedList<int[]> arrows = new LinkedList<>();


        arrows.add(points[0]);

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrows.getLast()[1]) {
                arrows.getLast()[0] = points[i][0];
                arrows.getLast()[1] = Math.min(arrows.getLast()[1],points[i][1]);
            }
            else arrows.add(points[i]);
        }

        return arrows.size();
    }
}
