package com.qa.textAdventure.persistence.domain.locations;

import com.qa.textAdventure.persistence.domain.Location;
import com.qa.textAdventure.persistence.domain.items.HealthPotion;
import com.qa.textAdventure.persistence.domain.monsters.TrollMonster;

public class SwampLocation extends Location{
	

	public SwampLocation() {
		super();
		this.name = "Swamp";
		this.monster= new TrollMonster();
		this.item=new HealthPotion();
		this.discovered=false;
	}
	

}
