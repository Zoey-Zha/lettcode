package com.zoey.lettcode.array;

import java.util.*;

public class MeetingRooms2 {
    // 我的方法
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        ArrayList<int[]> meetingRooms = new ArrayList<>();

        for (int[] interval: intervals){
            boolean addedFlag = false;
            if (meetingRooms.isEmpty()){
                meetingRooms.add(interval);
            }
            else {
                // 跟现有的已经处理的会议比较
                for (int[] meeting: meetingRooms){
                    if (interval[0] >= meeting[1]) {
                        // 因为不会出现加塞的情况，所以这里直接合并了
                        // 另外具体合并到哪个会议室，也是没有影响的（排除了会议紧凑型合并法）
                        meeting[1] = interval[1];
                        addedFlag = true;
                        break;
                    }
                }
                if (!addedFlag) meetingRooms.add(interval);
            }
        }
        return meetingRooms.size();
    }
}

// lettcode官方方法1
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
//        Arrays.sort(
//                intervals,
//                new Comparator<int[]>() {
//                    public int compare(final int[] a, final int[] b) {
//                        return a[0] - b[0];
//                    }
//                });
        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
