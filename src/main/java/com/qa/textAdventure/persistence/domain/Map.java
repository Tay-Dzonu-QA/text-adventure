package com.qa.textAdventure.persistence.domain;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.qa.textAdventure.persistence.domain.locations.EndLocation;
import com.qa.textAdventure.persistence.domain.locations.StartLocation;
import com.qa.textAdventure.persistence.domain.locations.SwampLocation;

public class Map {
	public static final Logger LOGGER = LogManager.getLogger();

	private Pair<Integer, Integer> start;
	private Pair<Integer, Integer> end;
	private Location[][] gameMap = new Location[10][10];

	public Map() {
		Random rn = new Random();
		start = new Pair<Integer, Integer>(rn.nextInt(10), rn.nextInt(10));
		do {
			end = new Pair<Integer, Integer>(rn.nextInt(10), rn.nextInt(10));
		} while (start.equals(end));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (start.left == i && start.right == j) {
					gameMap[i][j] = new StartLocation();
				} else if (end.left == i && end.right == j) {
					gameMap[i][j] = new EndLocation();
				} else {
					gameMap[i][j] = new SwampLocation();
				}
			}
		}

	}

	public void showMap(Pair<Integer, Integer> location) {
		String grid = "         1       2       3       4       5       6       7       8      9      10 ";
		System.out.println(grid + "\n\n");
		String barrier = "     ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
		String next = "     ||      ||      ||      ||      ||      ||      ||      ||      ||      ||      ||";
		String begin = "|| ";
		String mid = " || ";
		String end = " ||";
		for (int i = 0; i < 10; i++) {
			System.out.print(barrier + "\n" + next + "\n");
			System.out.print("  " + i + "  " + begin); 
			for (int j = 0; j < 10; j++) {
				if (j == 8) {
					System.out.print(gameMap[i][j].getName() + end);
				} else {
					System.out.print(gameMap[i][j].getName() + mid);
				}
			}

			System.out.print("\n" + next + "\n");
		}
		System.out.print(barrier + "\n");

	}

	public Pair<Integer, Integer> getStart() {
		return start;
	}

	public Pair<Integer, Integer> getEnd() {
		return end;
	}
	public Location getLocation(Pair<Integer, Integer> here) {
		return gameMap[here.left][here.right];
	}


	
}
