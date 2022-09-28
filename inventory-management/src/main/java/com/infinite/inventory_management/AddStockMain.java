package com.infinite.inventory_management;

import java.sql.SQLException;
import java.util.Scanner;

public class AddStockMain {
	public static void main(String[] args) {
		Stock stock =  new Stock();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Stock Price: ");
		stock.setPrice(scanner.nextDouble());
		
		System.out.println("Enter Stock Name: ");
		stock.setItemName(scanner.next());
		
		System.out.println("Enter Quatity: ");
		stock.setQuatityAvail(scanner.nextInt());
		scanner.close();
		
		StockDAO dao = new StockDAO();
		try {
			System.out.println(dao.addStockDAO(stock));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
