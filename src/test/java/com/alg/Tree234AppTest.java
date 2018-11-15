package com.alg;

import com.datastructuress.alg.chp10.Tree234;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dongyl
 * @date 18:32 12/27/17
 * @project message-svr
 */
public class Tree234AppTest {
    Tree234 theTree= new Tree234();
    long value ;
    @Before
    public void insertTreeTest(){
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(30);
        theTree.insert(60);
        theTree.insert(70);
        theTree.displayTree();
    }

    @Test
    public void insertTest(){
        value = 10;
        theTree.insert(value);
        System.out.println();
        theTree.displayTree();
    }

    @Test
    public void findTest(){
        value = 30;
        int xx = theTree.find(value);
        System.out.println("xx: "+xx);
    }
}
