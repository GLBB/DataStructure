package cn.glbb.sort;

import java.util.HashMap;

public class QuickSort {

    public void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

    public void sort(int[] arr, int first, int last) {
        if (first < last) {
            int pivot = getPivot(arr, first, last);
            sort(arr,first,pivot-1);
            sort(arr,pivot+1,last);
        }
    }

    public int getPivot  (int[] arr, int first, int last){
        int i = first - 1;
        int pivot = arr[last];
        for (int j = first; j<last; j++){
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[last];
        arr[last] = temp;
        return i+1;
    }
}
