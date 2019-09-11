package comp4004A1;

import java.net.*; 
import java.util.Scanner;
import java.io.*;

public class gameClient {
	String name = "";
	Scanner scan = new Scanner(System.in); 
	public static void main(String args[]) {
		String host = "127.0.0.1";
		int port = 8081;
		new gameClient(host, port);
	}

	public gameClient(String host, int port) {
		try {
			String serverHostname = new String("127.0.0.1");
			System.out.println("Welcome to the Yahtzee game, please enter your name.");
			name = scan.nextLine();
			
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
			
			out.println(name);
			System.out.println("Waiting for other players....\n");
			
			while (true) {
				String board = "";
				while ((board = in.readLine()) != null) {
					System.out.println(board);
					if(in.read() == 0) {
						break;
					}
				}
				
				System.out.println("Press <<ENTER>> to roll the dice ...");
				String userInput = "";
				while(true) {
					userInput = scan.nextLine();
					if(userInput.equals("")) {
						out.println("rollAll");
						break;
					}
				}

				String dice = "";
				while ((dice = in.readLine()) != null) {
					System.out.print(dice);
					if(in.read() == 0) {
						break;
					}
				}
				System.out.println('\n');
				
				int roll = 1;
				while(true) {
					System.out.println("What action would you like to perform next?");
					System.out.println("(1) Select dice to re-roll, and then hold the other dice?");
					System.out.println("(2) Re-roll all the dice?");
					System.out.println("(3) Score this round?");
					int input = Integer.parseInt(scan.nextLine());
					if(input == 1) {
						System.out.println("Please enter in the dice position that you want to re-roll (0-4). Please serperate each number with a <<SPACE>>:");
						userInput = scan.nextLine();
						out.println("rollSome" + userInput);
						roll++;
					} else if (input == 2) {
						out.println("rollAll");
						roll++;
					} else if (input == 3) {
						System.out.println("What category do you want to score this round against? (Please enter the category number)");
						input = scan.nextInt();
						out.println("score" + input + " " + name);
						break;
					} else {
						System.out.println("Invalid Input. Please enter again.");
					}
					
					while ((dice = in.readLine()) != null) {
						System.out.print(dice);
						if(in.read() == 0) {
							break;
						}
					}
					System.out.println('\n');
					
					if(roll == 3) {
						System.out.println("What category do you want to score this round against? (Please enter the category number)");
						input = Integer.parseInt(scan.nextLine());
						out.println("score" + input + " " + name);
						break;
					}
				}
				System.out.println();
				
				String winner = in.readLine();
				if(winner.startsWith("win")) {
					System.out.println("Congratulations, " + name + " has won the game with a score of "+ " points!!!!");
					System.out.println("Great game everyone, and thanks for playing. Goodbye.");
					break;
				} else {
					System.out.println(winner);
				}
			}

			out.close();
			in.close();
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
