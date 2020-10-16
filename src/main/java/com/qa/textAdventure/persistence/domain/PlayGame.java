package com.qa.textAdventure.persistence.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.qa.textAdventure.utils.Utils;

public class PlayGame {
//	public static final Logger LOGGER = LogManager.getLogger();
	private final Utils utils;
	private Map map;
	private Character character;
	private Boolean complete;
	private Pair<Integer, Integer> mapLocation;
	private Pair<Integer, Integer> endLocation;
	private Boolean win;

	public PlayGame() {
		this.utils = new Utils();
		this.map = new Map();
		this.mapLocation = this.map.getStart();
		this.endLocation = this.map.getEnd();
		this.complete = false;
		this.win = false;
		initCharacter();
		System.out.println(
				"Your adventure Starts in TxtVenture Land. " + "\nYou must find the golden Treasure at the Dragons Den."
						+ "\nFight Monsters and Find items to improve your power before the final battle.");
	}

	public void turn() {
		this.map.showMap(mapLocation);
		Location here = map.getLocation(mapLocation);
		System.out.println("You are in a " + here.getName());
		Monster monsterHere = here.getMonster();
		Item itemHere = here.getItem();
		if (monsterHere!=null) {
			System.out.println("you have encountered a" + monsterHere.getName());
			attack(monsterHere);
		}
		if (!this.complete) {
			if (itemHere!=null) {
				System.out.println("you have found a " + itemHere.getName());
				gainItem(itemHere);
			}
			navigate(mapLocation);

		} else {
		}

	}

	public Boolean isComplete() {
		return complete;
	}

	private void initCharacter() {
		int statPoints = 5;
		System.out.println("Please enter a name");
		String name = utils.getString();
		this.character = new Character(name);
		addStats(statPoints);
	}

	private void addStats(int statPoints) {
		int pointsToAdd = statPoints;
		System.out.println("Your Charcter is:\n" + this.character.toString());
		while (pointsToAdd > 0) {
			System.out.println("\n\n You have " + pointsToAdd + " stat points to add");
			System.out.println("Add these to HEALTH[+10],ATTACK[+1] or DEFENSE[+1]");
			String stat = utils.getString();
			if (stat.equals("HEALTH")) {
				this.character.addHealth();
				pointsToAdd -= 1;
			} else if (stat.equals("ATTACK")) {
				this.character.addAttack();
				pointsToAdd -= 1;
			} else if (stat.equals("DEFENSE")) {
				this.character.addDefense();
				pointsToAdd -= 1;
			} else {
				System.out.println("Please select HEALTH[+10],ATTACK[+1] or DEFENSE[+1]");
			}
		}
		System.out.println("Your Charcter is:\n" + this.character.toString());

	}

	private void attack(Monster monster) {
		System.out.println(this.character.toString());
		System.out.println(monster.toString());
		Boolean victory = false;
		int MonsterHealthLoss;
		int CharacterHealthLoss;
		while (monster.getHealth() > 0 && this.character.getHealth() > 0) {
			System.out.println("You attack with" + this.character.getAttack() + "ATTACK. The monster defends with"
					+ monster.getDefense() + "DEFENSE.");
			if (this.character.getAttack() > monster.getDefense()) {
				MonsterHealthLoss = character.getAttack() + 5 - monster.getDefense();
			} else {
				MonsterHealthLoss = 5;
			}
			System.out.println("The monster losses " + MonsterHealthLoss + " Health");
			monster.healthLoss(MonsterHealthLoss);
			System.out.println(monster.toString());
			if (monster.getHealth() <= 0) {
				victory = true;
				continue;
			}

			System.out.println("The monster attacks with" + monster.getAttack() + "ATTACK. You defend with"
					+ this.character.getDefense() + "DEFENSE.");
			if (monster.getAttack() > this.character.getDefense()) {
				CharacterHealthLoss = character.getAttack() + 3 - monster.getDefense();
			} else {
				CharacterHealthLoss = 3;
			}
			System.out.println("You lose " + CharacterHealthLoss + " Health");
			this.character.healthLoss(CharacterHealthLoss);
			System.out.println(this.character.toString());
		}
		if (!victory) {
			System.out.println("The monster has defeated you! Your journey is over.");
			this.complete = true;
		} else {
			System.out.println("You have defeated the monster! You have levelled up and gained 3 stat points!");
			this.character.levelUp();
			addStats(3);
		}

	}

	public void gainItem(Item item) {
		System.out.println("You use the item to gain" + item.gain());
		this.character.gainItem(item);
		System.out.println(this.character.toString());
	}

	public void navigate(Pair<Integer, Integer> mapLocation) {
		System.out.println("You have completed this area");
		Boolean moved = false;
		System.out.println("Which direction will you like to move NORTH, SOUTH, EAST or WEST?");
		this.map.showMap(mapLocation);
		while (!moved) {
			String direction = utils.getString();
			if (direction.equals("NORTH")) {
				this.mapLocation = new Pair<Integer, Integer>(this.mapLocation.left + 1, this.mapLocation.right);
			} else if (direction.equals("SOUTH")) {
				this.mapLocation = new Pair<Integer, Integer>(this.mapLocation.left - 1, this.mapLocation.right);

			} else if (direction.equals("EAST")) {
				this.mapLocation = new Pair<Integer, Integer>(this.mapLocation.left, this.mapLocation.right + 1);

			} else if (direction.equals( "WEST")) {
				this.mapLocation = new Pair<Integer, Integer>(this.mapLocation.left, this.mapLocation.right - 1);

			} else {
				System.out.println("Please select NORTH, SOUTH, EAST or WEST.");
			}
		}
	}

}
