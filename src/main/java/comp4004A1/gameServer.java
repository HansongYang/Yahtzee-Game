package comp4004A1;

import java.io.*; 
import java.util.*; 
import java.net.*; 
   
public class gameServer{ 
    static Vector<ClientHandler> ar = new Vector<>();

	public static void main(String[] args) throws IOException, InterruptedException{ 
		ServerSocket server = new ServerSocket(8081); 
        Socket socket = null; 
        yahtzeeGame game = new yahtzeeGame();

        System.out.println("Yathzee Game Engine has starting. Waiting for players to join...");
        while (true){ 
        	socket = server.accept(); 
            ClientHandler mtch = new ClientHandler(game, socket); 
            Thread t = new Thread(mtch);
            ar.add(mtch);
            t.start(); 
            if(ar.size() == 3) {
            	Thread.sleep(500);
            	System.out.println("The game is starting!");
            }
        } 
    } 
}

class ClientHandler implements Runnable{ 
    Scanner scn = new Scanner(System.in); 
    private String name; 
    final InputStream dis; 
    final OutputStream dos; 
    Socket s; 
    boolean isloggedin; 
    yahtzeeGame game;
    
    public ClientHandler(yahtzeeGame game, Socket s) throws IOException {   
        this.game = game;
        this.s = s; 
        this.dos = s.getOutputStream(); 
        this.dis = s.getInputStream();
        this.isloggedin = true; 
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
    						 for (ClientHandler mc : gameServer.ar){ 
    							 mc.dos.write((mc.name + "start\n").getBytes());
    						 }
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
		 					game.score(inputs[2], index);
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
		 							System.out.println("Round " + (game.getPlayerRound(mc.name)-1) +" is finished.");
		 							for (ClientHandler c : gameServer.ar){ 
		 								c.dos.write((c.name+"continue\n").getBytes());
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
	        }catch(IOException e){ 
	            e.printStackTrace(); 
	        }
        }
    }
}

