package cn.glbb.table;

import cn.glbb.bean.Student;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedTableTest {
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    MyLinkedTable<Student> linkedTable;
    @Before
    public void init(){
        student1 = new Student();
        student2 = new Student();
        student3 = new Student();
        student4 = new Student();
        student5 = new Student();
        linkedTable = new MyLinkedTable<>();

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

        linkedTable.addFirst(student1);
        linkedTable.addFirst(student2);
        linkedTable.addFirst(student3);
        linkedTable.addFirst(student4);
        linkedTable.addFirst(student5);
    }

    // 增加一个元素
    // 测试方法addFirst()
    @Test
    public void test1(){
        linkedTable.display();
    }

    // 增加一个元素
    // 测试add(int position,E e)方法
    @Test
    public void test2(){
        linkedTable.display();

        Student student = new Student();
        student.setName("zbq");
        student.setId(4L);
        linkedTable.add(student,1);

        System.out.println();
        linkedTable.display();
    }

    // 删除第一个节点
    // deleteFirst()
    @Test
    public void test3(){
        linkedTable.display();
        System.out.println();

        linkedTable.deleteFirst();
        linkedTable.display();
    }

    // 根据位置删除节点
    // delete(int position)
    @Test
    public void test4(){
        linkedTable.display();
        System.out.println();
        linkedTable.delete(6);
        linkedTable.display();
    }

    // 根据位置查询元素
    @Test
    public void test5(){
        linkedTable.display();
        System.out.println();

        Student student = linkedTable.query(6);
        System.out.println(student);
    }

    // 根据位置修改元素
    @Test
    public void test6(){
        linkedTable.display();
        System.out.println();

        Student student = linkedTable.query(3);
        student.setName("nix");
        linkedTable.update(student,3);
        linkedTable.display();
    }
}
