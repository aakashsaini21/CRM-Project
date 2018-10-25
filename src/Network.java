import java.sql.DriverManager;
import java.sql.Connection;


public class Network {
	public static Connection connection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","7225");
		return con;
	}
}

