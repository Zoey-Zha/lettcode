package com.zoey.lettcode.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectSticks {

    // LinkedList(list)
    public int connectSticks(int[] sticks) {
        List<Integer> listOfSticks = new LinkedList<Integer>(),
                    listOfSum = new LinkedList<Integer>();

        Arrays.sort(sticks);
        for (int stick : sticks) {
            listOfSticks.add(stick);
        }
        int res = 0;
        while (listOfSticks.size() + listOfSum.size() > 1) {
            int min1 = getMin(listOfSticks,listOfSum);
            int min2 = getMin(listOfSticks,listOfSum);
            res += Integer.sum(min1, min2);
            listOfSum.add(Integer.sum(min1, min2));
        }

        return res;
    }

    public int getMin(List<Integer> list1, List<Integer> list2) {
        if (list1.isEmpty()) return list2.remove(0);
        if (list2.isEmpty()) return list1.remove(0);

        return list1.get(0) > list2.get(0) ? list2.remove(0):list1.remove(0);
    }


    // Heap and greedy, o(NlogN)
    public int connectSticks1(int[] sticks) {

        if (sticks.length == 1) return 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int stick : sticks) {
            heap.add(stick);
        }

        int res = 0;
        while(heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();

            res += first + second;
            heap.add(first+second);

        }

        return res;
    }
}
