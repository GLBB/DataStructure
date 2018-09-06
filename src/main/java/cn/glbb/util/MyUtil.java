package cn.glbb.util;

import java.util.ArrayList;

public class MyUtil {

    public boolean isOverflow(){
        return false;
    }

    // 扩容
    public static Object[] expansion(Object[] elems){
        int capacity = elems.length;
        capacity = capacity << 1;
        Object[] swap = new Object[capacity];
        for(int i=0; i<elems.length; i++){
            swap[i] = elems[i];
        }
        return swap;
    }

}
