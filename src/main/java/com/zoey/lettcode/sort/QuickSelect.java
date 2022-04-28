package com.zoey.lettcode.sort;

public class QuickSelect {
    // 跟QuckSort类似，主要是解决Kth/K 问题，所以一部分recursion就不需要了

    public int partition(int[] nums, int low, int high) {
        int lowsIndex = low - 1;
        int pivot = nums[high];

        for (int i = low; i < high; i++) {
            // ascending, 所以把小的都放到pivot的前面（可以假设pivot已经在中间？）
            if (nums[i] < pivot) {
                lowsIndex++;
                int temp = nums[i];
                nums[i] = nums[lowsIndex];
                nums[lowsIndex] = temp;
            }
        }
        int temp = nums[high];
        nums[high] = nums[lowsIndex+1];
        nums[lowsIndex+1] = temp;

        return lowsIndex+1;
    }

    // k smallest,ascending order
    public int quickSelect(int[] nums, int low, int high, int k) {
        // if(low<high)可以去掉，因为k肯定会先到来
        // if (low < high) {
            int pivot = partition(nums, low, high);
            if (pivot > (k-1)) {
                return quickSelect(nums, low, pivot - 1, k);
            } else if (pivot < (k-1)) {
                return quickSelect(nums, pivot + 1, high, k);
            } else {
                return nums[k-1];
            }
       // }
        // 这个返回对吗？也就是不会出现low > high的情况
        // return nums[low];
    }

    public int kthSmallest(int[] arr, int low, int high, int k) {
        // find the partition
        int partition = partition(arr, low, high);

        // if partition value is equal to the kth position,
        // return value at k.
        if (partition == k - 1)
            return arr[partition];

            // if partition value is less than kth position,
            // search right side of the array.
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);

            // if partition value is more than kth position,
            // search left side of the array.
        else
            return kthSmallest(arr, low, partition - 1, k);
    }

    public static void main(String[] args) {
        QuickSelect sort = new QuickSelect();
        int[] nums = {3,2,4,5,7,8};

        System.out.println("Res = " + sort.quickSelect(nums,0,nums.length-1,2));
    }
}
