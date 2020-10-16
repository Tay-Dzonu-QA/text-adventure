package com.qa.textAdventure;

public class Runner {

	public static void main(String[] args) {
		Boolean playAgain = true;

		while (playAgain) {
			TextAdventure textAdventure = new TextAdventure();
			textAdventure.textAdventureSystem();
			playAgain=textAdventure.playAgain();
		}
	}

}
