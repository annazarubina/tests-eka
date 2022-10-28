package org.eka.tests.other.mergesort;

class Solution {
    public int[] sort(int[] nums) {
        mergeSort(nums, nums.length);
        return nums;
    }

    private static void mergeSort(int[] arr, int size) {
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < size; i++) {
            rightArr[i - mid] = arr[i];
        }
        mergeSort(leftArr, mid);
        mergeSort(rightArr, size - mid);

        merge(arr, leftArr, rightArr, mid, size - mid);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftSize, int rightSize) {
        int indexLeft = 0;
        int indexRight = 0;
        int index = 0;

        while (indexLeft < leftSize && indexRight < rightSize) {
            if (leftArr[indexLeft] <= rightArr[indexRight]) {
                arr[index] = leftArr[indexLeft];
                index = index + 1;
                indexLeft = indexLeft + 1;
            } else {
                arr[index] = rightArr[indexRight];
                index = index + 1;
                indexRight = indexRight + 1;
            }
        }
        while (indexLeft < leftSize) {
            arr[index] = leftArr[indexLeft];
            index = index + 1;
            indexLeft = indexLeft + 1;
        }
        while (indexRight < rightSize) {
            arr[index] = rightArr[indexRight];
            index = index + 1;
            indexRight = indexRight + 1;
        }
    }
}