package leetcode;

import java.util.*;

/**
 * 三数的和最接近某个数
 * @author JingHe
 * @date 2021-07-19 14:54
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        System.out.println(threeSumClosest(arr, 3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 1;
            int r = nums.length - 1;
            while (k < r) {
                int current = nums[i] + nums[k] + nums[r];
                if (Math.abs(current - target) < Math.abs(min - target)) {
                    min = current;
                }
                if (current > target) {
                    r--;
                } else if (current < target) {
                    k++;
                } else {
                    return current;
                }

            }
        }
        return min;
    }

}

