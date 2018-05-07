package com.noriental.alg;

/**
 * @author dongyl
 * @date 14:32 12/26/17
 * @project message-svr
 */
public class ConChp1 {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(50, 1.5);
        tree.insert(25, 1.7);
        tree.insert(75, 1.9);

        Node root = tree.root;
        tree.inOrder(root);
        System.out.println();
        System.out.println("tree:");
    }

    static class Tree {
        private Node root;

        //中序遍历
        public void inOrder(Node localRoot) {
            if (localRoot != null) {
                inOrder(localRoot.leftChild);
                System.out.print(localRoot.iData + " ");
                inOrder(localRoot.rightChild);
            }
        }

        public Node find(int key) {
            Node current = root;
            while (current.iData != key) {
                if (key < current.iData) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
                if (current == null) {
                    return null;
                }
            }
            return current;
        }

        public void delete(int id) {
        }

        public void insert(int id, double dd) {
            Node newNode = new Node();
            newNode.iData = id;
            newNode.dData = dd;
            if (root == null) {
                root = newNode;
            } else {
                Node current = root;

                Node parent;
                while (true) {
                    parent = current;
                    if (id < current.iData) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = newNode;
                            return;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
            }
        }
    }

    static class Node {
        Person person;
        int iData;
        double dData;
        Node leftChild;
        Node rightChild;

        public void displayNode() {
        }
    }

    class Person {
        int iData;
        double fData;
    }

}
