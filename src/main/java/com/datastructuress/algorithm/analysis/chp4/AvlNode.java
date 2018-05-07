package com.datastructuress.algorithm.analysis.chp4;

/**
 * @author dongyl
 * @date 20:08 12/30/17
 * @project study-demo
 */
public class AvlNode {
    private Integer element;
    private AvlNode left;
    private AvlNode right;
    private int height;

    public AvlNode(Integer theElement) {
        this(theElement, null, null, 0);
    }
    public AvlNode() {
        this(null, null, null, 0);
    }

    public AvlNode(Integer element, AvlNode left, AvlNode right, int height) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    public AvlNode getLeft() {
        return left;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
