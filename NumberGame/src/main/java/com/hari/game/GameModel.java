/**
 * A class that handles the data and the game rules.
 * Computes the lower and higher value based on users answer 
 * Generates a guess based on the lower and the higher range.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */

package com.hari.game;

public class GameModel {

	/**
	 * The lower bound value 
	 */
	private int lowerVal;
	
	/**
	 * The upper bound value 
	 */
	private int upperVal;
	
	/**
	 * The guess
	 */
	private int guess;

	/**
	 * Initialize class variables to starting values, no games yet.
	 * @param lower the lower bound value
	 * @param upper the upper bound value
	 */
	public GameModel(int lower, int upper) {
		this.lowerVal = lower;
		this.upperVal = upper;
	}

	/**
	 * @return the guess computed by the system
	 */
	public int getGuess() {
		return guess;
	}

	/**
	 * Computes the lower bound value when the user says 
	 * that the current guess is lower.
	 */
	public void lower() {
		lowerVal = getGuess() + 1;
	}

	/**
	 * Computes the higher bound value when the user says 
	 * that the current guess is higher.
	 */
	public void higher() {
		upperVal = getGuess() - 1;
	}

	/**
	 * Computes the guess from the lower and the higher bound values 
	 * using binary search algorithm. If the answer given by the user is not valid,
	 * then the guess is set to -1.
	 */
	public void computeGuess() {
		if (isValidAnswer()){
			this.guess = ((upperVal - lowerVal) / 2) + lowerVal;		
		} else {
			this.guess = -1;
		}
	}

	/**
	 * Resets the lower and the upper bound value when user starts a new game.
	 */
	public void reset() {
		lowerVal = GameUtil.LOWER;
		upperVal = GameUtil.UPPER;
	}
	
	/**
	 * @return the flag which indicates whether the user response is valid 
	 * based on the current lower and the upper bound value.
	 * If the user does not respond to the guess properly whether the guess is 
	 * higher or lower or correct, then the answer is considered as invalid.
	 * If the user response to the system guess is not relevant, then this
	 * method returns false. Else the method returns true.
	 */
	public boolean isValidAnswer(){
		boolean isValid = true;
		
		if (this.lowerVal > GameUtil.UPPER || this.upperVal < GameUtil.LOWER
				|| this.lowerVal > this.upperVal || this.upperVal < this.lowerVal) {
			isValid = false  ;
		} 
		return isValid;
	}
}