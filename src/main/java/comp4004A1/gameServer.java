package comp4004A1;

import java.net.*; 
import java.io.*; 

public class gameServer extends Thread{
	//initialize socket 
    protected Socket socket = null; 

    public static final int PORT_NUMBER = 8081;
    private gameServer(Socket socket) {
   		this.socket = socket;
   		start();
   	}

    public void run() {
   		InputStream in = null;
   		OutputStream out = null;
    	try {
    		in = socket.getInputStream();
    		out = socket.getOutputStream();
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String request;
   			while ((request = br.readLine()) != null) {
   				System.out.println("Message received:" + request);
   				request += '\n';
   				out.write(request.getBytes());
   			}

   		} catch (IOException ex) {
   			System.out.println("Unable to get input from client");
    	} finally {
    		try {
    			in.close();
    			out.close();
    			socket.close();
    		} catch (IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    }

    public static void main(String[] args) {
   		ServerSocket server = null;
   		try {
   			server = new ServerSocket(PORT_NUMBER);
   			System.out.println("Yathzee Game Engine has starting. Waiting for players to join...");
   			while (true) {
    			new gameServer(server.accept());
    		}
    	} catch (IOException ex) {
    		System.out.println("Unable to start the game server.");
    	} finally {
    		try {
    			if (server != null)
    				server.close();
    		} catch (IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    }
}
