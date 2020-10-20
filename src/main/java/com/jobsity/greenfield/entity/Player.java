package com.jobsity.greenfield.entity;

import java.util.Arrays;
import java.util.List;

public class Player {
	private String name;
	private List<String> inputs;
	private List<String> pinfalls;
	private List<Integer> scores;
	
	public Player() {
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, List<String> inputs) {
		super();
		this.name = name;
		this.inputs = inputs;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getInputs() {
		return inputs;
	}

	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}

	public List<String> getPinfalls() {
		return pinfalls;
	}

	public void setPinfalls(List<String> pinfalls) {
		this.pinfalls = pinfalls;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return this.name + Arrays.toString(inputs.toArray());
	}
}
