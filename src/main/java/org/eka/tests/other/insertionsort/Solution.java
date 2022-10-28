package org.eka.tests.other.insertionsort;

class Solution {
    public int[] sort(int[] nums) {
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            int key = nums[j];
            int i = j-1;
            while ( (i > -1) && ( nums[i] > key ) ) {
                nums[i+1] = nums[i];
                i--;
            }
            nums[i+1] = key;
        }
        return nums;
    }
}