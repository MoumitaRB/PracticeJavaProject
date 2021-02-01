package Day22_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenLoginTest {

	public static void main(String[] args) throws SQLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    WebDriver  driver=new ChromeDriver();
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	    driver.manage().window().maximize();
	    
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	    Statement stmt= conn.createStatement();
	    
	    String str="select * from logindata;";
	    ResultSet rs= stmt.executeQuery(str);
	    
	    while(rs.next())
	    {
	    	String email=rs.getString("email_id");
	    	String password=rs.getString("pwd");
	    	
	    	driver.findElement(By.id("txtUsername")).sendKeys(email);
	    	driver.findElement(By.id("txtPassword")).sendKeys(password);
	    	driver.findElement(By.id("btnLogin")).click();
	    	Thread.sleep(3000);
	    	
	    	
	    	String act_title=driver.getTitle();
	    	String text=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[5]/span[1]")).getText();
	    	System.out.println(text);
	    	Thread.sleep(3000);
	    	if(act_title.equals("OrangeHRM"))
	    	{
	    		System.out.println("Test Passed....");
	    	}
	    	else if(text.equals("Invalid credentials") && act_title.equals("OrangeHRM"))
	    	{  
	  
	    		System.out.println("Test Failed....");
	    	}
	    	
	    	
	     }
	    
        rs.close();
        conn.close();
        driver.quit();
	}

}
