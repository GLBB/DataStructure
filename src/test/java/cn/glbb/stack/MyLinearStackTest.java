package cn.glbb.stack;

import cn.glbb.bean.Student;
import cn.glbb.table.MyLinkedTable;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class MyLinearStackTest {
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    MyLinearStack stack;
    @Before
    public void init(){
        student1 = new Student();
        student2 = new Student();
        student3 = new Student();
        student4 = new Student();
        student5 = new Student();
        stack = new MyLinearStack();

        student1.setId(1L);
        student1.setName("pony");

        student2.setId(2L);
        student2.setName("jackma");

        student3.setId(3L);
        student3.setName("glbb");

        student4.setId(4L);
        student4.setName("nbq");

        student5.setId(5L);
        student5.setName("ez");

        stack.push(student1);
        stack.push(student2);
        stack.push(student3);
        stack.push(student4);
        stack.push(student5);
    }

    // 测试push方法
    @Test
    public void test1(){
        stack.display();
    }

    // 测试pop方法
    @Test
    public void test2(){
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
