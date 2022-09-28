package com.infinite.inventory_management;

public class Stock {
	private String stockId;
	private String itemName;
	private double price;
	private int quatityAvail;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String stockId, String itemName, double price, int quatityAvail) {
		super();
		this.stockId = stockId;
		this.itemName = itemName;
		this.price = price;
		this.quatityAvail = quatityAvail;
	}

	@Override
	public String toString() {
		return "Inventory [stockId=" + stockId + ", itemName=" + itemName + ", price=" + price + ", quatityAvail="
				+ quatityAvail + "]";
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuatityAvail() {
		return quatityAvail;
	}

	public void setQuatityAvail(int quatityAvail) {
		this.quatityAvail = quatityAvail;
	}
}
