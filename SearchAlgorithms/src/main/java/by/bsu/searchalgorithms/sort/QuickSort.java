package by.bsu.searchalgorithms.sort;

import by.bsu.searchalgorithms.util.SortUtil;

public class QuickSort {

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int q = findQ(arr, left, right);
            sort(arr, left, q);
            sort(arr, q + 1, right);
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

    public void quicksort(int[] arr) {
        if (arr == null) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }
}
