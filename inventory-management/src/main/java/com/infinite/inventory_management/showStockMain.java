package com.infinite.inventory_management;

import java.sql.SQLException;

public class showStockMain {
	public static void main(String[] args) {
		StockDAO dao = new StockDAO();
		try {
			for (Stock stock : dao.showStock()) {
				System.out.println(stock);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
