package com.infinite.inventory_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StockDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	
	public String stockId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT stockId FROM stock ORDER BY stockId DESC LIMIT 1";
		preparedStatement = connection.prepareStatement(cmd);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		resultSet.next();
		String id = String.format("%03d", Integer.parseInt(resultSet.getString("stockId").substring(1))+1);
		String stockId = "S"+ id;
		return stockId;
	}
	
	public List<Stock> showStock() throws ClassNotFoundException, SQLException {
		List<Stock> stockList = new ArrayList<Stock>();
		connection = ConnectionHelper.getConnection();
		preparedStatement = connection.prepareStatement("select * from stock");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Stock stock = null;
		while(resultSet.next()){
			stock = new Stock();
			stock.setStockId(resultSet.getString("stockId"));
			stock.setPrice(resultSet.getDouble("price"));
			stock.setItemName(resultSet.getString("itemname"));
			stock.setQuatityAvail(resultSet.getInt("quantityAvail"));
			
			stockList.add(stock);
		}
		return stockList;
	}
	
	public Stock searchStockDAO(String stockId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		preparedStatement = connection.prepareStatement("select * from stock where stockId = ?");
		preparedStatement.setString(1, stockId);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Stock stock = null;
		if (resultSet.next()) {
			stock = new Stock();
			stock.setStockId(resultSet.getString("stockId"));
			stock.setPrice(resultSet.getDouble("price"));
			stock.setItemName(resultSet.getString("itemname"));
			stock.setQuatityAvail(resultSet.getInt("quantityAvail"));			
		}
		return stock;
	}
	
	public String addStockDAO(Stock stock) throws ClassNotFoundException, SQLException {
		String stockId = stockId();
		connection = ConnectionHelper.getConnection();
		preparedStatement = connection.prepareStatement("insert into stock (stockId, price, itemName, quantityAvail) values(?,?,?,?)");
		preparedStatement.setString(1, stockId);
		preparedStatement.setDouble(2, stock.getPrice());
		preparedStatement.setString(3, stock.getItemName());
		preparedStatement.setInt(4, stock.getQuatityAvail());
		
		preparedStatement.executeUpdate();
		
		return "Stock Added.";
	}
}
