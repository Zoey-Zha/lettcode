package com.zoey.lettcode;


import java.util.Arrays;

public class MeetingRooms1 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        if (intervals.length == 1) return true;
        for (int i = 0; i < intervals.length -1; i ++) {
            if (intervals[i][1] >= intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
