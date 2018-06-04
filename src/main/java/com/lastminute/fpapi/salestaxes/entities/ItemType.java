package com.lastminute.fpapi.salestaxes.entities;

import com.lastminute.fpapi.salestaxes.entities.charges.Category;
import com.lastminute.fpapi.salestaxes.entities.charges.Origin;

public class ItemType {
	
	private Category goodsType;
	private Origin goodsOrigin;
	
	public Category getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Category goodsType) {
		this.goodsType = goodsType;
	}
	public Origin getGoodsOrigin() {
		return goodsOrigin;
	}
	public void setGoodsOrigin(Origin goodsOrigin) {
		this.goodsOrigin = goodsOrigin;
	}
	
	@Override
	public String toString() {
		return String.format("ItemType [goodsType=%s, goodsOrigin=%s]", goodsType, goodsOrigin);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsOrigin == null) ? 0 : goodsOrigin.hashCode());
		result = prime * result + ((goodsType == null) ? 0 : goodsType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemType other = (ItemType) obj;
		if (goodsOrigin != other.goodsOrigin)
			return false;
		if (goodsType != other.goodsType)
			return false;
		return true;
	}

}
