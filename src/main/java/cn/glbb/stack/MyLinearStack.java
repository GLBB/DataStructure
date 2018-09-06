package cn.glbb.stack;

import cn.glbb.util.MyUtil;

import java.util.ArrayList;

public class MyLinearStack<E> {
    private Object[] elems;
    // 数组最大容量
    private int capacity = 8;

    private int size = 0;

    public MyLinearStack(){
        elems = new Object[capacity];
    }

    public void push(E e){
        // 溢出问题待解决，超过整形范围
        if (size == elems.length){
            elems = MyUtil.expansion(elems);
        }
        elems[size++] = e;
    }

    public E pop(){
        if(size==0){
            throw new RuntimeException("栈为空");
        }
        E e = (E) elems[--size];
        return e;
    }

    public void display(){
        for (int i=0;i<size;i++){
            E e = (E) elems[i];
            System.out.println(e);
        }
    }
}
