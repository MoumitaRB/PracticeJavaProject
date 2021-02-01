package Day22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDemoDMLComand {

	public static void main(String[] args) throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt=conn.createStatement();
		String str="update student set SNAME='Jack' where SNAME='Mishtee';";
		String str2="insert into student values(130,'Fiona',45,'F',null);";
		String str3="delete from student where ROLLNO=103;";
		stmt.execute(str3);
		
		conn.close();
		
		System.out.println("Program completed...");

	}

}
