package cn.glbb.tree;

import cn.glbb.bean.Student;
import cn.glbb.stack.MyLinkedStack;

public class TwoForkedTree<E extends Student> {

    Node root;
    int size = 0;
    private class Node{
        E element;
        Node leftChild;
        Node rightChild;

        Node(){
            element = null;
            leftChild = null;
            rightChild = null;
        }

        Node(E element){
            this.element = element;
            leftChild = null;
            rightChild = null;
        }
    }

    public void insert(E e){
        Node targetNode = new Node(e);

        // 判断root是否为空 如果为空 将该节点放在root位置
        // rott不为空 比较id，
        // 若传进来的id比当前id大，right
        // 若传进来的id比当前id小，left

        if(root==null){
            root = targetNode;
            return;
        }else {
            Node currentNode = root;
            Node parentNode = null;
            while (currentNode!=null){
                parentNode = currentNode;
                if(targetNode.element.getId()<currentNode.element.getId()){
                    currentNode = currentNode.leftChild;
                }else {
                    currentNode = currentNode.rightChild;
                }
            }
            if(targetNode.element.getId()<parentNode.element.getId()){
                parentNode.leftChild = targetNode;
            }else {
                parentNode.rightChild = targetNode;
            }
        }
    }

    // 得到树的深度
    public int getDepth(Node root){
        if(root==null){
            return 0;
        }else {
            int m = getDepth(root.leftChild);
            int n = getDepth(root.rightChild);
            return (m>n?m:n)+1;
        }
    }

    public int getLeafNumber(Node root){
        if(root==null){
            return 0;
        }else if(root.leftChild==null&&root.rightChild==null){
            return 1;
        }else {
            return getLeafNumber(root.leftChild)+getLeafNumber(root.rightChild);
        }
    }

    /**
     * 二叉树的遍历操作
     * 递归中序遍历
     */
    public void ergodic(Node node){
        if(node!=null){
            ergodic(node.leftChild);
            System.out.println(node.element);
            ergodic(node.rightChild);
        }
    }

    // 非递归先根遍历
    public void preErgodic(Node node){
        MyLinkedStack<Node> stack = new MyLinkedStack<>();

        do {
            while (node!=null){
                System.out.println(node.element);
                stack.push(node);
                node = node.leftChild;
            }
            if(stack.size!=0){
                node = stack.pop();
                node = node.rightChild;
            }
        }while (stack.size!=0||node!=null);
    }

    public void middleErgodic(Node node){
        MyLinkedStack<Node> stack = new MyLinkedStack<>();

        do {
            while (node!=null){
                stack.push(node);
                node = node.leftChild;
            }
            if(stack.size!=0){
                node = stack.pop();
                System.out.println(node.element);
                node = node.rightChild;
            }
        }while (stack.size!=0||node!=null);
    }

}
