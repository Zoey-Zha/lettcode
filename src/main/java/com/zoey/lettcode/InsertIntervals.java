package com.zoey.lettcode;

import java.util.LinkedList;

public class InsertIntervals {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            LinkedList<int[]> merged = new LinkedList<>();
            //merged.getLast();
            if (intervals.length == 0) merged.add(newInterval);

            for (int[] interval: intervals){
                // if the list of merged intervals is empty or
                // if the current interval does not overlap with the previous, appedn it
                if (merged.isEmpty()) {
                    if (newInterval[1] < interval[0]) {
                        merged.add(newInterval);
                        merged.add(interval);
                    }
                    else if (newInterval[0] > interval[1]){
                        merged.add(interval); // 数据长度为1时，
                    }
                    else {
                        int first = Math.min(interval[0],newInterval[0]);
                        int second = Math.max(interval[0],newInterval[0]);
                        int[] temp = {first, second};
                        merged.add(temp);
                    }
                }
                else {
                    if (newInterval[0] > merged.getLast()[1] && newInterval[1] < interval[0]) {
                        merged.add(newInterval);
                        merged.add(interval);
                    }
                    else if ((merged.getLast()[1] < interval[0] && interval[1] < newInterval[0])) {
                        merged.add(interval);
                    }
                    else if (merged.getLast()[1] >= interval[0]) {
                        merged.getLast()[1] = Math.max(interval[1],merged.getLast()[1]);
                        if (merged.getLast()[1] >= newInterval[0]) {
                            merged.getLast()[1] = Math.max(newInterval[1],merged.getLast()[1]);
                        }
                    }
                    else if (merged.getLast()[1] >= newInterval[0]) {
                        merged.getLast()[1] = Math.max(newInterval[1],merged.getLast()[1]);
                        if (merged.getLast()[1] >= interval[0]) {
                            merged.getLast()[1] = Math.max(interval[1],merged.getLast()[1]);
                        }else {
                            merged.add(interval);
                        }
                    }
                    else {
                        int first = Math.min(interval[0],newInterval[0]);
                        int second = Math.max(interval[0],newInterval[0]);
                        int[] temp = {first, second};
                        merged.add(temp);
                    }
                }
            }

            return merged.toArray(new int[merged.size()][]);
        }
}

