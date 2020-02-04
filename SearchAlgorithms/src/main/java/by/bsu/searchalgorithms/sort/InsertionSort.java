package by.bsu.searchalgorithms.sort;

public class InsertionSort {
    public void insertionSort(int []arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j]  > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }
}
