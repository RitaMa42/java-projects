/*
* RockPaperScissors.java
* Author: Yueyue(Rita) Ma
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from anywhere other than the authorized
* sources. I recognize that any unauthorized sharing, assistance,
* or plagiarism will be handled in accordance with both the
* University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based on
* an assignment created by the School of Computing
* at the University of Georgia. Any publishing or posting
* of source code at any time for this project is prohibited.
*/
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//read points to win
		System.out.print("Points to win: ");
		int pointsToWin = Integer.parseInt(keyboard.nextLine());
		
        int userWins = 0;
        int compWins = 0;
        
        // 2) Play until either side reaches points to win
        while (userWins < pointsToWin && compWins < pointsToWin) {
        	
        	//user move
            String userMove = "";
            boolean valid = false;
            while (!valid) {
                System.out.print("Rock, paper, or scissors? ");
                userMove = keyboard.nextLine().trim().toLowerCase();
                if (userMove.equals("rock") || userMove.equals("paper") || userMove.equals("scissors")) {
                    valid = true;
                } else {
                	//loop again
                }
            }
        
            // computer move
            String computerMove = ComputerOpponent.getMove();
         
         
            //round message
            String roundMessage; // "you win!"/"you lose."/"it's a tie."
            if (userMove.equals(computerMove)) {
            	roundMessage = ", so it's a tie. (" + userWins + "-" + compWins + ")";
            } else if (userWinsAgainst(userMove, computerMove)) {
            	userWins++;
            	roundMessage = ", so you win! (" + userWins + "-" + compWins + ")";
            } else {
            	compWins++;
            	roundMessage = ", so you lose. (" + userWins + "-" + compWins + ")";
            }
       
            System.out.println(roundMessage);
            
        }
        
            //final result
            if (userWins == pointsToWin) {
            	System.out.println("Congratulations! You won!");
            } else {
            	System.out.println("Sorry, you lost. Better luck next time!");
            }	
            
            keyboard.close();
        }
	
    	//check if user win
    	private static boolean userWinsAgainst(String user, String comp) {
    		return (user.equals("rock") && comp.equals("scissors"))
    				|| (user.equals("paper") && comp.equals("rock"))
    				|| (user.equals("scissors") && comp.equals("paper"));
    	}
}
