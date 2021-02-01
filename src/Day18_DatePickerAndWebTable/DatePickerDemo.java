package Day18_DatePickerAndWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    try {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("datepicker")).click();
		
		String expectedMonth="October";
		String expectedYear="2021";
		
		while(true)
		{
			String actualMonth=driver.findElement(By.xpath("//div//span[@class='ui-datepicker-month']")).getText();
			String actualYear=driver.findElement(By.xpath("//div//span[@class='ui-datepicker-year']")).getText();
			
			if(actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
	   List< WebElement >rows= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr"));
	   int totalRows= rows.size();
	   System.out.println("Total number of rows:"+totalRows);
	  
	   List<WebElement>columns=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
	   int totalColumns= columns.size();
	   System.out.println("Toatl number of columns:"+totalColumns);
	   
	   List<WebElement>dateList =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
	   
	   for(WebElement date:dateList)
	   {
		 String str= date.getText();
		 if(str.equals("15"))
		 {
			 date.click();
		 }
		 
		   
	   }
			    
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    finally
	    {
	    	driver.quit();
	    }
	}

}
