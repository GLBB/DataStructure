package cn.glbb.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void test1(){
        int[] a = {1,2,3,4,5,6};
        int[] b = new int[3];
        System.arraycopy(a,0,b,0,2);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void test2(){
        int arr[] = {2,3,2,5,6,1,-2,3,14,12};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
