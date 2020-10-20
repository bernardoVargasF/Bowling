package com.jobsity.greenfield;

import java.util.HashSet;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

import com.jobsity.greenfield.entity.Player;
import com.jobsity.greenfield.game.Game;
import com.jobsity.greenfield.game.GameImpl;
import com.jobsity.greenfield.resources.FileManager;

public class App {
	public static void main(String[] args) {
		int opt = 0;
		Scanner sc = new Scanner(System.in);
		while (opt != 2) {
			System.out.println("Choose an option:");
			System.out.println("1. Get output");
			System.out.println("2. Exit");
			opt = sc.nextInt();
			Game game = new GameImpl();
			HashSet<Player> set = new HashSet<Player>();
			switch (opt) {
			case 1:
				System.out.print("File name: ");
				String fileName = sc.next();
				try {
					FileManager fm = new FileManager();
					List<String> input = fm.readFile(fileName);
					set = game.getInput(input);
					set = game.getPinfalls(set);
					set = game.getScores(set);
					game.printScores(set);
				} catch (IOException exc) {
					System.out.println("Not able to locate file: " + exc.getLocalizedMessage());
				}
				break;
			case 2:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Unknown choice");

			}
		}
		sc.close();
	}
}
