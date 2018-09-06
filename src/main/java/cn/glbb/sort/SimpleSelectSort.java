package cn.glbb.sort;

public class SimpleSelectSort {
    public void sort(int[] arr){
        for (int i=0; i<arr.length-1; i++) {

            Integer minValue = arr[i+1];
            int minValueIndex = i + 1;
            for (int j=i+1; j<arr.length; j++) {
                if (minValue > arr[j]) {
                    minValueIndex = j;
                    minValue = arr[j];
                }
            }

            if (minValue < arr[i]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[minValueIndex];
                arr[minValueIndex] = temp;
            }
        }
    }
}
