/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connDB;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hussienalbared
 */
public class DBConnection {private static Connection connection = null;

	public static Connection getActiveConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3308/library?"
							+ "user=root&password=root&characterEncoding=utf8");
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

    
}
