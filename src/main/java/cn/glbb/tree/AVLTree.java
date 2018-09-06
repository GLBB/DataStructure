package cn.glbb.tree;

import cn.glbb.tree.BST;

import java.util.List;

public class AVLTree<E extends Comparable<E>> extends BST<E> {
    public AVLTree(){

    }

    public AVLTree(E[] objects){
        super(objects);
    }

    protected static class AVLTreeNode<E extends Comparable<E>> extends BST.TreeNode<E> {
        protected int height = 0;

        public AVLTreeNode(E e){
            super(e);
        }

        public AVLTreeNode(TreeNode<E> node){
            left = node.left;
            right = node.right;
        }
    }

    @Override
    public TreeNode<E> createNode(E e) {
        return new AVLTreeNode<E>(e);
    }

    private void updateHeight(AVLTreeNode<E> node){
        if (node.left == null && node.right == null){
            node.height = 0;
        }else if(node.left == null){
            node.height = 1 + ((AVLTreeNode)node.right).height;
        }else if (node.right == null){
            node.height = 1 + ((AVLTreeNode)node.left).height;
        }else {
            int leftChildHeight = ((AVLTreeNode)(node.left)).height;
            int rightChildHeight = ((AVLTreeNode)(node.right)).height;
            int maxChildHeight = Math.max(leftChildHeight,rightChildHeight);
            node.height = 1 + maxChildHeight;
        }
    }

    private int blanceFactor(AVLTreeNode<E> node){
        if (node.left == null){
            return node.height;
        }else if (node.right == null){
            return -node.height;
        }else {
            return ((AVLTreeNode<E>)node.right).height - ((AVLTreeNode<E>)node.left).height;
        }
    }

    public void blanceLL(TreeNode<E> A, TreeNode<E> parentOfA){
        TreeNode<E> B = A.left;

        if (root == A){
            root = B;
        }else {
            if (parentOfA.left == A){
                parentOfA.left = B;
            }else {
                parentOfA.right = B;
            }
        }

        A.left =  B.right;
        B.right = A;

        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode)B);
    }

    private void blanceRR(TreeNode<E> A, TreeNode<E> parentOfA){
        TreeNode<E> B = A.right;

        if (root == A){
            root = B;
        }else {
            if (parentOfA.left == A){
                parentOfA.left = B;
            }else {
                parentOfA.right = B;
            }
        }

        A.right = B.left;
        B.left = A;

        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode)B);
    }

    private void blanceLR(TreeNode<E> A, TreeNode<E> parentOfA){
        TreeNode<E> B = A.left;
        TreeNode<E> C = B.right;

        if (A == root){
            root = C;
        }else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            }else {
                parentOfA.right = C;
            }
        }

        B.right = C.left;
        A.left = C.right;
        C.left = B;
        C.right = A;

        updateHeight((AVLTreeNode)B);
        updateHeight((AVLTreeNode)A);
        updateHeight((AVLTreeNode)C);
    }

    private void blanceRL(TreeNode<E> A, TreeNode<E> parentOfA){
        TreeNode<E> B = A.right;
        TreeNode<E> C = B.left;

        if (A == root){
            root = C;
        }else {
            if (A == parentOfA.left){
                parentOfA.left = C;
            }else {
                parentOfA.right = C;
            }
        }

        A.right = C.left;
        B.left = C.right;
        C.left = A;
        C.right = B;

        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTreeNode<E>) C);
    }

    private void balancePath(E e){
        List<TreeNode<E>> path = path(e);

        for (int i = path.size()-1; i>=0; i--){
            AVLTreeNode<E> A = (AVLTreeNode<E>) path.get(i);
            updateHeight(A);
            AVLTreeNode parentOfA = null;
            if (i != 0){
                parentOfA = (AVLTreeNode) path.get(i - 1);
            }

            switch (blanceFactor(A)){
                case -2:
                    if (blanceFactor((AVLTreeNode<E>) (A.left))<=0){
                        blanceLL(A,parentOfA);
                    }else {
                        blanceLR(A,parentOfA);
                    }
                    break;
                case 2:
                    if (blanceFactor((AVLTreeNode<E>) A.right)<0){
                        blanceRL(A,parentOfA);
                    }else {
                        blanceRR(A,parentOfA);
                    }
                    break;
            }
        }

    }

    @Override
    public boolean insert(E e) {
        boolean successful = super.insert(e);
        if (!successful){
            return false;
        }else {
            balancePath(e);
            return true;
        }

    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> current = root;
        TreeNode<E> currentOfParent = null;

        while (current!=null){
            if (current.element.compareTo(e)>0){
                currentOfParent = current;
                current = current.left;
            }else if (current.element.compareTo(e)<0){
                currentOfParent = current;
                current = current.right;
            }else {
                break;
            }
        }

        if (current==null){
            return false;
        }

        if (current.left==null){
            if (current == root){
                 root = current.right;
            }else {
                if (currentOfParent.left == current){
                    currentOfParent.left = current.right;
                }else {
                    currentOfParent.right = current.right;
                }
            }
            balancePath(currentOfParent.element);
        }else {
            TreeNode<E> rightMostOfParent = current;
            TreeNode<E> rightMost = rightMostOfParent.left;
            while (rightMost.right != null){
                rightMostOfParent = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;
            if (rightMostOfParent.left == rightMost){
                rightMostOfParent.left = null;
            }else {
                rightMostOfParent.right = rightMost.left;
            }
            balancePath(rightMostOfParent.element);

        }

        size--;
        return true;
    }
}
