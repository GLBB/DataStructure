package cn.glbb.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void test1(){
        QuickSort quickSort = new QuickSort();
        int[] arr = {2,3,2,5,6,1,-2,3,14,12};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {2,8,7,1,3,5,6,4};
        quickSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
