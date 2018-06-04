package com.lastminute.fpapi.salestaxes.data.factory.typing;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;

public class ItemTypeDictionary {
	
	private static final Category defaultForCategories = Category.BASIC;
	@SuppressWarnings("serial")
	private static final EnumMap<Category, List<String>> mapForCategories = new EnumMap<Category, List<String>>(Category.class) {
	{
		put(Category.BOOK, Arrays.asList("book"));
		put(Category.FOOD, Arrays.asList("chocolate"));
		put(Category.MEDICAL, Arrays.asList("pills"));
	}};
	
	private static final Origin defaultForOrigins = Origin.NATIONAL;
	@SuppressWarnings("serial")
	private static final EnumMap<Origin, List<String>> mapForOrigins = new EnumMap<Origin, List<String>>(Origin.class) {{
		put(Origin.FOREIGN, Arrays.asList("imported"));
	}};

	public Set<Entry<Category, List<String>>> getCategoriesKeywords() {
		return mapForCategories.entrySet();
	}
	public Category getCategoriesDefault() {
		return defaultForCategories;
	}
	
	public Set<Entry<Origin, List<String>>> getOriginsKeywords() {
		return mapForOrigins.entrySet();
	}
	public Origin getOriginsDefault() {
		return defaultForOrigins;
	}
	
}
