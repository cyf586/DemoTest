package com.cyf.test.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServerDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool(); 
		ServerSocket server = new ServerSocket(7777);
		System.out.println("server start");
		
		while(true) {
			final Socket socket = server.accept();
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("client listen");
					InputStream is = null;
					try {
						is = socket.getInputStream() ;
						byte[] b = new byte[1024];
						while(true) {
							int data = is.read(b);
							if(data!=-1) {
								System.out.println(new String(b, 0, data));
							}else {
								break;
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							if(is!=null)
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					System.out.println("client close");
				}
			});
			
		}
	}
}
