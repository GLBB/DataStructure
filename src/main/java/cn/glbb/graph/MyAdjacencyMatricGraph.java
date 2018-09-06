package cn.glbb.graph;

import java.util.*;

// 无权图 无向图
public class MyAdjacencyMatricGraph<E> {
    private ArrayList<E> vertices = new ArrayList<>();
    int [][] matrixEdge;

    /**
     * 增加节点
     * @param vertice 要增加的节点
     * @param verticeTarget 目的节点
     */
    public void addVertices(E vertice, E[] verticeTarget){
        vertices.add(vertice);

        int size = vertices.size();
        int[][] newlyMatrixEdge = new int[size][size];

        for(int i=0;i<size-1;i++){
            for (int j=0;j<size-1;j++){
                newlyMatrixEdge[i][j] = matrixEdge[i][j];
            }
        }

        for(int i=0; verticeTarget!=null && i<verticeTarget.length; i++){
            int index = vertices.indexOf(verticeTarget[i]);
            newlyMatrixEdge[size-1][index] = 1;
            newlyMatrixEdge[index][size-1] = 1;
        }

        matrixEdge = newlyMatrixEdge;
    }

    /**
     * 递归深度遍历
     */
    public void recursionDFS(){
        int[] visited = new int[vertices.size()];
        recursionDFS(vertices.get(0),visited);
    }

    protected void recursionDFS(E e,int[] visited){
        int index = vertices.indexOf(e);
        if(visited[index]==0){
            // 说明没有访问过
            System.out.println(e);
            visited[index] = 1;
            for (int i=0; vertices!=null&&i<vertices.size(); i++){
                if(matrixEdge[index][i]!=0){
                    recursionDFS(vertices.get(i),visited);
                }
            }
        }
    }

    /**
     * 非递归深度遍历
     */
    public void DFS(){
        int[] visited = new int[vertices.size()];
        DFS(vertices.get(0),visited);
    }

    public void DFS(E e,int[] visited){
        Stack<E> stack = new Stack<>();
        int size = vertices.size();
        System.out.println(e);
        int index = vertices.indexOf(e);
        visited[index]  = 1;
        stack.push(e);
        while (!stack.empty()){
            e = stack.peek();
            index = vertices.indexOf(e);
            int flag = -1;
            for (int i=0; i < size; i++){
                if (matrixEdge[index][i]!=0&&visited[i]==0){
                    e = vertices.get(i);
                    System.out.println(e);
                    visited[i] = 1;
                    stack.push(e);
                    flag = 1;
                    break;
                }
            }
            if(flag==-1){
                stack.pop();
            }
        }

    }

    // 广度非递归实现
    public void BFS(){
        BFS(vertices.get(0));
    }

    protected void BFS(E e){
        int size = vertices.size();
        int[] visited = new int[size];
        LinkedList<E> queue =  new LinkedList<>();

        System.out.println(e);
        int index = vertices.indexOf(e);
        visited[index] = 1;
        queue.addLast(e);

        while (!queue.isEmpty()){
            e = queue.peek();
            index = vertices.indexOf(e);
            int flag = -1;
            for(int i=0; i < size; i++){
                if(matrixEdge[index][i]!=0 && visited[i]==0){
                    e = vertices.get(i);
                    System.out.println(e);
                    visited[i] = 1;
                    queue.addLast(e);
                    flag = 1;
                }
            }
            if (flag==-1){
                queue.removeFirst();
            }
        }
    }


    public void display(){
        for(int i=0;i<vertices.size();i++){
            E e = vertices.get(i);
            int size = vertices.size();
            System.out.print(e+" to: ");
            for(int j=0;j<size;j++){
                if(matrixEdge[i][j]!=0){
                    E target = vertices.get(j);
                    System.out.print(target+" \t");
                }
            }
            System.out.println();
        }
    }
}
