package com.qa.textAdventure.persistence.domain;

public abstract class Monster {
	protected String name;
	protected int attack;
	protected int defense;
	protected int health;
	
	public void healthLoss(int lostHealth) {
		this.health -=lostHealth;
	}

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

	@Override
	public String toString() {
		return "Monster name:" + name + "\n attack=" + attack + "\n defense=" + defense + "\n health=" + health;
	}
	

}
