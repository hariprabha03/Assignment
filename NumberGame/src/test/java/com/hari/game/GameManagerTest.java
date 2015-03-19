/**
 * A class that contains all the unit tests required to test the GameManager class.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */
package com.hari.game;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hari.game.GameUtil.ANSWER;

public class GameManagerTest {
	NumberGuesser nGuesser;
	GameModel gModel; 
    
    @Before() 
    public void setUp(){
    	gModel = new GameModel(GameUtil.LOWER, GameUtil.UPPER);
    	nGuesser = new NumberGuesser();
    }
    
    @After
    public void tearDown() {
    	gModel = null;
    	nGuesser = null;
    }
     
    /**
     * Tests whether the invalid message is displayed to the user
     * when the user gives an asnwer other than "R"(Ready) or "E"(End).
     */
    @Test  
    public void testResponse(){
    	System.out.println("\n**********Testing testInvalidResponse()*********");
    	String s;
		
		boolean playAgain = true;
		String message = null;
		// keep playing games as long as the user wants to play
		do {
			GameUtil.displayGameRules();
			s = "N";//Setting the answer to a Invalid value
			System.out.println("Answer is set to 'N' which is invalid...");
			ANSWER answer;
			try {
				answer = Enum.valueOf(ANSWER.class, s.toUpperCase());
			} catch (IllegalArgumentException iae) {
				answer = ANSWER.I;//If the answer is not R or E, setting it to Invalid.
			}
			switch (answer) {
			case R:
				gModel.reset();//reset game values to start a new game.
				nGuesser.play(gModel);// the game is started here
				break;
			case E:
				playAgain = false;
				break;
			default:
				playAgain = false;
				message = GameUtil.GAME_INVALID_MSG;
				System.out.println(GameUtil.GAME_INVALID_MSG);
			}
		} while (playAgain);
		assertTrue(GameUtil.GAME_INVALID_MSG.equals(message));
    }  
    
    @Test
    public void testResponseForAnswerReady(){
    	//TODO
    }
    
    @Test
    public void testResponseForAnswerEnd(){
    	//TODO
    }
}
