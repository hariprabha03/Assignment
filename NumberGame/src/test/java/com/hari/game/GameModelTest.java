/**
 * A class that contains all the unit tests required to test the GameModel class.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */
package com.hari.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hari.game.GameModel;
import com.hari.game.GameUtil;
  
public class GameModelTest {  
	
	GameModel gModelTest; //an instance of the GameModel class to test
    
    @Before() 
    public void setUp(){
    	gModelTest = new GameModel(GameUtil.LOWER, GameUtil.UPPER);
    }
    
    @After
    public void tearDown() {
    	gModelTest = null;
    }
     
    /**
     * Precondition: A new game is started. User says he is ready to start the game.
     * Tests whether the first guess made by the system is between the range 0 and 100.
     */
    @Test  
    public void testFirstGuess(){
    	System.out.println("\n**********Testing testFirstGuess()*********");
    	gModelTest.computeGuess();
    	System.out.println("The first guess for the range "
    			+ ""+GameUtil.LOWER+" - "+GameUtil.UPPER+ " is: "+gModelTest.getGuess());
    	assertTrue(gModelTest.getGuess() > GameUtil.LOWER && gModelTest.getGuess() < GameUtil.UPPER);
    }  
    
    
    /**
     * Precondition: User says the current guess is lower that the number he have in mind.
     * Tests whether the guess generated is higher than the previous guess.
     */
    @Test  
    public void testGuessForAnswerLower(){
    	System.out.println("\n**********Testing testGuessForAnswerLower()*********");
    	gModelTest.computeGuess();
    	int prevGuess = gModelTest.getGuess();
    	System.out.println("Previous guess: "+prevGuess);
        gModelTest.lower();
    	gModelTest.computeGuess();
    	System.out.println("Current guess after the user says the previous guess is lower: "+gModelTest.getGuess());
        
    	assertTrue(gModelTest.getGuess() > prevGuess);
    }  
    
    /**
     * Precondition: User says the current guess is higher that the number he have in mind.
     * Tests whether the guess generated is lower than the previous guess.
     */
    @Test  
    public void testGuessForAnswerHigher(){
    	System.out.println("\n**********Testing testGuessForAnswerHigher()*********");
    	gModelTest.computeGuess();
    	int prevGuess = gModelTest.getGuess();
    	System.out.println("Previous guess: "+prevGuess);
        gModelTest.higher();
    	gModelTest.computeGuess();
    	System.out.println("Current guess after the user says "
    			+ "the previous guess is higher: "+gModelTest.getGuess());
        assertTrue(gModelTest.getGuess() < prevGuess);
    }  
    
    /**
     * Precondition: User does not provide proper answer when asked for guess is H/L/C. 
     * User says the guess is higher even though the guess is lower than the number he have in mind. 
     * 
     * Tests whether Invalid message is shown when user does not provide proper answer. 
     */
    @Test  
    public void testGuessForInvalidAnswerHigh(){
    	System.out.println("\n**********Testing testGuessForInvalidAnswerLow()*********");
    	gModelTest = new GameModel(0, -1);
    	gModelTest.computeGuess();
    	System.out.println("User does not provide proper answer and says the "
    			+ "guess is low which is out of range. Guess generated is::: "+gModelTest.getGuess());
        assertEquals(-1,gModelTest.getGuess());
    }  
    
    /**
     * Precondition: User does not provide proper answer when asked for guess is H/L/C. 
     * User says the guess is lower even though the guess is higher than the number he have in mind. 
     * 
     * Tests whether Invalid message is shown when user does not provide proper answer. 
     */
    @Test  
    public void testGuessForInvalidAnswerLow(){
    	System.out.println("\n**********Testing testGuessForInvalidAnswerHigh()*********");
    	gModelTest = new GameModel(101, 100);
    	gModelTest.computeGuess();
    	System.out.println("User does not provide proper answer and says the "
    			+ "guess is high which is out of range. Guess generated is::: "+gModelTest.getGuess());
        assertEquals(-1,gModelTest.getGuess());
    }
}  
