package cn.glbb.sort;

public class MergeSort {

    public static void sort(int[] arr){
        if (arr.length > 1) {
            int midle = arr.length/2;
            int[] leftSon = new int[midle];
            System.arraycopy(arr,0,leftSon,0,midle);

            int[] rightSon = new int[arr.length-midle];
            System.arraycopy(arr,midle,rightSon,0,rightSon.length);

            sort(leftSon);
            sort(rightSon);
            merge(leftSon,rightSon,arr);
        }
    }

    private static void merge(int[] arr1, int[] arr2,int[] result){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        while (current1<arr1.length&&current2<arr2.length) {
            if (arr1[current1]<arr2[current2]) {
                result[current3] = arr1[current1];
                current1++;
            }else {
                result[current3] = arr2[current2];
                current2++;
            }
            current3++;
        }
        while (current1<arr1.length){
            result[current3++] = arr1[current1++];
        }
        while (current2<arr2.length){
            result[current3++] = arr2[current2++];
        }
    }
}
