package cn.glbb.queue;

import java.util.Queue;

public class MyLinkedQueue<E> {
    public int size = 0;
    Node<E> head = new Node<>();
    Node<E> tail = head;

    class Node<E>{
        Node<E> next;
        E element;

        Node(){}

        Node(E element){
            this.element = element;
        }
    }

    MyLinkedQueue(){
        head.next = null;
    }

    // 给栈尾加一个元素
    // 尾插法
    public void add(E e){
        Node<E> targetNode = new Node<>(e);
        tail.next = targetNode;
        targetNode.next = null;
        tail = targetNode;
    }

    // 出栈
    // 抛出第一个
    public E poll(){
        Node<E> middleNode = head.next;
        if (middleNode==null){
            throw new RuntimeException("空队列");
        }
        E e = middleNode.element;
        head.next = head.next.next;
        return e;
    }

    // 查询队列第一个
    public E peek(){
        Node<E> node = head.next;
        if (node==null){
            throw new RuntimeException("空队列");
        }else {
            return node.element;
        }
    }

    public void display(){
        Node node = head.next;
        while (node!=null){
            System.out.println(node.element);
            node = node.next;
        }
    }
}
