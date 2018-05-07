package com.noriental.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongyl
 * @date 15:26 2/9/18
 * @project study-demo
 */
public class TopDemo {

    @Test
    public void gcTest() throws InterruptedException {
        System.out.println("ready");
        Thread.sleep(10000);
        List<GCDataObject> gcDataObject = new ArrayList<>();
        for (int i = 0; i < 51200; i++) {
            gcDataObject.add(new GCDataObject(2));
        }
        System.gc();
        gcDataObject.size();
        gcDataObject = null;
        Thread.sleep(10000);
        List<GCDataObject> tmpObjects = new ArrayList<>();
        for (int i = 0; i < 3200; i++) {
            tmpObjects.add(new GCDataObject(5));
        }
        tmpObjects.size();
        tmpObjects = null;
    }

    class GCDataObject {
        byte[] bytes = null;
        RefObject object = null;

        public GCDataObject(int i) {
            bytes = new byte[i * 1024];
            object = new RefObject();
        }
    }

    private class RefObject {
        RefChildObject object;

        public RefObject() {
            RefChildObject object = new RefChildObject();
        }
    }

    class RefChildObject {
        public RefChildObject() {
        }
    }
//    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(20000);
//        System.out.println("ready to create bytes,so JVM heap will be used");
//        byte[] bytes = new byte[128 * 1000 * 1000];
//        bytes[0]=1;
//        bytes[1]=2;
//        Thread.sleep(10000);
//        System.out.println("read to allocate &put direct byte buff ,no jvm heap should be used");
//        ByteBuffer buffer = ByteBuffer.allocateDirect(128*1024*1024);
//        buffer.put(bytes);
//        buffer.flip();
//        Thread.sleep(10000);
//        System.out.println("ready to gc ,JVM heap will be freed");
//        bytes=null;
//        System.gc();
//        Thread.sleep(10000);
//        System.out.println("read to get bytes,then jvm will be used");
//        byte[] resultBytes = new byte[128 * 1000 * 1000];
//        buffer.get(resultBytes);
//        System.out.println("resultBytes[1] :"+resultBytes[1]);
//        Thread.sleep(10000);
//        System.out.println("read to gc all");
//        buffer=null;
//        resultBytes = null;
//        System.gc();
//        Thread.sleep(10000);
//
//    }
}
