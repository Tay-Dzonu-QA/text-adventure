package com.qa.textAdventure.persistence.domain;

public abstract class Location {

	protected String name;
	protected Monster monster;
	protected Item item;

	protected Boolean discovered;

	public String getName() {
		if (discovered) {
			return name;
		} else {
			return "??? ";
		}
	}

	public Monster getMonster() {
		return monster;
	}


	public Item getItem() {
		return item;
	}
	public void discovered() {
		this.discovered=true;
	}


	
	

}
