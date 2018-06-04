package com.lastminute.fpapi.salestaxes.data.factory.typing;

import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;

public interface ItemTypeStrategy {
	
	public Category assignCategory(String printableName);
	
	public Origin assignOrigin(String printableName);

}
