package com.jobsity.greenfield.game;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import com.jobsity.greenfield.entity.Player;

public class GameImpl implements Game {

	@Override
	public HashSet<Player> getInput(List<String> fileContent) {
		Map<String, List<String>> players = new HashMap<String, List<String>>();
		for(String row : fileContent) {
			String[] data = row.split("\\s+");
			String name = data[0];
			String input = data[1];
			
			List<String> inputs = new ArrayList<String>();
			if(!players.containsKey(name)) {
				inputs.add(input);
				players.put(name, inputs);
			}else {
				inputs = players.get(name);
				inputs.add(input);
				players.replace(name, inputs);
			}	
		}
		HashSet<Player> playersInputs = new HashSet<>();
		for(Map.Entry<String, List<String>> entry : players.entrySet()) {
			Player player = new Player(entry.getKey(), entry.getValue());
			playersInputs.add(player);
		}
		// TODO remove getScores
		this.getPinfalls(playersInputs);
		
		return playersInputs;
	}

	@Override
	public HashSet<Player> getPinfalls(HashSet<Player> playersInput) {
		HashSet<Player> pinfallsSet = new HashSet<Player>();
		
		for(Player player : playersInput) {
			List<String> inputs = player.getInputs();
			List<String> pinfalls = new ArrayList<String>();
			
			for(int i = 0; i < inputs.size(); i++) { // 20x
				String pinfall = inputs.get(i);
				int prevCount = 0;
				int currentCount = pinfall.equals("F")? 0 : Integer.parseInt(pinfall);
				if(pinfall.equals("10")) {
					if(pinfalls.size() < 18) pinfalls.add(" ");
					pinfalls.add("X");
				}else {
					if(i != 0) {
						int pos = i - 1;
						prevCount = inputs.get(pos).equals("F")? 0 : Integer.parseInt(inputs.get(pos));
					}
					if(prevCount + currentCount == 10) {
						pinfalls.add("/");
					} else {
						pinfalls.add(pinfall);
					}
				}
			}
			player.setPinfalls(pinfalls);
			pinfallsSet.add(player);
			System.out.println("Pinfalls " + player.getName() + ": " + Arrays.toString(pinfalls.toArray()));
		}
		// TODO remove getScores
		this.getScores(pinfallsSet);
		return pinfallsSet;
	}
	
	public HashSet<Player> getScores(HashSet<Player> playersPinfalls) {
		HashSet<Player> scoresSet = new HashSet<Player>();
				
		for(Player player : playersPinfalls) {
			List<String> inputs = player.getPinfalls();
			List<Integer> totalScores = new ArrayList<Integer>();
			for(int i = 0; i < inputs.size(); i++) { // 21x
				
				String pinfall = inputs.get(i);
				int currentScore = 0;
				int prev = 0;
				if(i > 0) {
					prev = i - 1;
				}
				
				if(pinfall.chars().allMatch(Character::isDigit)) { //its a number
					currentScore = Integer.parseInt(pinfall);
				}else {
					currentScore = pinfall.equals(" ")? 0 :
									pinfall.equals("F")? 0 :
									pinfall.equals("X")? 10 :
									10 - totalScores.get(prev); // pinfall.equals("/")?
				}
				
				totalScores.add(currentScore);
			
			}
			List<Integer> finalScore = new ArrayList<Integer>();
			int pos = -1;
			for(int j = 0; j < totalScores.size() ; j++) {
				int prev = 0;
				int score = 0;
				int sumSpare = j + 1;
				int sumStrike = j + 2;
				if(j > 0 && j % 2 != 0) {
					prev = j - 1;
					if(totalScores.get(j) == 10) {		//Strike
						int strike = 10;
						if(totalScores.get(sumStrike) == 10) strike = 20;
						
						score = strike + totalScores.get(sumSpare) + totalScores.get(sumStrike);
					}else if(totalScores.get(prev) + totalScores.get(j) == 10) {
						score = 10 + totalScores.get(sumSpare);
					}else {
						score = totalScores.get(j) + totalScores.get(prev);
					}
					if(pos == -1) {
						finalScore.add(score);
					}else {
						int sum = score + finalScore.get(pos);
						finalScore.add(sum);
					}
					pos++;
				}
			}
			player.setScores(finalScore);
			scoresSet.add(player);
			System.out.println("Final Scores: " + Arrays.toString(finalScore.toArray()));
		}
		this.printScores(scoresSet);
		
		return scoresSet;
	}
	
	@Override
	public void printScores(HashSet<Player> game) {
		System.out.println("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
		for(Player player : game) {
			// Avoid O(n²)
			System.out.println(player.getName());
			System.out.print("Pinfalls\t");
			System.out.print(player.getPinfalls().get(0) + "\t");
			System.out.print(player.getPinfalls().get(1) + "\t");
			System.out.print(player.getPinfalls().get(2) + "\t");
			System.out.print(player.getPinfalls().get(3) + "\t");
			System.out.print(player.getPinfalls().get(4) + "\t");
			System.out.print(player.getPinfalls().get(5) + "\t");
			System.out.print(player.getPinfalls().get(6) + "\t");
			System.out.print(player.getPinfalls().get(7) + "\t");
			System.out.print(player.getPinfalls().get(8) + "\t");
			System.out.print(player.getPinfalls().get(9) + "\t");
			System.out.print(player.getPinfalls().get(10) + "\t");
			System.out.print(player.getPinfalls().get(11) + "\t");
			System.out.print(player.getPinfalls().get(12) + "\t");
			System.out.print(player.getPinfalls().get(13) + "\t");
			System.out.print(player.getPinfalls().get(14) + "\t");
			System.out.print(player.getPinfalls().get(15) + "\t");
			System.out.print(player.getPinfalls().get(16) + "\t");
			System.out.print(player.getPinfalls().get(17) + "\t");
			System.out.print(player.getPinfalls().get(18) + "\t");
			System.out.print(player.getPinfalls().get(19) + "\t");
			System.out.print(player.getPinfalls().get(20) + "\t");
			System.out.print("\nScore\t\t");
			System.out.print(player.getScores().get(0) + "\t\t");
			System.out.print(player.getScores().get(1) + "\t\t");
			System.out.print(player.getScores().get(2) + "\t\t");
			System.out.print(player.getScores().get(3) + "\t\t");
			System.out.print(player.getScores().get(4) + "\t\t");
			System.out.print(player.getScores().get(5) + "\t\t");
			System.out.print(player.getScores().get(6) + "\t\t");
			System.out.print(player.getScores().get(7) + "\t\t");
			System.out.print(player.getScores().get(8) + "\t\t");
			System.out.print(player.getScores().get(9) + "\t\t");
			System.out.println();
		}
		
	}

}
