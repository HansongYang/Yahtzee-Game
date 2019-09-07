package comp4004A1;

import java.net.*; 
import java.io.*;

public class gameClient {
	private yahtzeeGame game = new yahtzeeGame();
	public static void main(String args[]) {
		String host = "127.0.0.1";
		int port = 8081;
		new gameClient(host, port);
	}

	public gameClient(String host, int port) {
		try {
			String serverHostname = new String("127.0.0.1");
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Welcome to the Yahtzee game, please enter your name.");
			String name = stdIn.readLine();
			game.setPlayerName(name);

			Socket echoSocket = null;
			PrintWriter out = null;
			BufferedReader in = null;

			try {
				echoSocket = new Socket(serverHostname, 8081);
				out = new PrintWriter(echoSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + serverHostname);
				System.exit(1);
			} catch (IOException e) {
				System.exit(1);
			}

			while (true) {
				game.printGameBoard(name);
				System.out.println("Press <<ENTER>> to roll the dice ...");
				
				String userInput = stdIn.readLine();

				if ("q".equals(userInput)) {
					break;
				}
				out.println(userInput);
				System.out.println("server: " + in.readLine());
			}

			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
