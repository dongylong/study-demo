package com.datastructuress;


import java.util.LinkedList;

/**
 * @author dongyl
 * @date 11:04 6/1/18
 * @project study-demo
 */
public class MyHashMap1 {
    LinkedList[] arr = new LinkedList[999];
    int arrSize = 0;

    //1.构造方法
    public MyHashMap1() {
    }

    //2.向Map中添加元素
//    public void put(Object key, Object value) {
//        Node n = new Node(key, value);
//        int hash = n.hashCode() % arr.length;
//        hash = hash < 0 ? -hash : hash;
//        if (arr[hash] == null) {//如果该位置链表为空
//            LinkedList list = new LinkedList();
//            arr[hash] = list;
//            list.add(n);//将要放入的节点n作为第一个节点放入
//        } else {//如果这个位置已经有链表了
//            LinkedList list = arr[hash];//取出该处的链表
//            //判断有没有键值key重复
//            for (int i = 0; i < list.size(); i++) {
//                Node temp = (Node) list.get(i);
//                if (temp.key.equals(key)) {//如果该节点存在，覆盖掉
//                    temp.value = value;
//                }
//            }
//            arr[hash].add(n);
//        }
//    }

    //3.从Map中,用键去取数据
//    public Object get(Object key) {
//        int hash = key.hashCode() % arr.length;
//        hash = hash < 0 ? -hash : hash;
//        if (arr[hash] != null) {
//            LinkedList list = arr[hash];
//            for (int i = 0; i < list.size(); i++) {
//                Node temp = (Node) list.get(i);
//                if (temp.key.equals(key)) {
//                    return temp.value;
//                }
//            }
//        }
//        return null;
//    }

    class Node {
        private Object key;
        private Object value;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList[] list = new LinkedList[500];
    int listSize;

    public void put(Object key, Object val) {
        Node n = new Node(key, val);
        int hash = key.hashCode() % list.length;
        hash = hash < 0 ? -hash : hash;
        if (list[hash] == null) {
            LinkedList l = new LinkedList();
            l.add(n);
            listSize++;
        } else {
            LinkedList l = list[hash];
            int size = l.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Node tmp = (Node) l.get(i);
                if (tmp.key.equals(key)) {
                    tmp.value = val;
                    flag = true;
                }
            }
            if (!flag) {
                l.add(n);
                listSize++;
            }
        }
    }

    public Object get(Object key) {
        int hash = key.hashCode() % list.length;
        hash = hash < 0 ? -hash : hash;
        if (list[hash] != null) {
            LinkedList l = list[hash];
            int size = l.size();
            for (int i = 0; i < size; i++) {
                Node tmp = (Node) l.get(i);
                if (tmp.key.equals(key)) {
                    return tmp.value;
                }
            }
        }
        return null;
    }
}
