package by.bsu.searchalgorithms.search;

public class SequentialSearch {
    private int search(int[] arr, int x) {
        int finded = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                finded = i;
            }
        }
        return finded;
    }

    public int sequentialSearch(int[] arr, int x) {
        if (arr != null) {
            return search(arr, x);
        }
        return -1;
    }
}
