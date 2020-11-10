package leetcode.heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/6 15:45
 * @desc: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class M215_KthLargestElementinanArray {

    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }

        // Take A[end] as the pivot,
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            // Put numbers < pivot to pivot's left
            if (nums[i] <= pivot) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        // Found kth largest number
        if (left == k) {
            return nums[left];
        }else if (left < k) {
            return quickSelect(nums, left + 1, end, k);
        }else {
            return quickSelect(nums, start, left-1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  =temp;
    }

        /**
         * quick sort
         * O(NlogN)
         * @param nums
         * @param k
         * @return
         */
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 2, 2};
        System.out.println(new M215_KthLargestElementinanArray().findKthLargest2(nums, 3));
    }
}
