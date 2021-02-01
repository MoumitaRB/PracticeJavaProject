package Day22_JDBC;

/*
 * 1) create connection to the database
 * 2) create statement
 * 3) execute statement
 * 4) close connection
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseDemo1 {

	public static void main(String[] args) throws SQLException {
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt= conn.createStatement();
		String str="select * from student;";
		ResultSet rs= stmt.executeQuery(str);
		
		while(rs.next())
		{
			int serialNo=rs.getInt("ROLLNO");
			String name=rs.getString("SNAME");
			String mark=rs.getString("MARKS");
			String grade=rs.getString("GRADE");
			
			System.out.print(serialNo+"    "+name+"    "+mark+"     "+grade);
			System.out.println();
		}
		
		conn.close();
		System.out.println("Qrary executed....");
	}

}
