package com.qa.textAdventure.persistence.domain.locations;

import com.qa.textAdventure.persistence.domain.Item;
import com.qa.textAdventure.persistence.domain.Location;
import com.qa.textAdventure.persistence.domain.Monster;

public class EndLocation extends Location{
	


	public EndLocation() {
		super();
		this.name = "Den";
		this.monster=null;
		this.item=null;
		this.discovered=false;
	}

}
