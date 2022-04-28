package com.zoey.lettcode.sort;

import java.util.*;

public class KthLargestElementOfArray {

    /**
     * 主要是针对partition做了改变，特别是pivot值的确定。
     * @param nums
     * @param left
     * @param right
     * @param pivotIndex
     * @return
     */
    // 再次优化pivot，使用median-of-three
    private int partitionNew(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int index = left;
        for(int i = left; i < right; ++i) {
            if(nums[i] > pivotValue) {
                swap(nums, index, i);
                ++index;
            }
        }
        swap(nums, right, index);
        return index;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //Use median-of-three strategy to choose pivot
    private int medianOf3(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        // 首先比较left AND right, 确定是左边的值较大，左边的值较小
        if(nums[right] > nums[left])
            swap(nums, left, right);
        // 再次比较right 和 mid的值，使得mid这个值处于中间值
        if(nums[right] > nums[mid])
            swap(nums, right, mid);
        // 同理对于left也一样
        if(nums[mid] > nums[left])
            swap(nums,left, mid);
        return mid;
    }

    // update medianOf3
    private int medianOf(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        // 三个值比较大小
        if (nums[mid] < nums[right]) swap(nums, mid, right);
        if (nums[right] > nums[left]) swap(nums, right, left);


        // 首先比较left AND right, 确定是左边的值较大，左边的值较小
        int large = Math.max(Math.max(nums[left],nums[right]),nums[mid]);
        return mid;
    }

    public int quickSelect1(int[] nums, int low, int high, int k) {
        // 每次都要重新3一下，保证pivot的值不是极大值，也不是极小值
        int pivotIndex = medianOf3(nums, low, high);
        pivotIndex = partitionNew(nums,low, high, pivotIndex);

        if (pivotIndex == k-1)
            return nums[pivotIndex];
        else if (pivotIndex < k-1)
            return quickSelect1(nums, pivotIndex+1, high, k);
        else
            return quickSelect1(nums, low, pivotIndex-1,k);
    }

    // partition 优化下变量int highsIndex = low; instead of (low-1)
    public static int partition_new(int[] nums, int low, int high) {
        int highsIndex = low;
        int pivot = nums[high];

        for (int i = low; i < high; i++) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[highsIndex];
                nums[highsIndex++] = temp;
            }
        }

        nums[high] = nums[highsIndex];
        nums[highsIndex] = pivot;

        return highsIndex;
    }

    //partition, 这个比较好理解，但是 +1 操作太多
    public static int partition(int[] nums, int low, int high) {
        int highsIndex = low - 1;
        int pivot = nums[high];

        for (int i = low; i < high; i++) {
            if (nums[i] >= pivot) {
                highsIndex++;
                // swap(nums[i],nums[highsIndex]);
                int temp = nums[i];
                nums[i] = nums[highsIndex];
                nums[highsIndex] = temp;
            }
        }
        // to do: 为什么swap函数不交换呢？需要带上数据
        // swap(nums[high],nums[highsIndex+1]);
        // System.out.println("middle value " + (highsIndex+1));
        int temp = pivot;
        nums[high] = nums[highsIndex+1];
        nums[highsIndex+1] = temp;

        // System.out.println("nums in after partition " + Arrays.toString(nums));

        return highsIndex + 1;
    }

    @Deprecated
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // quick select
    public static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = partition_new(nums, low, high);
        if (pivot == k-1) return nums[pivot]; //这个地方是返回element not index
        else if(pivot > k-1) {
            return quickSelect(nums,low, pivot-1, k);
        } else {
            return quickSelect(nums,pivot+1, high, k);
        }
    }

    // quick sort
    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);

            quickSort(nums, mid+1, high);
            quickSort(nums, low, mid - 1);

        }
    }

    public int findKthLargest(int[] nums, int k) {
        // return quickSelect(nums, 0, nums.length-1, k);
        return quickSelect1(nums, 0, nums.length-1, k);

        // quickSort(nums, 0, nums.length -1);
        // System.out.println("nums = " + Arrays.toString(nums));
        // return nums[k-1];

    }


    // Head,比bubble sort快一些
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }

     //Array.sort built in function of Array
     public int findKthLargest3(int[] nums, int k) {
         Arrays.sort(nums);
         int res = nums[nums.length - k];
         return res;
     }

    // Bubble sort
    public static int findKthLargest1(int[] nums, int k) {
        for (int i = 1; i <= k; i ++) {
            for (int j = 0; j < nums.length - i; j ++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        int res = nums[nums.length - k];
        return res;
    }

    public static void main(String[] args) {
        int[] test = {3,2,1,5,6,4};
        int[] nums = {3,2,3,1,2,4,5,5,6};
//        Arrays.sort(nums);
//        System.out.println("sorted : " + Arrays.toString(nums));
//        System.out.println("the kth largest" + nums[nums.length-4]);
        //System.out.println(findKthLargest(test,2));
        // System.out.println(findKthLargest1(nums,7));
        System.out.println(new KthLargestElementOfArray().findKthLargest(nums,3));
        System.out.println("sorted : " + Arrays.toString(nums));
//        System.out.println("Before swap" + Arrays.toString(nums));
//
//        swap(nums[0], nums[1]); // 交换失败
//        System.out.println("After swap" + Arrays.toString(nums));

//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i<nums.length; i ++) {
//            set.add(nums[i]);
//        }
//
//        Iterator<Integer> iterator = set.iterator();
//
//        while(iterator.hasNext()) {
//            int a = iterator.next();
//            System.out.println(a);
//        }


    }
}

