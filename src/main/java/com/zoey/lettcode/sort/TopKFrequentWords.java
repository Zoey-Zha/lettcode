package com.zoey.lettcode.sort;

import java.util.*;

public class TopKFrequentWords {
    // quick selet

    private HashMap<String, Integer> map = new HashMap<>();
    public List<String> topKFrequent(String[] words, int k) {


        // result
        List<String> list = new ArrayList<>();

        // map
        for (String str : words) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }

        String[] strings = new String[map.size()];
        int index = 0;

        for (String key : map.keySet()) {
            strings[index++] = key;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        String[] res = quickSelect(strings, 0, strings.length-1, k);
        System.out.println("after quicksort :" + Arrays.toString(strings));

        for (String s : res) {
            list.add(s);
        }

        return list;
    }

    public String[] quickSelect(String[] strings, int left, int right, int k) {
        int pivot = partition(strings, left, right);
        if (pivot < k - 1) {
           return quickSelect(strings,pivot+1, right, k);
        } else if(pivot > k - 1) {
           return quickSelect(strings, left, pivot-1, k);
        } else {
            return Arrays.copyOfRange(strings,0,pivot+1);
        }
    }

    public int partition(String[] strings, int left, int right) {

        String pivot = strings[right];
        int highIndex = left;
        for (int i = left; i < right; i++) {
            if(map.get(strings[i]) > map.get(pivot)) {
                String temp = strings[i];
                strings[i] = strings[highIndex];
                strings[highIndex++] = temp;
            } else if (map.get(strings[i]) == map.get(pivot) && strings[i].compareTo(pivot) < 0) {
                String temp = strings[i];
                strings[i] = strings[highIndex];
                strings[highIndex++] = temp;
            }
        }
        String temp = strings[right];
        strings[right] = strings[highIndex];
        strings[highIndex] = temp;

        return highIndex;
    }



    public List<String> topKFrequentHeap(String[] words, int k) {
        // Hash Table to map all the words
        HashMap<String, Integer> map = new HashMap<>();

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
                heap.add(entry.getKey());
                heap.poll();

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

        /*
        // result
        List<String> list = new ArrayList<String>();
        while(k > 0) {
            list.add(heap.poll());
            k--;
        }
       // reverse
       for(int left = 0, right = list.size() -1; left < right; left ++, right --) {
           String temp = list.get(left);
           list.set(left,list.get(right));
           list.set(right, temp);
       }
         */
    }

    public static void main(String[] args) {
        TopKFrequentWords test = new TopKFrequentWords();
        String[] words = {"i","love","leetcode","i","love","coding"};

        String[] testStr = {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};

//        Arrays.sort(testStr);
//        for (String str : testStr) System.out.println(str);
        // Arrays.stream(testStr).flatMap();
         List<String> list = test.topKFrequent(testStr, 6);

         /*
         ["nftk","qkjzgws","qrkgmliewc","nsfspyox","qengse","htpvnmozay",
         "fqizrrnmif","glarko","hdemkfr","pwqvwmlgri","qggx","zskaqzwo","ijy","zlfiwwb"]
          */

        System.out.println("********************************");
        for (String str : list) {
            System.out.println(str);
        }

        String str1 = "Love";
        String str2 = "You";

        // System.out.println("比较结果 ： " + str1.compareTo(str2));

    }
}
