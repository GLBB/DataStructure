package cn.glbb.sort;

import org.junit.Test;

import java.util.Arrays;

public class SimpleSelectSortTest {
    @Test
    public void test1(){
        SimpleSelectSort sort = new SimpleSelectSort();
        int[] arr = {2,3,2,5,6,1,-2,3,14,12};
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
