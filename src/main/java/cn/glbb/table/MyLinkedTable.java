package cn.glbb.table;

import java.util.LinkedList;

// 单向链表
public class MyLinkedTable<E> {
    public int size = 0;
    private Node<E> head = new Node<>();

    public MyLinkedTable(){
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

    /**
     * 在头部增加一个元素,头插法
     * @param e 传递元素进来
     */
    public void addFirst(E e){
        Node<E> node = new Node<>(e);
        node.next = head.next;
        head.next = node;
        size++;
    }

    /**
     * 将目标元素加入指定位置
     * @param element  目标元素
     * @param position 1<=position<=size+1
     */
    public void add(E element,int position){
        if (position<1||position>size+1){
            throw new RuntimeException("插入位置非法");
        }
        // 想要被插入的节点
        Node<E> nodeElement = new Node<>(element);
        int index = position - 1;
        Node<E> node = new Node<>();

        node = head;

        while (node!=null && index>0){
            index--;
            node = node.next;
        }

        nodeElement.next = node.next;
        node.next = nodeElement;
        size++;
    }

    /**
     * 删除第一个节点
     */
    public void deleteFirst(){
        if(head.next!=null) {
            head.next = head.next.next;
            size--;
        }else {
            throw new RuntimeException("链表为空，不能删除");
        }
    }

    /**
     * @param position 1<=position<=size，要删除元素的位置
     */
    public void delete(int position){
        if(!(1<=position&&position<=size)){
            throw new RuntimeException("删除元素的位置不合法");
        }
        int index = position - 1;
        Node<E> middleNode = new Node<>();
        middleNode = head;

        while (index>0&&middleNode!=null){
            middleNode = middleNode.next;
            index--;
        }

        middleNode.next = middleNode.next.next;
        size--;
    }

    /**
     * 查找方法
     * @param position 1<=position<=size，要查找元素的位置
     */
    public E query(int position){
        if(!(1<=position&&position<=size)){
            throw new RuntimeException("查找元素的位置不合法");
        }
        int index = position - 1;
        Node<E> middleNode = new Node<>();
        middleNode = head;
        while (index>=0&&middleNode!=null){
            index--;
            middleNode = middleNode.next;
        }
        return middleNode.element;
    }

    /**
     * 修改元素
     * @param e 目标元素
     * @param position 目标位置
     */
    public void update(E e,int position){
        if(!(1<=position&&position<=size)){
            throw new RuntimeException("修改元素的位置不合法");
        }
        int index = position - 1;
        Node<E> middleNode = new Node<>();
        middleNode = head;
        while (index>=0&&middleNode!=null){
            index--;
            middleNode = middleNode.next;
        }
        middleNode.element = e;
    }

    /**
     * 展示元素
     */
    public void display(){
        Node<E> node = new Node<>();
        node = head.next;
        while (node!=null){
            E e = node.element;
            System.out.println(e);
            node = node.next;
        }
    }

}
