package org.eka.tests.other.bublesort;

class Solution {
    public int[] sort(int[] nums) {
        int len = nums.length;
        if(len <= 1) {
            return nums;
        }
        int temp;
        boolean swapped;
        for (int i = 0; i < len - 1; i++) {
            swapped  = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return nums;
    }
}