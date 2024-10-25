package factory;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	private static final String DATABASE = "jdbc:mysql://localhost:3306/agenda";
	

	public static Connection createConnectionToMySQL() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		
		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("conexão feita");
			con.close();
		}
	}
}
