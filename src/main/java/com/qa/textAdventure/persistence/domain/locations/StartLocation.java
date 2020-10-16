package com.qa.textAdventure.persistence.domain.locations;

import com.qa.textAdventure.persistence.domain.Location;
import com.qa.textAdventure.persistence.domain.items.HealthPotion;
import com.qa.textAdventure.persistence.domain.monsters.TrollMonster;

public class StartLocation extends Location {


	public StartLocation() {
		super();
		this.name = "camp";
		this.monster=null;
		this.item=null;
		this.discovered=true;
	}

}
