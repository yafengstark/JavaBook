package com.mashibing.io.nio;

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
 * 单线程的nio server
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
        serverSocketChannel.configureBlocking(false);// 非阻塞模型

        System.out.println("server started, listening on :" + serverSocketChannel.getLocalAddress());
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);// 注册，对哪件事感兴趣
        // 对连接这件事感兴趣
        // 过一段时间轮训一次

        while(true) {
            selector.select(); // 阻塞方法

            // 发生的事件存在keys中
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while(it.hasNext()) {
                SelectionKey key = it.next();
                it.remove(); // 一定要remove掉，否则会重复处理
                handle(key);
            }
        }

    }

    private static void handle(SelectionKey key) {
        if(key.isAcceptable()) {
            // 想连接
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //new Client
                //
                //String hostIP = ((InetSocketAddress)sc.getRemoteAddress()).getHostString();

			/*
			log.info("client " + hostIP + " trying  to connect");
			for(int i=0; i<clients.size(); i++) {
				String clientHostIP = clients.get(i).clientAddress.getHostString();
				if(hostIP.equals(clientHostIP)) {
					log.info("this client has already connected! is he alvie " + clients.get(i).live);
					sc.close();
					return;
				}
			}*/

                sc.register(key.selector(), SelectionKey.OP_READ );
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        } else if (key.isReadable()) { //flip
            SocketChannel sc = null;
            try {
                sc = (SocketChannel)key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(512);
                buffer.clear();
                int len = sc.read(buffer);

                if(len != -1) {
                    System.out.println(new String(buffer.array(), 0, len));
                }

                ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
                sc.write(bufferToWrite);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(sc != null) {
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
