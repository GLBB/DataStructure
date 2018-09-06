package cn.glbb.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MyGraphTest {

    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int i = list.indexOf(1);
        System.out.println(i);
    }

    @Test
    public void test2(){
        MyAdjacencyMatricGraph<String> myGraph = new MyAdjacencyMatricGraph<>();
        myGraph.addVertices("Seattle",null);

        String[] target1 = {"Seattle"};
        myGraph.addVertices("San Francisco",target1);

        String[] target2 = {"San Francisco"};
        myGraph.addVertices("Los Angeles",target2);

        String[] target3 = {"Seattle","San Francisco","Los Angeles"};
        myGraph.addVertices("Denver",target3);

        myGraph.display();
        System.out.println("--------------------------------------------");
        myGraph.recursionDFS();

        System.out.println("*********************************************************");
        myGraph.DFS();
    }

    @Test
    public void test3(){
        int i = 1;
        do {
            if (i==1){
                System.out.println(i);
                i++;
                continue;
            }
        }while (i==1);
    }

    MyAdjacencyMatricGraph<String> graph;

    @Before
    public void init(){
        graph = new MyAdjacencyMatricGraph<>();
        graph.addVertices("v1",null);

        String[] t1 = {"v1"};
        graph.addVertices("v2",t1);

        String[] t2 = {"v1"};
        graph.addVertices("v3",t2);

        String[] t3 = {"v2"};
        graph.addVertices("v4",t3);

        String[] t4 = {"v2"};
        graph.addVertices("v5",t4);

        String[] t5 = {"v4","v5"};
        graph.addVertices("v8",t5);

        String[] t6 = {"v3"};
        graph.addVertices("v6",t6);

        String[] t7 = {"v3","v6"};
        graph.addVertices("v7",t7);
    }

    @Test
    public void test4(){
        graph.display();
        System.out.println("------------------------------------------------");
        graph.recursionDFS();
        System.out.println("***************************************************");
        graph.DFS();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        graph.BFS();
    }
}
