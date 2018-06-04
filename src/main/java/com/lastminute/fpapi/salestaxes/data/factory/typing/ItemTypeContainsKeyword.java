package com.lastminute.fpapi.salestaxes.data.factory.typing;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;

public class ItemTypeContainsKeyword implements ItemTypeStrategy {
	private static final ItemTypeDictionary dictionary = new ItemTypeDictionary();
		
	private static ItemTypeContainsKeyword instance = null;
	public static ItemTypeContainsKeyword getInstance() {
		if (instance == null) {
			instance = new ItemTypeContainsKeyword();
		}
		return instance;
	}

	private ItemTypeContainsKeyword() {};

	@Override
	public Category assignCategory(String printableName) {
		Category assigned = assign(printableName, dictionary.getCategoriesKeywords());
		return assigned != null ? assigned : dictionary.getCategoriesDefault();
	}

	@Override
	public Origin assignOrigin(String printableName) {
		Origin assigned = assign(printableName, dictionary.getOriginsKeywords());
		return assigned != null ? assigned : dictionary.getOriginsDefault();
	}

	private <T> T assign(String printableName, Set<Entry<T, List<String>>> keywords) {
		T assigned = null;
		for (Entry<T, List<String>> category : keywords) {		
			if (printableName.matches(".*("+category.getValue().stream().collect(Collectors.joining("|"))+").*")) {
				assigned = category.getKey();
			}
		}
		return assigned;
	}

}
