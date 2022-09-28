package com.infinite.inventory_management;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchStockMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String stockId;
		System.out.println("Enter Stock ID: ");
		stockId = scanner.next();
		scanner.close();
		
		StockDAO dao = new StockDAO();
		try {
			Stock stockDetails = dao.searchStockDAO(stockId);
			if (stockDetails != null) {
				System.out.println(stockDetails);
			}else {
				System.out.println("NO Record Found.");
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
