package com;

/**
 * @author dongyl
 * @date 14:32 2019-02-13
 * @project study-demo
 */
public class TheadTest {

    public void testWait() throws InterruptedException {
        synchronized (this) {
            this.wait();
        }
    }
    public void testNotify(){
        synchronized (this){
            this.notify();
        }
    }
}
