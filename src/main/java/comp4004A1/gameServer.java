package comp4004A1;

import java.net.*;
import java.util.*;
import java.io.*; 

public class gameServer extends Thread{
	//initialize socket 
    protected Socket socket = null; 
    ArrayList<String> names = new ArrayList<String>(); 
    yahtzeeGame game;
    int id = 0;
    public static final int PORT_NUMBER = 8081;
    
    private gameServer(yahtzeeGame game, int id, Socket socket) {
   		this.socket = socket;
   		this.game = game;
   		this.id = id;
   		start();
   	}

    public void run() {
   		InputStream in = null;
   		OutputStream out = null;
   		boolean firstMessage = false;
    	try {
    		in = socket.getInputStream();
    		out = socket.getOutputStream();
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		String request;
   			while ((request = br.readLine()) != null) {
				if(!firstMessage) {
   					System.out.println(request + " has entered the game lobby!");
   					game.setPlayerName(request);
   					firstMessage = true;
   				}
				
				if(id == 3) {
					System.out.println(request);
					if(request.equals("rollAll")) {
						game.rollAllDice();
						out.write((game.printAllDice()).getBytes());
						out.write(0);
					} else if(request.startsWith("rollSome")){
						request = request.substring(8, request.length());
						game.rollSomeDice(request);
						out.write((game.printAllDice()).getBytes());
						out.write(0);
					} else if(request.startsWith("score")) {
						request = request.substring(5, request.length());
						String [] inputs = request.split(" ");
						int index = Integer.parseInt(inputs[0]);
						game.score(inputs[1], index);
						String winner = game.nextRound(inputs[1]);
						if(winner!= null) {
							out.write(("win "+ winner).getBytes());
						} else {
							out.write((game.printGameBoard(inputs[1])).getBytes());
							out.write(0);
						}
					} else {
						System.out.println("The game is started.");
						out.write((game.printGameBoard(request)).getBytes());
						out.write(0);
					}
				}
   			}
   		} catch (IOException ex) {
   			System.out.println("Unable to get input from client");
    	} catch(NullPointerException e) {
    		System.out.println("null");
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
   	    yahtzeeGame game = new yahtzeeGame();
   		int id = 1;
   		try {
   			server = new ServerSocket(PORT_NUMBER);
   			System.out.println("Yathzee Game Engine has starting. Waiting for players to join...");
   			while (true) {
    			new gameServer(game, id, server.accept());
    			id++;
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
