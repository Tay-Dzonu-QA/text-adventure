package com.qa.textAdventure.persistence.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Character {

	
	private String name;
	private int attack;
	private int defense;
	private int health;
	
	private int level;
	
	public Character(String name) {
		this.level = 1;
		this.name=name;
		this.attack = 10;
		this.defense = 10;
		this.health = 100;
	}
	public void healthLoss(int lostHealth) {
		this.health =-lostHealth;
	}
	
	public void addHealth() {
		this.health+=10;
	}
	public void addAttack() {
		this.attack+=1;
	}
	public void addDefense() {
		this.defense+=1;
	}
	public int getAttack() {
		return attack;
	}
	public void levelUp() {
		this.level+=1;
	}
	
	public void gainItem(Item item) {
		this.attack+=item.getAttack();
		this.defense+=item.getDefense();
		this.health+=item.getHealth();
	}


	public int getDefense() {
		return defense;
	}


	public int getHealth() {
		return health;
	}



	@Override
	public String toString() {
		return "Character name:" + name + "\n level=" + level +"\n attack=" + attack + "\n defense=" + defense + "\n health=" + health;
	}
	
	

}
