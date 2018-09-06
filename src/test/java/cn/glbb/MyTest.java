package cn.glbb;

import org.junit.Test;

import java.util.ArrayList;

public class MyTest {

    @Test
    public void test1(){
        Integer[] objects = new Integer[3];
        objects[0] = 0;
        objects[1] = 1;
        objects[2] = 2;
        update(objects);

        for(int i=0;i<objects.length;i++){
            System.out.println(objects[i]);
        }
    }

    public void update(Object[] objs){
        objs[0] = 1;
    }
}
