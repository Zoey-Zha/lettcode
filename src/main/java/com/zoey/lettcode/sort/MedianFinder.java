package com.zoey.lettcode.sort;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {

    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        quickSort(list, 0, list.size()-1);
        System.out.println("Sort result = " + list.toString());
        int size = list.size();
        double res;
        if (size%2 == 0) {
            res = (double)(list.get(size/2) + list.get((size-1)/2))/2;
        }else {
            res = list.get(size/2);
        }
        return res;
        // return size%2 == 0? (list.get(size/2) + list.get(size/2-1))/2:list.get(size/2);
    }

    public void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            System.out.println("pivot index = " + pivot);
            System.out.println("During partition = " + list.toString());
            quickSort(list, low, pivot-1);
            quickSort(list,pivot+1, high);
        }
    }

    public int partition(List<Integer> list, int low, int high) {
        int lowsIndex = low-1;
        int pivot = list.get(high);
        for (int i = low; i < high; i++) {
            if (list.get(i) < pivot) {
                lowsIndex ++;
                int temp = list.get(i);
                list.set(i,list.get(lowsIndex));
                list.set(lowsIndex,temp);
            }
        }
        int temp = list.get(lowsIndex+1);
        list.set(lowsIndex+1,pivot);
        list.set(high,temp);

        return lowsIndex+1;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        medianFinder.addNum(10);
        // System.out.println(medianFinder.findMedian());

        medianFinder.addNum(2);
        medianFinder.addNum(6);
//        medianFinder.addNum(5);
//        medianFinder.addNum(6);
//        medianFinder.addNum(7);
//        medianFinder.addNum(8);
//        medianFinder.addNum(9);
//        medianFinder.addNum(10);

        System.out.println(medianFinder.findMedian());

    }
}
