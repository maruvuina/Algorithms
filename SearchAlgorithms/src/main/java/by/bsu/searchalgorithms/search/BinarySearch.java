package by.bsu.searchalgorithms.search;

public class BinarySearch {
    public int binarySearch(int[] arr, int left, int right, int x) {
        if(right >= left) {
            int middle = (left + right) / 2;
            if(arr[middle] == x) {
                return middle;
            }
            if(arr[middle] > x) {
                return binarySearch(arr, left, middle - 1, x);
            }
            else {
                return binarySearch(arr, middle + 1, right, x);
            }
        }
        return -1;
    }
}
