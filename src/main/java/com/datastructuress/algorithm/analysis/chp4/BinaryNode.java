package com.datastructuress.algorithm.analysis.chp4;

/**
 * @author dongyl
 * @date 08:35 12/30/17
 * @project study-demo
 */
public class BinaryNode {
    private Integer element;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int element) {
        this(element, null, null);
    }

    public BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
