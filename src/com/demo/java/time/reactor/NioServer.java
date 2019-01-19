package com.demo.java.time.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress("localhost", 11111);

        socketChannel.bind(addr);
        socketChannel.configureBlocking(false);

        int ops = socketChannel.validOps();
        SelectionKey selectionKey = socketChannel.register(selector, ops, null);

        while (true) {
            log("I'm server");
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey myKey = iterator.next();

                if (myKey.isAcceptable()) {
                    SocketChannel client = socketChannel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    log("Connection accepted");
                } else if (myKey.isReadable()) {
                    SocketChannel client = (SocketChannel) myKey.channel();
                }
            }
        }
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
