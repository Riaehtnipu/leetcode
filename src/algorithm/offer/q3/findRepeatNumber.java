package algorithm.offer.q3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 因为0没有符号，无法取反来进行标记，因此+1再取反
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int origin = nums[i];
            if (origin < 0) {
                origin = -origin - 1;
            }
            if (nums[origin] < 0) {
                return origin;
            }
            nums[origin] = -(nums[origin] + 1);
        }
        return res;
    }

    // public int findRepeatNumber(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return -1;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == i) {
    //             continue;
    //         }

    //         while (nums[i] != i) {
    //             if (nums[i] == nums[nums[i]]) {
    //                 return nums[i];
    //             };
    //             int tmp = nums[i];
    //             nums[i] = nums[tmp];
    //             nums[tmp] = tmp;
    //         }
    //     }
    //     return -1;
    // }

    // public int findRepeatNumber(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return -1;
    //     }

    //     Set<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!set.add(nums[i])) {
    //             return nums[i];
    //         }
    //     }
    //     return -1;
    // }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution();
        int repeatNumber = s.findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
