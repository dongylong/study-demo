package com.thinkinjava.chp5;

/**
 * @author dongyl
 * @date 11:03 10/22/18
 * @project study-demo
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
    Cups.cup1.f(99);
    }
}

class Cup {
    public Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        System.out.println("Cups()");
    }
}