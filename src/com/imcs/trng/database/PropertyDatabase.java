package com.imcs.trng.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.imcs.training.property.PropertyInformation;

public class PropertyDatabase {

	public PropertyInformation saveProperty(PropertyInformation property) throws SQLException {
		try (Connection connection = createConnection();) {
			String sql = "insert into property (ID,Name, Address, Tax_Amount, Filling_Date) values (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, property.getCustID());
			ps.setString(2, property.getName());
			ps.setString(3, property.getAddress());
			ps.setDouble(4, property.getTaxAmount());
			ps.setDate(5, java.sql.Date.valueOf(property.getFillingDate()));
			int rowsUpdate = ps.executeUpdate();

			if (rowsUpdate >= 1) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						property.setCustID(generatedKeys.getInt(1));
					} else {
						throw new SQLException("Creating user failed, no id obtained");
					}
				}
			}

		}
		return property;
	}

	private Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Where is my JDBC Driver");
			ex.printStackTrace();
			return null;
		}

		System.out.println("MySql JDBC Driver registered");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertyproject", "root", "admin");
		} catch (SQLException ex) {
			System.out.println("Connection failed check output console");
			ex.printStackTrace();
			return null;
		}
		return connection;
	}

}
