package com.qa.textAdventure;

import com.qa.textAdventure.persistence.domain.PlayGame;

public class TextAdventure {
	private final PlayGame game;

	public TextAdventure() {
		this.game = new PlayGame();
	}

	public void textAdventureSystem() {

		while (!game.isComplete()) {
			game.turn();
		}

	}
	public Boolean playAgain() {
		return false;
	}

}
