/**
 * A class that combines all the Game Test classes into a suite.
 *  
 * @author  Hari
 * @version 1.0, 03/18/2015
 */package com.hari.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	GameManagerTest.class,
	GameModelTest.class
})
public class GameTestSuite {   
}  	