package SuryaJSM.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	public Connection getConnection()throws ClassNotFoundException, SQLException{
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cuims","root","HiSQL@12");
		
          System.out.println("Connection Established !! Hurrayyy !!! LULU lalala !!");
         System.out.println(con.getClass().getName());
		return con;
	}


}
