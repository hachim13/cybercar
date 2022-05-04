package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnexion {
	 public static String url = "jdbc:mysql://localhost:3306/cybercar";
	    public static String user = "root";
	    public static String password = "";
	    public static String driver = "com.mysql.jdbc.Driver";

	    public static Connection getConnect() {
	        Connection con = null;
	        try {
	            Class.forName(driver);
	            con = DriverManager.getConnection(url, user, password);
	            if (con != null) {
	                System.out.println("Connexion reussi!");
	                return con;

	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();

	        }

	        return null;
	    }

}
