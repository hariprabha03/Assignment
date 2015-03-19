/**
 * A class that manages the game. Displays the game introduction and the rules to
 * the user. Initiates the game when the user is ready to play. 
 *
 * Play simple guessing games with a user. 
 * The user chooses a number in his mind and says ready to indicate to the computer 
 * that he is ready to begin playing. The computer asks a series of questions to arrive 
 * at the number the user has in mind.  The user responds with “higher”, “lower” or “yes”. 
 * The game ends when the user responds with “yes” or “end”.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */

package com.hari.game;

import java.util.Scanner;
import com.hari.game.GameUtil.ANSWER;

public class GameManager {
	private static Scanner in;
	
	/**
	 * Allow the user to play as many number guessing games as desired. Consists
	 * of displaying game introduction and rules, starting the game when user says ready. 
	 */
	public static void main(String args[]) {
		GameUtil.displayGameIntro();
		GameManager manager = new GameManager();
		manager.run();
	}
	
	public void run(){
		NumberGuesser guesser = new NumberGuesser();
		GameModel model = new GameModel(GameUtil.LOWER, GameUtil.UPPER);
		String s;
		in = new Scanner(System.in);
		
		boolean playAgain = true;
		// keep playing games as long as the user wants to play
		do {
			GameUtil.displayGameRules();
			s = in.next();
			System.out.println();
			ANSWER answer;
			try {
				answer = Enum.valueOf(ANSWER.class, s.toUpperCase());
			} catch (IllegalArgumentException iae) {
				answer = ANSWER.I;//If the answer is not R or E, setting it to Invalid.
			}
			switch (answer) {
			case R:
				model.reset();//reset game values to start a new game.
				guesser.play(model);// the game is started here
				break;
			case E:
				playAgain = false;
				break;
			default:
				playAgain = false;
				System.out.println(GameUtil.GAME_INVALID_MSG);
			}
		} while (playAgain);
		System.out.println(GameUtil.GAME_END_MSG);//Game ends
	}
}
