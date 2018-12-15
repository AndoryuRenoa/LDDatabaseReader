package com.mochijump.types;

import java.math.BigDecimal;
import java.util.Date;

public class BarcodeResponse {
	
	private String item;
	private BigDecimal lastCost;
	private BigDecimal availableInventory;
	private Date lastReceivedDate;
	private String unitType;
	private Long unitMultiplier;
	private String itemNo;
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public BigDecimal getLastCost() {
		return lastCost;
	}
	public void setLastCost(BigDecimal lastCost) {
		this.lastCost = lastCost;
	}
	public BigDecimal getAvailableInventory() {
		return availableInventory;
	}
	public void setAvailableInventory(BigDecimal availableInventory) {
		this.availableInventory = availableInventory;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public Long getUnitMultiplier() {
		return unitMultiplier;
	}
	public void setUnitMultiplier(Long unitMultiplier) {
		this.unitMultiplier = unitMultiplier;
	}
	public Date getLastReceivedDate() {
		return lastReceivedDate;
	}
	public void setLastReceivedDate(Date lastReceivedDate) {
		this.lastReceivedDate = lastReceivedDate;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

}
