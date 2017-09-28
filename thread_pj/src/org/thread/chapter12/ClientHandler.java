package org.thread.chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author zzy 2017年9月28日
 * @version
 */
public class ClientHandler implements Runnable {
	private final Socket socket;

	private volatile boolean running = true;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
				PrintWriter printWriter = new PrintWriter(outputStream)) {
			while (running) {
				String message = br.readLine();
				if (message == null) {
					break;
				}
				System.out.println("Come from client > " + message);
				printWriter.write("echo " + message + "\n");
				printWriter.flush();
			}
			
		} catch (IOException e) {
			this.running = false;
		} finally {
			this.stop();
		}
	}

	public  void stop() {
		if (!running) {
			return ;
		}
		this.running = false;
		
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
