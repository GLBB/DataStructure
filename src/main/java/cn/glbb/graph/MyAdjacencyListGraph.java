package cn.glbb.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 无权图 有向图
public class MyAdjacencyListGraph<E> {
    private List<Vertice<E>> list = new ArrayList<>();
    public static class Vertice<E>{
        E e;
        Vertice next;

        Vertice(E e){
            this.e = e;
        }
    }

    public void addVertice(E e){
        Vertice<E> vertice = new Vertice<>(e);
        list.add(vertice);
    }

    public void addEdges(E target, E[] vertices){
        Vertice vertice = null;
        for (int i=0; i<list.size(); i++){
            vertice = list.get(i);
            if(vertice.e.equals(target)){
                break;
            }
        }
        if(vertice!=null){
            // 插入邻居节点
            for (int i=0; i<vertices.length; i++){
                Vertice<E> insert = new Vertice<>(vertices[i]);

                insert.next = vertice.next;
                vertice.next = insert;
            }
        }
    }

    public void recursionDFS(){
        Vertice<E> vertice = list.get(0);
        int[] visited = new int[list.size()];
        recursionDFS(vertice,visited);
    }

    private int getIndex(Vertice<E> vertice){
        for (int i=0; i < list.size(); i++){
            Vertice<E> middle = list.get(i);
            if (middle.e.equals(vertice.e)){
                return i;
            }
        }
        return -1;
    }

    public void recursionDFS(Vertice<E> vertice,int[] visited){
        System.out.println(vertice.e);
        int index = getIndex(vertice);
        visited[index] = 1;
        Vertice<E> edge = vertice.next;

        while (edge!=null){
            index = getIndex(edge);
            if (visited[index]==0){
                vertice = list.get(index);
                recursionDFS(vertice, visited);
            }
            edge = edge.next;
        }
    }

    public void DFS(){
        Vertice<E> vertice = list.get(0);
        int[] visited = new int[list.size()];
        DFS(vertice,visited);
    }

    public void DFS(Vertice<E> vertice,int[] visited){
        Stack<Vertice<E>> stack = new Stack<>();
        System.out.println(vertice.e);
        int index = getIndex(vertice);
        visited[index] = 1;
        stack.push(vertice);
        Vertice<E> edge = null;

        while (!stack.empty()){
            edge = stack.peek();
            int flag = -1;
            while (edge!=null){
                index = getIndex(edge);
                if (visited[index]==0){
                    edge = list.get(index);
                    System.out.println(edge.e);
                    visited[index] = 1;
                    stack.push(edge);
                    flag = 1;
                }
                edge = edge.next;
            }
            if (flag==-1){
                stack.pop();
            }
        }
    }

    public void BFS(){
        int[] visited = new int[list.size()];
        BFS(list.get(0),visited);
    }

    public void BFS(Vertice<E> vertice,int[] visited){
        LinkedList<Vertice<E>> queue = new LinkedList<>();
        Vertice<E> edge = null;

        System.out.println(vertice.e);
        int index = getIndex(vertice);
        visited[index] = 1;
        queue.addLast(vertice);

        while (!queue.isEmpty()){
            edge = queue.peek();
            int flag = -1;
            while (edge!=null){
                index = getIndex(edge);
                if (visited[index]==0){
                    System.out.println(edge.e);
                    visited[index] = 1;
                    Vertice<E> middler = list.get(index);
                    queue.addLast(middler);
                    flag = 1;
                }
                edge = edge.next;
            }
            if (flag==-1){
                queue.removeFirst();
            }
        }
    }

    public void display(){
        for (int i=0;i<list.size();i++){
            Vertice<E> vertice = list.get(i);
            System.out.print(vertice.e+" to: ");
            while (vertice.next!=null){
                vertice = vertice.next;
                System.out.print(vertice.e+"\t");
            }
            System.out.println();
        }
    }

}
