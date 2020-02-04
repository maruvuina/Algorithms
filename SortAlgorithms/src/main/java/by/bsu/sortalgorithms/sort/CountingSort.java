package by.bsu.sortalgorithms.sort;

public class CountingSort {
    private int getMaxValue(int[] numbers){
        int maxValue = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    private int getMinValue(int[] numbers){
        int minValue = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < minValue){
                minValue = numbers[i];
            }
        }
        return minValue;
    }

    public void countingSort(int[] arr) {
        int max = getMaxValue(arr);
        int min = getMinValue(arr);
        int range = max - min + 1;
        int n = arr.length;
        int []count = new int[range];
        int []output = new int[n];
        for (int value : arr) {
            count[value - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}
