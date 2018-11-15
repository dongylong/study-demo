package com.thinkinjava.chp11;

import java.util.LinkedList;

/**
 * @author dongyl
 * @date 16:03 10/23/18
 * @project study-demo
 */
public class InsertLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        insertMiddle(linkedList,1);
        insertMiddle(linkedList,2);
        insertMiddle(linkedList,3);
        insertMiddle(linkedList,4);
        insertMiddle(linkedList,5);
        insertMiddle(linkedList,6);
        insertMiddle(linkedList,7);
        linkedList.forEach(item->{
            System.out.print(item+" , ");
        });
    }
    private static void insertMiddle(LinkedList<Integer> linkedList, int item){
        int listSize = linkedList.size();
        linkedList.add(listSize/2,item);
    }
}
