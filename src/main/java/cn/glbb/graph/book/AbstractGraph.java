package cn.glbb.graph.book;

import java.util.List;

public class AbstractGraph<V> implements Graph<V> {

    protected AbstractGraph(V[] vertices,int[][] edges){

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public List<V> getVertices() {
        return null;
    }

    @Override
    public V getVertex(int index) {
        return null;
    }

    @Override
    public int getIndex(V v) {
        return 0;
    }

    @Override
    public List<Integer> getNeighbors(int index) {
        return null;
    }

    @Override
    public int getDegree(int v) {
        return 0;
    }

    @Override
    public void printEdges() {

    }

    @Override
    public void clear() {

    }

    @Override
    public void addVertex(V vertex) {

    }

    @Override
    public void addEdge(int u, int v) {

    }
}
