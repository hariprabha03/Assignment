/**
 * A class that displays the guess to the user. Then the system prompts the user
 * to enter his response whether the guessed number is higher, lower or correct.
 * Based on users response, the game continues or ends.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */

package com.hari.game;

import java.util.Scanner;

import com.hari.game.GameUtil.ANSWER;

public class NumberGuesser {

	private final Scanner in = new Scanner(System.in);
	
	/**
	 * Plays one game: prompts user to enter a response to the system guess.
	 * If the user confirms the guess, the game ends.
	 * 
	 * @param model
	 */
	public void play(GameModel model) {
		int result = 1;
		
		// keep letting the user guess numbers until the correct number is guessed.
		while (result > 0) {
			model.computeGuess();
			if (model.getGuess() < 0) {
				result = -1;
			} else {
				System.out.printf(GameUtil.GAME_GUESS_MSG, model.getGuess());
				String s = in.nextLine();
				ANSWER answer;
				try {
					answer = Enum.valueOf(ANSWER.class, s.toUpperCase());
				} catch (IllegalArgumentException iae) {
					answer = ANSWER.I;//If the answer is not L, H or C. Setting it to Invalid.
				}
				
				switch (answer) {
				case L:
					model.lower(); //If the guess is lower
					break;
				case H:
					model.higher(); //If the guess is higher
					break;
				case C:
					result = 0; //If the guess is correct
					break;
				default:
					result = -1; //If the user answer is not valid or when user does not give a proper response
					break;
				}
			}
		}
		
		//If result is -1, then Invalid message is shown, else success message is displayed.
		if (result < 0)
			System.out.println(GameUtil.GAME_INVALID_MSG);
		else
			System.out.printf(GameUtil.GAME_SUCCESS_MSG, model.getGuess());
	}
}