package by.bsu.sortalgorithms.sort;

import by.bsu.sortalgorithms.util.SortUtil;

public class HybridSort {

    private HybridSort() {}

    private void insertionSort(int []arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int curr = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j]  > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }

    private int findQ(int[] arr, int left, int right) {
        int x = arr[(left + right)/2];
        int i = left - 1;
        int q = right + 1;
        while(true) {
            do {
                i++;
            } while(arr[i] < x);
            do {
                q--;
            } while(arr[q] > x);
            if (i < q) {
                SortUtil.swap(arr, i, q);
            }
            else {
                return q;
            }
        }
    }

    private void sort(int[] arr, int left, int right) {
        int boundaryNumberOfElements = 50;
        if (left - right < boundaryNumberOfElements) {
            insertionSort(arr, left, right);
        } else if (left < right) {
            int q = findQ(arr, left, right);
            sort(arr, left, q);
            sort(arr, q + 1, right);
        }
    }

    public void quickInsertionSort(int[] arr) {
        if (arr == null) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }
}
