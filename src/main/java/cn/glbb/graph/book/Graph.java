package cn.glbb.graph.book;

import java.util.List;

public interface Graph<V> {
    /**
     * 返回图中节点个数
     * @return
     */
    int getSize();

    /**
     * 返回图中所有节点
     * @return
     */
    List<V> getVertices();

    /**
     * 通过索引返回节点
     * @param index
     * @return
     */
    V getVertex(int index);

    /**
     * 得到节点对应的索引
     * @param v
     * @return
     */
    int getIndex(V v);

    /**
     * 通过索引获得这个节点周围的节点的索引
     * @param index
     * @return
     */
    List<Integer> getNeighbors(int index);

    int getDegree(int v);

    void printEdges();

    void clear();

    void addVertex(V vertex);

    void addEdge(int u, int v);
}
