package com.zoey.lettcode.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int window = 0;
    Queue<Integer> queue = new LinkedList<>();

    public MovingAverage(int size) {
        window = size;

    }

    public double next(int val) {
        queue.add(val);
        if (queue.size() > 3) {
            queue.poll();
        }
        double res = 0;
        // 注意这里迭代器加上数据类型
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            res += iterator.next();
        }
        res = Math.round(res/queue.size() * 10000.0) / 10000.0;

        return res;
    }

    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(3);
        System.out.println("val = 1, " + average.next(1));
        System.out.println("val = 10, " + average.next(10));
        System.out.println("val = 3, " + average.next(3));
        System.out.println("val = 5, " + average.next(5));
        // System.out.println("val = 7, " + average.next(7));

    }
}
