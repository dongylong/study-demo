package com.datastructuress;

import java.util.HashMap;

/**
 * @author dongyl
 * @date 15:31 5/16/18
 * @project study-demo
 */
public class LinkListDemo {
    public static boolean hasLoop(Node n) {
        //定义两个指针tmp1,tmp2
        Node tmp1 = n;
        Node tmp2 = n.next;

        while (tmp2 != null) {

            int d1 = tmp1.val;
            int d2 = tmp2.val;
            if (d1 == d2) {
                //当两个指针重逢时，说明存在环，否则不存在。
                return true;
            }
            //每次迭代时，指针1走一步，指针2走两步
            tmp1 = tmp1.next;
            tmp2 = tmp2.next.next;
            if (tmp2 == null) {
                //不存在环时，退出
                return false;
            }

        }
        //如果tmp2为null，说明元素只有一个，也可以说明是存在环
        return true;
    }

    /**
     * 方法2：将每次走过的节点保存到hash表中，如果节点在hash表中，则表示存在环
     */
    public static boolean hasLoop2(Node n) {
        Node temp1 = n;
        HashMap<Node, Node> ns = new HashMap<Node, Node>();
        while (n != null) {
            if (ns.get(temp1) != null) {
                return true;
            } else {
                ns.put(temp1, temp1);
            }
            temp1 = temp1.next;
            if (temp1 == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //构造一个带环的链表,去除此句表示不带环
        n5.next = n1;

        System.out.println(hasLoop(n1));
        System.out.println(hasLoop2(n1));
    }

    static class Node {
        public int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
