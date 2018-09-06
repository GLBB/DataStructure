package cn.glbb.table;

import org.junit.Test;

public class MyLinearTableTest {

    // 测试移位
    // 向左移一位相当于乘以2
    // true
    @Test
    public void test1(){
        int a = 8;
        a = a << 1;
        System.out.println(a);
    }

    // length属性是数组长度吗
    @Test
    public void test2(){
        int[] a = new int[5];
        a[1] = 1;
        a[0] = 3;
        System.out.println(a.length);
    }

    // 测试线性表insert()方法
    @Test
    public void test3(){
        MyLinearTable myLinearTable = new MyLinearTable();
        myLinearTable.insert(5);
        myLinearTable.insert(6);
        myLinearTable.insert(7);
        myLinearTable.insert(8);
        myLinearTable.insert(9);
        myLinearTable.insert(10);
        myLinearTable.insert(11);
        myLinearTable.insert(12);
        myLinearTable.insert(13);
        myLinearTable.insert(14);
        myLinearTable.output();
    }

    // 测试线性表指定位置insert()方法
    @Test
    public void test4(){
        MyLinearTable myLinearTable = new MyLinearTable();
        myLinearTable.insert(1);
        myLinearTable.insert(2);
        myLinearTable.insert(3);
        myLinearTable.insert(4,1);
        myLinearTable.output();
    }

    // 测试线性表find(int position)方法
    @Test
    public void test5(){
        MyLinearTable<Integer> myLinearTable = new MyLinearTable();
        myLinearTable.insert(1);
        myLinearTable.insert(2);
        myLinearTable.insert(3);
        myLinearTable.insert(4,1);
        int i = myLinearTable.find(4);
        System.out.println(i);
    }

    // 测试线性表的update(E e, int position)方法
    @Test
    public void test6(){
        MyLinearTable<Integer> myLinearTable = new MyLinearTable();
        myLinearTable.insert(1);
        myLinearTable.insert(2);
        myLinearTable.insert(3);
        myLinearTable.insert(4,1);
        myLinearTable.output();
        myLinearTable.update(0,1);
        myLinearTable.output();
    }

    // 测试线性表的删除方法
    @Test
    public void test7(){
        MyLinearTable<Integer> myLinearTable = new MyLinearTable();
        myLinearTable.insert(1);
        myLinearTable.insert(2);
        myLinearTable.insert(3);
        myLinearTable.insert(4,1);
        myLinearTable.delete(1);
        myLinearTable.output();
    }
}
