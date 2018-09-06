package cn.glbb.graph;

import org.junit.Before;
import org.junit.Test;

public class MyAdjacencyListGraphTest {
    MyAdjacencyListGraph<String> graph = null;
    @Before
    public void init(){
        graph = new MyAdjacencyListGraph<>();
        graph.addVertice("v1");
        graph.addVertice("v2");
        graph.addVertice("v3");
        graph.addVertice("v4");
        graph.addVertice("v5");
        graph.addVertice("v6");
        graph.addVertice("v7");
        graph.addVertice("v8");

        graph.addEdges("v1",new String[]{"v2","v3"});
        graph.addEdges("v2",new String[]{"v1","v4","v5"});
        graph.addEdges("v3",new String[]{"v1","v6","v7"});
        graph.addEdges("v4",new String[]{"v2","v8"});
        graph.addEdges("v5",new String[]{"v2","v8"});
        graph.addEdges("v6",new String[]{"v3","v7"});
        graph.addEdges("v7",new String[]{"v3","v6"});
        graph.addEdges("v8",new String[]{"v4","v5"});
    }

    @Test
    public void test1(){
        graph.display();
        System.out.println("*************************************************");
        graph.recursionDFS();
        System.out.println("________________________________________");
        graph.DFS();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        graph.BFS();
    }
}
