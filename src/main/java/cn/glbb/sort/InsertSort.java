package cn.glbb.sort;

public class InsertSort {

    /**
     * 从小到大排序
     * @param arr
     */
    public void sort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int currentIndex = i;
            for (int j = i-1; j >= 0; j--){

                if (arr[currentIndex] < arr[j]) {
                    // swap
                    int temp = arr[currentIndex];
                    arr[currentIndex] = arr[j];
                    arr[j] = temp;
                    currentIndex--;
                }else break;
            }
        }
    }

}
