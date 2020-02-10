package aiello;

import java.sql.*;
public class DataSource {

		private String dbURI = "jdbc:mysql://localhost:3306/aiello";
		private String userName = "root";
		private String password = "root";
		public Connection getConnection() throws Exception {
		Connection connection;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(dbURI,userName,
		password);
		} catch (ClassNotFoundException e) {
		throw new Exception(e.getMessage());
		} catch(SQLException e) {
		throw new Exception(e.getMessage());
		}
		return connection;
		}
		
}
