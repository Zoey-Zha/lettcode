package com.zoey.lettcode.sort;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // Hash Table to map all the words
        HashMap<String, Integer> map = new HashMap<>();

        // sort the top k words
//        PriorityQueue<String> heap = new PriorityQueue<>((str1,str2) ->
//                (map.get(str1) - map.get(str2)));

        // heap sort
        PriorityQueue<String> heap = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if(map.get(o1) == map.get(o2)) {
                            return o1.compareTo(o2) < 0?1:-1;
                        };
                        return map.get(o1) - map.get(o2);
                    }
                }
        );

        // result
        List<String> list = new ArrayList<>();

        // map
        for (String str : words) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }

        // heap sort
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (heap.size() < k) heap.add(entry.getKey());
            else {
                if (entry.getValue() > map.get(heap.peek())) {
                    heap.poll();
                    heap.add(entry.getKey());
                } else if (entry.getValue() == map.get(heap.peek())) {
                    if (entry.getKey().compareTo(heap.peek()) < 0) {
                        heap.poll();
                        heap.add(entry.getKey());
                    }
                }
            }
        }

        // list needs to be descending
        String[] res = new String[k];
        while (heap.size() > 0) {
            res[k-1] = heap.poll();
            k--;
        }

        for (String str : res) list.add(str);


        // result
        return list;
    }

    public static void main(String[] args) {
        TopKFrequentWords test = new TopKFrequentWords();
        String[] words = {"i","love","leetcode","i","love","coding","coding"};

         List<String> list = test.topKFrequent(words, 2);

        for (String str : list) {
            System.out.println(str);
        }

        String str1 = "Love";
        String str2 = "You";

        // System.out.println("比较结果 ： " + str1.compareTo(str2));

    }
}
