/**
 * A class that holds all the constants and static messages displayed to the user.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */

package com.hari.game;


public class GameUtil {
	
	/**
	 * The lower bound value 
	 */
	public static final int LOWER = 0;

	/**
	 * The upper bound value
	 */
	public static final int UPPER = 100;

	/**
	 * Enum to manage the answers given by the user.
	 */
	public enum ANSWER {
		R, E, H, L, C, I
	};

	/**
	 * Game welcome message when the game is started.
	 */
	public static final String GAME_WELCOME_MSG = "Welcome to the Number guessing game.";

	/**
	 * Game Instructions
	 */
	public static final String GAME_INSTRUCTIONS_1 = "Instructions:\n"
			+ "Think of a number from %d to %d and I will guess it. \n"
			+ "After each guess, you respond with L, H, or C depending\n"
			+ "on if my guess was LOW, HIGH, CORRECT.\n";

	/**
	 * Game Instructions
	 */
	public static final String GAME_INSTRUCTIONS_2 = "\nIf you are READY and wish to continue the game, respond with R.\n"
			+ "To END this game, respond with E.\n" + "Are you Ready?";

	/**
	 * Message displayed when system displays the guess to the user.
	 */
	public static final String GAME_GUESS_MSG = "My guess is: %d. Is it LOW, HIGH or CORRECT? (L/H/C) ";

	/**
	 * Message displayed when the user does not provide proper answer.
	 */
	public static final String GAME_INVALID_MSG = "Sorry, I didn't understand your answer. Please follow the instructions and try again.";

	/**
	 * Message displayed when the system guessed the number.
	 */
	public static final String GAME_SUCCESS_MSG = "Heyyyy!!!! I guessed it right. Your number is %d.\n";

	/**
	 * Message displayed when the game is ended.
	 */
	public static final String GAME_END_MSG = "Thanks for playing the game. Hope you loved it. Good Bye.";

	/**
	 * Displays the introduction of the game to the user
	 */
	public static void displayGameIntro() {
		System.out.println(GAME_WELCOME_MSG);
		System.out.printf(GAME_INSTRUCTIONS_1, GameUtil.LOWER, GameUtil.UPPER);
	}

	/**
	 * Displays the introduction of the game to the user
	 */
	public static void displayGameRules() {
		System.out.println(GAME_INSTRUCTIONS_2);
	}
}
