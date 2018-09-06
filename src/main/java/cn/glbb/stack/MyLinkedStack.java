package cn.glbb.stack;

import cn.glbb.table.MyLinkedTable;

public class MyLinkedStack<E> {

    public int size = 0;
    private Node<E> head = new Node<>();

    public MyLinkedStack(){
        head.next = null;
    }

    public class Node<E>{
        Node<E> next;
        E element;

        private Node(){

        }

        Node(E element){
            this.element = element;
        }
    }

    public void push(E e){
        Node<E> node = new Node<>(e);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public E pop(){
        if(head.next!=null) {
            E element = head.next.element;
            head.next = head.next.next;
            size--;
            return element;
        }else {
            throw new RuntimeException("链栈为空，不能删除");
        }
    }

    // 修改栈顶对象
    public void update(E e){
        Node<E> node = new Node<>(e);
        node.next = head.next;
        head.next = node;
    }

    public void display(){
        Node<E> middleNode;
        middleNode = head;
        middleNode = head.next;
        while (middleNode!=null){
            System.out.println(middleNode.element);
            middleNode = middleNode.next;
        }
    }

}
