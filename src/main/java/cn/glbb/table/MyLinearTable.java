package cn.glbb.table;

import cn.glbb.util.MyUtil;

// 线性表
public class MyLinearTable<E> {
    private Object[] elems;
    // 数组最大容量
    private int capacity = 8;

    private int size = 0;

    public MyLinearTable(){
        elems = new Object[capacity];
    }

    // 向最后一个元素插入元素
    public void insert(E e){
        if (size == elems.length){
            elems = MyUtil.expansion(elems);
        }
        elems[size++] = e;
    }

    // 指定位置插入元素
    // 1<=position<=size
    public void insert(E e, int position){
        if(position<1||position>size+1){
            throw new RuntimeException("插入位置非法");
        }
        int insertIndex = position - 1;
        for (int i = size-1; i >= insertIndex ; i--) {
            elems[i+1] = elems[i];
        }
        elems[insertIndex] = e;
        size++;
    }

    // 删除元素
    // 1<=position<=size
    public void delete(int position){
        if(position<1||position>size){
            throw new RuntimeException("删除位置非法");
        }
        for(int i=position; i<size;i++){
            elems[i-1] = elems[i];
        }
        size--;
    }

    // 查找元素
    // 1<=position<=size
    public E find(int position){
        int index = position - 1;
        if(index<0||index>=size){
            throw new RuntimeException("查找位置非法");
        }
        return (E) elems[index];
    }

    // 修改元素
    // 1<=position<=size
    public void update(E e,int position){
        int index = position - 1;
        if(index<0||index>=size){
            throw new RuntimeException("修改位置非法");
        }
        elems[index] = e;
    }

    // 输出数组中所有元素
    public void output(){
        for(int i=0;i<size;i++){
            if(elems[0] instanceof Number){
                Number number = (Number) elems[i];
                System.out.println(number);
            }
        }
    }
}
