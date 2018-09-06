package cn.glbb.sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void test1(){
        int[] arr = {-44,-5,-3,3,3,1,-4,0,1,2,4,5,53,16,15};
        HeapSort heapSort = new HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
