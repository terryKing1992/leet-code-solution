package com.terrylmay.leetcode.solution.easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-50, -49, -48, -47, -47, -45, -45, -43, -43, -43, -42, -42, -41, -41, -40, -40, -40, -38, -38, -38, -37, -36, -35, -35, -34, -32, -32, -31, -29, -29, -28, -28, -28, -27, -26, -25, -25, -25, -25, -23, -23, -21, -21, -20, -20, -20, -19, -19, -18, -18, -17, -17, -15, -15, -15, -15, -15, -14, -11, -11, -11, -9, -8, -8, -7, -7, -5, -5, -4, -4, -3, -2, -1, 0, 0, 0, 2, 3, 3, 4, 5, 7, 7, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 12, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 16, 16, 17, 18, 18, 19, 19, 20, 20, 21, 22, 23, 23, 23, 24, 25, 25, 25, 26, 26, 27, 27, 27, 28, 28, 28, 29, 30, 30, 30, 31, 31, 32, 32, 34, 34, 35, 36, 36, 37, 37, 39, 39, 39, 40, 40, 41, 42, 45, 45, 47, 47, 47, 47, 48, 48, 50, 50};
        System.out.println(removeDuplicates(nums));
        for (int item : nums) {
            System.out.print(item);
        }
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int arrayFinalSize = nums.length;
        int maxValue = nums[arrayFinalSize - 1];
        int leftIndex = 0;
        int nextIndex = 1;

        for (; nextIndex < nums.length; ) {
            int leftValue = nums[leftIndex];
            int nextValue = nums[nextIndex];

            if (leftValue == maxValue) {
                return nextIndex;
            }

            if (leftValue == nextValue) {
                int tempIndex = nextIndex;
                arrayFinalSize--;
                for (; tempIndex < nums.length - 1; tempIndex++) {
                    int tmp = nums[tempIndex];
                    nums[tempIndex] = nums[tempIndex + 1];
                    nums[tempIndex + 1] = tmp;
                }
            } else {
                if (leftValue > nextValue) {
                    break;
                }
                leftIndex++;
                nextIndex++;
            }
        }

        return arrayFinalSize;
    }

    /**
     * 同样是想使用双指针来做, 但是却因为巧用变量, 使得代码写的非常臃肿
     * @param nums
     * @return
     */
    public int optimizeRemoveDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
