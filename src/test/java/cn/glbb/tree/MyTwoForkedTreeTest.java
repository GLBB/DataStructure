package cn.glbb.tree;

import cn.glbb.bean.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MyTwoForkedTreeTest {
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    Student student6;
    Student student7;
    Student student8;
    Student student9;
    Student student10;
    Student student11;
    TwoForkedTree<Student> tree;

    @Before
    public void init(){
        student1 = new Student();
        student2 = new Student();
        student3 = new Student();
        student4 = new Student();
        student5 = new Student();
        student6 = new Student();
        student7 = new Student();
        student8 = new Student();
        student9 = new Student();
        student10 = new Student();
        student11 = new Student();


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

        student6.setId(6L);
        student6.setName("lm");
        student7.setId(7L);
        student7.setName("lsy");
        student8.setId(8L);
        student8.setName("qwt");
        student9.setId(9L);
        student9.setName("opp");
        student10.setId(10L);
        student10.setName("xvj");
        student11.setId(11L);
        student11.setName("ckvj");

        tree = new TwoForkedTree();

        tree.insert(student7);
        tree.insert(student4);
        tree.insert(student9);
        tree.insert(student3);
        tree.insert(student6);
        tree.insert(student8);
        tree.insert(student11);
        tree.insert(student1);
        tree.insert(student5);
        tree.insert(student10);
        tree.insert(student2);
    }

    // 测试 插入 和 遍历
    @Test
    public void test1(){
        tree.ergodic(tree.root);
    }

    // 求树的深度
    @Test
    public void test2(){
        int depth = tree.getDepth(tree.root);
        System.out.println(depth);
    }

    // 求树的叶子节点个数
    @Test
    public void test3(){
        int leafNumber = tree.getLeafNumber(tree.root);
        System.out.println(leafNumber);
    }

    // 测试先根遍历
    @Test
    public void test4(){
        tree.preErgodic(tree.root);
    }

    // 测试终序遍历
    @Test
    public void test5(){
        tree.middleErgodic(tree.root);
    }

    @Test
    public void test6(){

    }
}
