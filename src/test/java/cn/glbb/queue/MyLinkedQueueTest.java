package cn.glbb.queue;

import cn.glbb.bean.Student;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedQueueTest {
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    MyLinkedQueue queue;
    @Before
    public void init(){
        student1 = new Student();
        student2 = new Student();
        student3 = new Student();
        student4 = new Student();
        student5 = new Student();
        queue = new MyLinkedQueue();

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

        queue.add(student1);
        queue.add(student2);
        queue.add(student3);
        queue.add(student4);
        queue.add(student5);
    }

    // 测试add()方法
    @Test
    public void test1(){
        queue.display();
    }

    // 测试poll方法
    @Test
    public void test2(){
        queue.display();
        System.out.println();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    // 测试peek()方法
    @Test
    public void test3(){
        queue.display();
        System.out.println();

        System.out.println(queue.peek());
        System.out.println();

        queue.display();

    }
}
