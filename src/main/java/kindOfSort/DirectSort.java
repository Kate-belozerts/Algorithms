package kindOfSort;

import java.util.Arrays;

public class DirectSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 2, 9, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int min = arr[0];
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                    int temp = min;
                    min = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
