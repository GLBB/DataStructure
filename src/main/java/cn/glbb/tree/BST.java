package cn.glbb.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;
    protected int size;

    public BST(){}

    public BST(E[] objects){
        for (int i =0;i<objects.length;i++){
            insert(objects[i]);
        }
    }

    public static class TreeNode<E extends Comparable<E>>{
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(){}
        public TreeNode(E e){
            element = e;
        }
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root){
        if(root!=null) {
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    // ！！！为了子类能够重新创建节点
    public TreeNode<E> createNode(E e){
        return new TreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        TreeNode<E> node = createNode(e);

        if(root==null){
            root = node;
        }else {
            TreeNode<E> parrent = null;
            TreeNode<E> current = root;
            while (current!=null){
                int value = current.element.compareTo(e);
                parrent = current;
                if(value<0){
                    current = current.right;
                }else if(value>0){
                    current = current.left;
                }else {
                    return false;
                }
            }

            int value = parrent.element.compareTo(e);
            if(value<0){
                parrent.right = node;
            }else if(value>0){
                parrent.left = node;
            }
        }
        size++;
        return true;
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode root){
        if (root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element+" ");
        }
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root){
        if(root!=null) {
            System.out.print(root.element+" ");
            this.preorder(root.left);
            this.preorder(root.right);
        }
    }

    @Override
    public int getSize() {
        return size;
    }



    @Override
    public boolean search(E e) {
        if (e==null){
            return false;
        }
        TreeNode<E> node = root;
        while (node!=null){
            int value = e.compareTo(node.element);
            if (value<0){
                node = node.left;
            }else if (value>0){
                node = node.right;
            }else {
                return true;
            }
        }
        return false;
    }

    public List<TreeNode<E>> path(E e){
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> node = root;
        while (node!=null){
            list.add(node);
            int value = e.compareTo(node.element);
            if(value<0){
                node = node.left;
            }else if(value>0){
                node = node.right;
            }else {
                return list;
            }
        }
        return null;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> node = root;
        if (node==null){
            throw new RuntimeException("树为空");
        }
        if(e==null){
            throw new RuntimeException("结果为空");
        }

        // 定位到该节点到要删除的节点 和 要删除的节点的父节点
        while (node!=null&&e.compareTo(node.element)!=0){
            int value = e.compareTo(node.element);
            if(value<0){
                parent = node;
                node=node.left;
            }else if(value>0){
                parent = node;
                node=node.right;
            }
        }
        if(node==null){
            throw new RuntimeException("该节点不存在");
        }

        // 如果要删除的节点没有左字节点
        if (node.left==null){
            if (parent==null){
                root = root.right;
            }else {
                if(node.equals(parent.left)){
                    parent.left = node.right;
                }else if (node.equals(parent.right)){
                    parent.right = node.right;
                }else {
                    throw new RuntimeException("未知错误");
                }
            }
            size--;
            return true;
        }else {
            // 如果删除的节点有左节点

            // 寻找要删除的左节点的左子树中最大节点
            TreeNode<E> rightMost = node.left;
            TreeNode<E> rightMostOfParent = null;
//            TreeNode<E> subRoot = node.left;
            while (rightMost.right!=null){
                rightMostOfParent = rightMost;
                rightMost = rightMost.right;
            }
            node.element = rightMost.element;
            if(rightMostOfParent!=null) {
                rightMostOfParent.right = rightMost.left;
            }else {
                node.left = null;
            }
            size--;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
