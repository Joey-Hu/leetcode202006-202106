package leetcode.sort;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/10/21 15:54
 * @desc:
 */
public class M324_WiggleSortII {

    public void wiggleSort(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length / 2 + 1;
        int idx = 0;

        while (right < nums.length && idx < nums.length) {
            res[idx++] = nums[left++];
            res[idx++] = nums[right++];
        }

        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1,1,6,4};
        new M324_WiggleSortII().wiggleSort(nums);
    }
}
