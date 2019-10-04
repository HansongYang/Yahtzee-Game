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
			while(true) {
				String ss = in.readLine();
				if(ss == null){
					continue;
				}
				if(ss.endsWith("starts") && ss.startsWith(name)) {
					break;
				}
			}
			
			while (true) {
				out.println("board"+name);
				String board = "";
				while ((board = in.readLine()) != null) {
					System.out.println(board);
					if(in.read() == 0) {
						break;
					}
				}
				
				System.out.println("\nPress r to roll the dice ...");
				String userInput = "";
				while(true) {
					userInput = scan.nextLine();
					if(!userInput.isEmpty()) {
						if(userInput.charAt(0) == 'r') {
							out.println("rollAll"+name);
							break;
						} else {
							System.out.println("Invalid input, please enter again.");
						}
					}
				}
		
				String dice = "";
				boolean first = true;
				while ((dice = in.readLine()) != null) {
					if(!dice.startsWith(name) && first) {
						first = false;
						break;
					}
					System.out.print(dice);
					if(in.read() == 0) {
						break;
					}
				}
				System.out.println('\n');
				
				first = true;
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
						out.println("rollSome " + userInput+name);
						roll++;
					} else if (input == 2) {
						out.println("rollAll"+name);
						roll++;
					} else if (input == 3) {
						while(true) {
							System.out.println("What category do you want to score this round against? (Please enter the category number)");
							input = scan.nextInt();
							if(input < 1 || input > 13) {
								System.out.println("Invalid option, please enter again.");
								continue;
							}
							out.println("score " + input + " " + name);
							String valid = in.readLine();
							if(valid.startsWith(name) && valid.endsWith("invalid")) {
								System.out.println("Sorry, you have already scored this category. Please choose again. \n");
							}else if(valid.startsWith(name) && valid.endsWith("valid")) {
								break;
							}
						}
						break;
					} else {
						System.out.println("Invalid Input. Please enter again.");
						continue;
					}
					
					while (first && (dice = in.readLine()) != null) {
						if(!dice.startsWith(name)) {
							first = false;
							break;
						}
						System.out.print(dice);
						if(in.read() == 0) {
							break;
						}
					}
					System.out.println('\n');
					
					if(roll == 3) {
						while(true) {
							System.out.println("What category do you want to score this round against? (Please enter the category number)");
							input = scan.nextInt();
							if(input < 1 || input > 13) {
								System.out.println("Invalid option, please enter again.");
								continue;
							}
							out.println("score " + input + " " + name);
							String valid = in.readLine();
							if(valid.startsWith(name) && valid.endsWith("invalid")) {
								System.out.println("Sorry, you have already scored this category. Please choose again. \n");
							}else if(valid.startsWith(name) && valid.endsWith("valid")) {
								break;
							}
						}
						break;
					}
				}
				System.out.println();
				
				String winner = in.readLine();
				if(winner.startsWith("win")) {
					String [] win = winner.split(" ");
					if(win[1].equals(name)) {
						System.out.println("Congratulations, you have won the game with a score of "+ win[2] + " points!!!!");
						System.out.println("Great game everyone, and thanks for playing. Goodbye.");
					} else {
						System.out.println("You've lost the game, " + win[1] + " has won the game with a score of "+ win[2] + " points!!!!");
						System.out.println("Great game everyone, and thanks for playing. Goodbye.");
					}
					break;
				} else if(winner.endsWith("wait")) {
					System.out.println("Waiting for other players to play their turn.\n");
					while(true) {
						String s = in.readLine();
						if (s.startsWith("win")) {
							String [] win = s.split(" ");
							if(win[1].equals(name)) {
								System.out.println("Congratulations, you have won the game with a score of "+ win[2] + " points!!!!");
								System.out.println("Great game everyone, and thanks for playing. Goodbye.");
							} else {
								System.out.println("You've lost the game, " + win[1] + " has won the game with a score of "+ win[2] + " points!!!!");
								System.out.println("Great game everyone, and thanks for playing. Goodbye.");
							}
							System.exit(0);
						}
						
						if(s.endsWith("continue") && s.startsWith(name)){
							break;
						}
					}
				}
			}

			out.close();
			in.close();
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean userActionChecker(int option) {
		if(option >= 1 && option <=3) {
			return true;
		}
		return false;
	}
}
