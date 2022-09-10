package by.bsu.searchalgorithms.sort;

public class MergeSort {

    private void fillArrayPart(int[] arr, int[] fillingArr, int tempArraySize,
                                  int index, int indexOfMergedSubarr) {
        while (index < tempArraySize) {
            arr[indexOfMergedSubarr] = fillingArr[index];
            index++;
            indexOfMergedSubarr++;
        }
    }

    private void merge(int []arr, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        int []leftArr = new int[leftSize];
        int []rightArr = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = arr[middle + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        fillArrayPart(arr, leftArr, leftSize, i, k);
        fillArrayPart(arr, rightArr, rightSize, j, k);
    }

    private void sort(int[] arr, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public void mergeSort(int[] arr) {
        if (arr == null) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }
}
