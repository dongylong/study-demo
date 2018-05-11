package com.web.action;

import org.apache.tomcat.util.buf.CharChunk;
import org.apache.tomcat.util.buf.MessageBytes;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dongyl
 * @date 11:29 2/23/18
 * @project study-demo
 */
public class HttpDemoTest {

    protected void convertURI(MessageBytes uri) {
        CharChunk charChunk = uri.getCharChunk();

    }

    @Test
    public void socketTest() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(8080));
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            Set selectedKeys = selector.selectedKeys();
            Iterator iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = ssChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    iterator.remove();
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    while (true) {
                        byteBuffer.clear();
                        int n = sc.read(byteBuffer);
                        if (n <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                    }
                    iterator.remove();
                }
            }
        }
    }
// import com.sun.tools.javac.tree.JCTree;
//    public JCTree.JCExpression qualident() {
//
//        return null;
//    }

    @Test
    public void typeTest(int srcId) {
//        int srcId = 0;
        if (srcId == 1) {

        }
    }

    @Test
    public void readerTest() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            char[] buf = new char[1024];
            FileReader fileReader = new FileReader("file");
            while (fileReader.read(buf) > 0) {
                stringBuffer.append(buf);
            }
            stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        HttpClient httpClient = createHttpClient();
////        String domainName = Switcher.domain;
//        PostMethod postMethod;
//        postMethod = new PostMethod();
//        postMethod.addRequestHeader();
//    }
//
//    private static HttpClient createHttpClient() {
//
//        return null;
//    }
}
