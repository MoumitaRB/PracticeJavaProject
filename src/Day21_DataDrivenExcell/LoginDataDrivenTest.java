package Day21_DataDrivenExcell;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDataDrivenTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    WebDriver  driver=new ChromeDriver();
	    
	    driver.get("https://admin-demo.nopcommerce.com/login");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	    String path="C:\\excelData\\new.xlsx";
	    int rownum=  XUtils.getRowCount(path, "Sheet1");
	    System.out.println(rownum);
	    
	        //Reading data from the xcell
	    for(int r=1; r<=rownum; r++)
	    {
	        String email= XUtils.getCellData(path, "Sheet1", r, 0);
	        String pwd=XUtils.getCellData(path, "Sheet1", r, 1);
	        
	        System.out.print(email+"        "+pwd);
	        System.out.println();
	        
	        //Passing the data in the application
	        
	        driver.findElement(By.id("Email")).clear();
	        driver.findElement(By.id("Email")).sendKeys(email);
	        Thread.sleep(3000);
	        driver.findElement(By.id("Password")).clear();
	        driver.findElement(By.id("Password")).sendKeys(pwd);
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	        
	        Thread.sleep(3000);
	        
	       String act_title= driver.getTitle();
	       if(act_title.equals("Dashboard / nopCommerce administration"))
	       {
	    	  XUtils.setCellData(path, "Sheet1", r, 4, "Pass");
	    	  XUtils.fillGreenColor(path, "Sheet1", r, 4);
	    	  Thread.sleep(3000);
	    	  driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	       }
	       else
	       {   
	    	   XUtils.setCellData(path, "Sheet1", r, 4, "Fail");
		       XUtils.fillRedColor(path, "Sheet1", r, 4);
		       
		       driver.findElement(By.id("Email")).clear();
		       driver.findElement(By.id("Password")).clear();
	       }
	       
	       
	       
	    }
	     
	    Thread.sleep(3000);
	    driver.quit();
	}

}
