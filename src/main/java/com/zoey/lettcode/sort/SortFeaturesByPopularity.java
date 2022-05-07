package com.zoey.lettcode.sort;

import java.util.*;

public class SortFeaturesByPopularity {

    // Array built in Sort
    public String[] sortFeatures(String[] features, String[] responses) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String feature : features) {
            map.put(feature, 0);
        }

        for (String response : responses) {
            HashSet<String> set = new HashSet<>();
            String[] strs = response.split(" ");
            // 去重
            for (String s1 : strs) {
                if (map.getOrDefault(s1,-1) >= 0)  set.add(s1);
            }

            set.forEach(ss -> map.put(ss,map.getOrDefault(ss,0)+1));

            set.clear();
        }

        Arrays.sort(features,(a, b) -> (map.get(b) - map.get(a)));
        return features;
    }

    public String[] sortFeaturesHeap(String[] features, String[] responses) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> featureSet = new HashMap<>();

        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)){
                    return featureSet.get(o1) - featureSet.get(o2);
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }
        }
        );

        // for (String feature : features) featureSet.add(feature);
        for (int i = 0; i < features.length; i++) {
            // featureSet.put(features[i],i);
            map.put(features[i], 0);
        }

        // 为了对每个response 去重
        HashSet<String> set = new HashSet<>();
        for (String str : responses) {
            String[] s = str.split(" ");

            // 去重
            for (String s1 : s) {
                if (map.getOrDefault(s1,-1) >= 0)  set.add(s1);
            }

            set.forEach(ss -> map.put(str,map.getOrDefault(ss,0)+1));
            // 更新map, 统计
//            for (String key : set) {
//                map.put(key,map.getOrDefault(key, 0) + 1);
//            }
            // 完成一个response分析，清空set
            set.clear();
        }
        // 把map结果更新到heap中排序
//        for (String key : map.keySet()) {
//            heap.add(key);
//        }

//
//        String[] res = new String[heap.size()];
//        int startIndex = 0;
//        while (heap.size() > 0) {
//            res[startIndex++] = heap.poll();
//        }

        Arrays.sort(features,(a, b)->(map.get(b)-map.get(a)));
        return features;
    }

    public static void main(String[] args) {
        SortFeaturesByPopularity test = new SortFeaturesByPopularity();
//        String[] features = {"cooler","lock","touch"};
//        String[] responses = {"i like cooler cooler","lock touch cool","locker like touch"};
        String[] features = {"a","aa","b","c"};
        String[] responses = {"a","a aa","a a a a a","b a"};
        String[] res = test.sortFeatures(features, responses);
        System.out.println("result : " + Arrays.toString(res));
    }
}
