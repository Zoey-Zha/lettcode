package com.zoey.lettcode.sort;

import java.util.*;

public class TopKFrequentE {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // 这里第一次写错了
        List<Integer>[] list = new List[nums.length+1];
        // Initial list，这里也写错了，不知道为啥0不用initial, 也不报错
        for (int i = 1; i <= nums.length; i++) list[i] = new ArrayList<>();

        // bucket
        for (int key : map.keySet()) {
            list[map.get(key)].add(key);
        }

        // 格式化结果
        int[] res = new int[k];
        int index = 0;

        for (int j = list.length -1; j >=0; j--) {
            if(list[j] != null) {
                for (int n : list[j]) {
                    if (index < k) res[index++] = n;
                    if (index == k) return res;
                }
            }
        }

        return res;
    }

    HashMap<Integer, Integer> hashTable = new HashMap<>();
/************************* hashtable and heap(max heap) **********************************/
    // hashtable and heap(max heap)
    public int[] topKFrequent3(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (hashTable.get(b)-hashTable.get(a)));

        // count frequent
        for (int num : nums) {
            hashTable.put(num, hashTable.getOrDefault(num, 0)+1);
        }

        // array to save all the different nums
        for (int key : hashTable.keySet()) {
            maxHeap.add(key);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (maxHeap.size() > 0) {
            res[index++] = maxHeap.poll();
        }

        return res;
    }





// **************************  hashtable and quick select *************************/

    // hashtable and quick select
    private int[] topKFrequent2(int[] nums, int k) {

        // count frequent
        for (int num : nums) {
            hashTable.put(num, hashTable.getOrDefault(num, 0)+1);
        }
        int[] elements = new int[hashTable.size()];
        int index = 0;

        // array to save all the different nums
        for (int key : hashTable.keySet()) {
            elements[index++] = key;
        }
        // 对elements 排序
        return quickselect(elements,0, elements.length - 1, k);
    }

    public int[] quickselect(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);

        if (pivot == k-1) return Arrays.copyOfRange(nums,0,k-1);
        else if (pivot > k-1) return quickselect(nums,low,pivot -1,k);
        else {
            return quickselect(nums,pivot+1,high,k);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = hashTable.get(nums[high]);
        int highIndex = low;
        for (int i = low; i < high; i++) {
            if (hashTable.get(nums[i]) > pivot) {
                int temp = nums[i];
                nums[i] = nums[highIndex];
                nums[highIndex] = temp;
                highIndex++;
            }
        }
        int right = nums[high];
        nums[high] = nums[highIndex];
        nums[highIndex] = right;

        return highIndex;
    }




    private static int[] topKFrequent1(int[] nums, int k) {
        int[] res = new int[k];

        PriorityQueue<int[]> heap = helper(nums,k);
        int n = heap.size();
        for (int i = 0; i < n; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    public static PriorityQueue<int[]> helper(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<int[]> heap1= new PriorityQueue<>((a,b)->(a[1]-b[1]));

        for (int key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));

            int[] a = {key,map.get(key)};

            if (heap1.size() < k) heap1.add(a);
            else {
                int newValue = map.get(key);
                // heap1.peek()[0];
                int peekValue = map.get(heap1.peek()[0]);
                if (newValue > peekValue) {
                    int[] poll = heap1.poll();
                    System.out.println("poll = " + Arrays.toString(poll));
                    heap1.add(a);
                }
            }
        }
        return heap1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3};
        int[] res = new TopKFrequentE().topKFrequent1(nums,2);
        System.out.println(Arrays.toString(res));

        // test heap || map
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        map1.put(1,5);
        map1.put(2,1);
        map1.put(3,10);
        map1.put(4,6);

        map2.put(1,3);
        map2.put(2,4);

        // merge two maps with duplicates and add the values
        for (int key : map2.keySet()) {
            map1.replace(key,map1.getOrDefault(key,0) + map2.get(key));
        }
        // map1.forEach();

//        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }
        // 升序排列
        // PriorityQueue<>
        // PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->(a-b));
        PriorityQueue<int[]> heap1= new PriorityQueue<>((a,b)->(a[1]-b[1]));
        int limit = 2;
        for (int key : map1.keySet()) {
            // System.out.println("key = " + key + ", value = " + map1.get(key));

            int[] a = {key,map1.get(key)};

            if (heap1.size() < limit) heap1.add(a);
            else {
                int newValue = map1.get(key);
                // heap1.peek()[0];
                int peekValue = map1.get(heap1.peek()[0]);
                if (newValue > peekValue) {
                    int[] poll = heap1.poll();
                    // System.out.println("poll = " + Arrays.toString(poll));
                    heap1.add(a);
                }
            }
        }

        // System.out.println("heap1.size = " + heap1.size());
        int n = heap1.size();
        for (int i = 0; i < n; i++) {
            // System.out.println("TopK keys = " + heap1.poll()[0]);
        }

    }
}
