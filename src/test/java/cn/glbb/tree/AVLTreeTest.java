package cn.glbb.tree;


import cn.glbb.tree.AVLTree;
import cn.glbb.tree.BST;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {

    BST<String> tree = null;
    AVLTree<String> avlTree = null;

    @Before
    public void init(){
        tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        avlTree = new AVLTree<>();
        avlTree.insert("George");
        avlTree.insert("Michael");
        avlTree.insert("Tom");
        avlTree.insert("Adam");
        avlTree.insert("Jones");
        avlTree.insert("Peter");
        avlTree.insert("Daniel");
        System.out.println();
    }

    // 测试平衡二叉树
    @Test
    public void test1(){
        avlTree.inorder();
    }

    // 测试updateHeight(AVLTreeNode<E> node)
    @Test
    public void test2(){
        System.out.println("搜索二叉树");
        tree.preorder();
        System.out.println();
        tree.inorder();
        System.out.println();
        tree.postorder();
        System.out.println();


        System.out.println("平衡二叉树");
        avlTree.preorder();
        System.out.println();
        avlTree.inorder();
        System.out.println();
        avlTree.postorder();
        System.out.println();
        System.out.println();


        avlTree.insert("Echo");
        avlTree.preorder();
        System.out.println();
        avlTree.inorder();
        System.out.println();
        avlTree.postorder();
    }

    public void printTree(BST tree){
        tree.preorder();
        System.out.println();
        tree.inorder();
        System.out.println();
        tree.postorder();
        System.out.println("\ntree size : " + tree.getSize());

    }

    @Test
    public void test3(){
        AVLTree<Integer> tree = new AVLTree<>(new Integer[]{25,20,5});
        printTree(tree);

        tree.insert(34);
        tree.insert(50);
        printTree(tree);

        tree.insert(30);
        printTree(tree);

        tree.insert(10);
        printTree(tree);

        System.out.println("----");
        tree.delete(34);
        tree.delete(30);
        tree.delete(50);
        printTree(tree);

        System.out.println();
        tree.delete(5);
        printTree(tree);
    }
}
