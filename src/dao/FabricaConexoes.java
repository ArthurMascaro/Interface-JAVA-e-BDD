package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/trabalhoDupla?useSSL=false", "root", "password");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

