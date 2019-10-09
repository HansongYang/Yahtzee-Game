package comp4004A1;

import java.io.*; 
import java.util.*; 
import java.net.*; 
   
public class gameServer{ 
    public static Vector<ClientHandler> ar = new Vector<>();
    static boolean active = false;
    
    public void joinGames() throws IOException {
    	Socket socket = null;
	    yahtzeeGame game = new yahtzeeGame();
        ClientHandler mtch = new ClientHandler(game, socket); 
        ar.add(mtch);
    }
    
    public boolean gameStarts() {
    	if(ar.size() == 3) {
    		return true;
    	}
    	return false;
    }
    
    public boolean active() {
     	return active;
    }
    
	public static void main(String[] args) throws IOException, InterruptedException{ 
		ServerSocket server = new ServerSocket(8081); 
        Socket socket = null; 
        yahtzeeGame game = new yahtzeeGame();

        System.out.println("Yathzee Game Engine has starting. Waiting for players to join...");
        while (true){ 
        	try {
        		active = true;
	        	socket = server.accept(); 
	            ClientHandler mtch = new ClientHandler(game, socket); 
	            Thread t = new Thread(mtch);
	            ar.add(mtch);
	            t.start(); 
	            if(ar.size() == 3) {
	            	Thread.sleep(500);
	            	System.out.println("The game is starting! \n");
	            }
        	} catch (IOException e) {
        	    if (server != null && !server.isClosed()) {
        	        try {
        	            server.close();
        	            break;
        	        } catch (IOException e1)
        	        {
        	            e1.printStackTrace(System.err);
        	        }
        	    }
        	}
        }
    } 
}

class ClientHandler implements Runnable{ 
    Scanner scn = new Scanner(System.in); 
    private String name; 
    InputStream dis; 
    OutputStream dos; 
    Socket s; 
    yahtzeeGame game;
    
    public ClientHandler(yahtzeeGame game, Socket s) throws IOException {   
        this.game = game;
        if(s != null) {	
	        this.s = s; 
	        this.dos = s.getOutputStream(); 
	        this.dis = s.getInputStream();
        }
    } 
  
    @Override
    public void run() { 
        String request  = ""; 
        boolean firstMessage = false;

        try{
        	 BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        	 while ((request = br.readLine()) != null){ 
        		 if(!firstMessage) {
        			 	name = request;
    					System.out.println(request + " has entered the game lobby!");
    					game.setPlayerName(request);
    					firstMessage = true;
    					if(gameServer.ar.size() == 3) {
    						dos.write((name + " starts\n").getBytes());
    					}
    			  }
                 
        		 if(gameServer.ar.size() == 3) {
        			 for (ClientHandler mc : gameServer.ar){ 
		 				if(request.startsWith("rollAll") && request.endsWith(mc.name)) {
		 					game.rollAllDice();
		 					mc.dos.write((mc.name + " "+ game.printAllDice()).getBytes());
		 					mc.dos.write(0);
		 				} else if(request.startsWith("rollSome") && request.endsWith(mc.name)){
		 					String s = request.substring(9, (request.length() - mc.name.length()));
		 					game.rollSomeDice(s);
		 					mc.dos.write((mc.name + " "+ game.printAllDice()).getBytes());
		 					mc.dos.write(0);
		 				} else if(request.startsWith("score") && request.endsWith(mc.name)) {
		 					String [] inputs = request.split(" ");
		 					int index = Integer.parseInt(inputs[1]);
		 					if(!game.score(inputs[2], index)) {
		 						mc.dos.write((mc.name+"invalid\n").getBytes());
		 					}else {
		 						mc.dos.write((mc.name+"valid\n").getBytes());
			 					String winner = game.nextRound(inputs[2]);
			 					if(winner != null) {
			 						System.out.println(inputs[2] + " wins the game.");
			 						System.out.println("Goodbye");
			 						for (ClientHandler c : gameServer.ar){ 
			 							c.dos.write(("win "+ winner+ " " + game.getPlayerPoints(winner)).getBytes());
			 						}
			 						System.exit(0);
			 						
			 					} else {
			 						System.out.println(inputs[2] + " finishes their turn.");
			 						mc.dos.write((mc.name + " "+ "wait\n").getBytes());
			 						if(game.nextRound()) {
			 							System.out.println("Round " + (game.getPlayerRound(mc.name)-1) +" is finished.\n");
			 							for (ClientHandler c : gameServer.ar){
			 								if(c.name.equals(gameServer.ar.get(2).name)) {
			 									c.dos.write((gameServer.ar.get(2).name + "continue\n").getBytes());
			 								}
			 							}
			 						}else {
			 							for (ClientHandler c : gameServer.ar){ 
				 							if(name.equals(gameServer.ar.get(2).name) && c.name.equals(gameServer.ar.get(1).name)) {
				 								if(game.getPlayerRound(gameServer.ar.get(1).name) == 1) {
				 									 c.dos.write((gameServer.ar.get(1).name + " starts\n").getBytes());
				 								}else {
				 									c.dos.write((gameServer.ar.get(1).name+"continue\n").getBytes());
				 								}
				 							} else if(name.equals(gameServer.ar.get(1).name) && c.name.equals(gameServer.ar.get(0).name)) {
				 								if(game.getPlayerRound(gameServer.ar.get(0).name) == 1) {
				 									 c.dos.write((gameServer.ar.get(0).name + " starts\n").getBytes());
				 								}else {
				 									c.dos.write((gameServer.ar.get(0).name+"continue\n").getBytes());
				 								}
				 							}
			 							}
			 						}
			 					}
		 					}
		 				} else if(request.startsWith("board") && request.endsWith(mc.name)){
		 					mc.dos.write((game.printGameBoard(mc.name)).getBytes());
		 					mc.dos.write(0);
		 				}
		 			}
 				}
        	}  
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally {
	        try{ 
	            this.dis.close(); 
	            this.dos.close(); 
	            s.close();
	        }catch(IOException e){ 
	            e.printStackTrace(); 
	        }
        }
    }
}

