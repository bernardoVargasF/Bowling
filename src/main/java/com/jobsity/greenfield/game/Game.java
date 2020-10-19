package com.jobsity.greenfield.game;

import java.util.HashSet;
import java.util.List;

import com.jobsity.greenfield.entity.Player;

public interface Game {
	
	public HashSet<Player> getInput(List<String> fileContent);
		
	public HashSet<Player> getPinfalls(HashSet<Player> playersInputs);

	public HashSet<Player> getScores(HashSet<Player> playersPinfalls);
	
	public void printScores(HashSet<Player> game);

}
