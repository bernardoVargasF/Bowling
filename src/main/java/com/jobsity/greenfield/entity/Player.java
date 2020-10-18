package com.jobsity.greenfield.entity;

public class Player {
	private String name;
	private int[] scores;
	
	public Player() {
	}
	
	public Player(String name, int[] scores) {
		this.name = name;
		this.scores = scores;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
