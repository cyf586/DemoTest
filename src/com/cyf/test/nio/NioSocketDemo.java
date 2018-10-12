package com.cyf.test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioSocketDemo {
	
	private Selector selector;

	public void initServer(int port) throws IOException {
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		channel.socket().bind(new InetSocketAddress(port));
		
		this.selector = Selector.open();
		channel.register(selector, SelectionKey.OP_ACCEPT);
		
		System.out.println("server start");
	}
	
	public void listenSelector() throws IOException {
		while(true) {
			this.selector.select();
			Iterator<?> it = this.selector.selectedKeys().iterator();
			System.out.println("selector key size:" + this.selector.selectedKeys().size());
			while(it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();
				handler(key);
				it.remove();
				System.out.println("act listen end:" + key.isAcceptable() + " " + key.isReadable());
			}
		}
	}
	
	private void handler(SelectionKey key) throws IOException {
		System.out.println("act listen start:" + key.isAcceptable() + " " + key.isReadable());
		if(key.isAcceptable()) {
			ServerSocketChannel channel = (ServerSocketChannel) key.channel();
			SocketChannel sc = channel.accept();
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
			System.out.println("client connect");
		}else if(key.isReadable()) {
			SocketChannel sc = (SocketChannel) key.channel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int data = sc.read(buffer);
			if(data>0) {
				System.out.println(new String(buffer.array()));
			}else {
				System.out.println("read cancel");
				key.cancel();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		NioSocketDemo demo = new NioSocketDemo();
		demo.initServer(7777);
		demo.listenSelector();
	}
}
