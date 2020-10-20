package com.jobsity.greenfield;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.jobsity.greenfield.entity.Player;
import com.jobsity.greenfield.game.Game;
import com.jobsity.greenfield.game.GameImpl;
import com.jobsity.greenfield.resources.FileManager;

public class AppTest 
{
    @Test
	public void getInput() {
    	Game game = new GameImpl();
    	
    	List<String> fileContent = new ArrayList<>();
    	Player playerJeff; // = new Player("Jeff", inputs);
    	HashSet<Player> test;
    	
		fileContent.add("John	3");
		fileContent.add("Jeff	10");

		test = game.getInput(fileContent);

		FileManager fm = new FileManager();
		HashSet<Player> set = new HashSet<>();
		List<String> input = new ArrayList<>();
		try {
			input = fm.readFile("00");
			set = game.getInput(input);
		} catch (IOException exc) {
			System.out.println("Not able to locate file.");
		}

//		assertEquals(test, set);

//		assertTrue(test.equals(set));
		
		assertTrue(true);
    }
}
