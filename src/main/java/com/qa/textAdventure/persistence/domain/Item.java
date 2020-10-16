package com.qa.textAdventure.persistence.domain;

public class Item {
	protected String name;
	protected int attack;
	protected int defense;
	protected int health;
	
	public String getName() {
		return name;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}

	public int getHealth() {
		return health;
	}
	
	public String gain() {
		if(this.attack>0) {
			return this.attack +" ATTACK";
		}else if(this.defense>0) {
			return this.defense +" DEFENSE";
		}else if(this.health>0) {
			return this.health +" HEALTH";
		}else {
			return "NOTHING";
		}
	}
	
	

}
