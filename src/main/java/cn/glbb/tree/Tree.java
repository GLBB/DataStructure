package cn.glbb.tree;

public interface Tree<E> extends Iterable<E> {
    boolean search(E e);

    boolean insert(E e);

    boolean delete(E e);

    void inorder();

    void postorder();

    void preorder();

    int getSize();

    boolean isEmpty();
}
