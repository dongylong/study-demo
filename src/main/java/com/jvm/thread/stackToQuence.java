package com.jvm.thread;

import java.util.Stack;

/**
 * @author dongyl
 * @date 18:57 6/6/18
 * @project study-demo
 */
public class stackToQuence {

    static Stack<Integer> s1=new Stack<Integer>();
    static Stack<Integer> s2=new Stack<Integer>();

    //在尾部追加元素，
    public  void addtail(int a) {
        s1.push(a);
    }

    //删除元素，
    public  int dele() {
        if(s1.size()+s2.size()!=0){
            //即使新入栈一个元素。但是只要s2不是空的就一定要保证把s2的栈顶输出，直到s2空
            if(s2.isEmpty()) {
                s1tos2();
            }
            return s2.pop();
        }
        else {
            return -1;
        }
    }

    public void s1tos2(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }

    public static void main(String [] args) {
        stackToQuence q=new stackToQuence();
        q.addtail(0);
        q.addtail(1);
        q.addtail(3);
        q.addtail(5);
        System.out.print(q.dele());
        q.addtail(7);
        System.out.print(q.dele());

    }
}
