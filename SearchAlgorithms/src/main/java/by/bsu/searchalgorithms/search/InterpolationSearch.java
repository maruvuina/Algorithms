package by.bsu.searchalgorithms.search;

public class InterpolationSearch {

    private int search(int[] arr, int x) {
        int finded = -1;
        int right = 0;
        int left = arr.length - 1;
        while (right <= left && x >= arr[right] && x <= arr[left]) {
            int s = right + (int)(((double)(left - right) / (arr[left] - arr[right])) *
                    (x - arr[right]));
            if(arr[s] == x) {
                finded = s;
            }
            if(arr[s] < x) {
                right = s + 1;
            } else {
                left = s - 1;
            }
        }
        return finded;
    }

    public int interpolationSearch(int []arr, int x) {
        if (arr != null) {
            return search(arr, x);
        }
        return -1;
    }
}
