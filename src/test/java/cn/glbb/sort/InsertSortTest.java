package cn.glbb.sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertSortTest {

    @Test
    public void test1(){
        InsertSort insertSort = new InsertSort();
        int[] arr = {2,9,5,4,8,1,6};
        insertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
