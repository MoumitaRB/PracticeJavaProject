package Day18_DatePickerAndWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetDatePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    try {
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[@class='maincontainer']/div[@id='wrapper']/div[@id='mainContents']/div[@id='new-homepage']/div[@id='home_banner']/div[@class='home_flight_search']/div[@id='content-change']/div[@class='book']"
				+ "/div[@id='flightSearchContainer']/div[@class='picker-first2']/button[1]")).click();
		
		
		String monthYear="November 2020";
		String date="25";
		
		while(true)
		{
			String ele= driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div//following-sibling::div[@class='ui-datepicker-title']")).getText();
			if(ele.equals(monthYear))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement>rows=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr"));
		System.out.println(rows.size());
		
		List<WebElement>columns=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		System.out.println(columns.size());
		
		for(WebElement ele:columns)
		{
			String act_date= ele.getText();
			if(act_date.equals(date))
			{
				ele.click();
			}
			
		}
//		boolean flag=false;
//		
//		for(int r=1; r<=rows.size();r++)
//		{
//			for(int c=1; c<=columns.size(); c++)
//			{
//				String text=driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr["+r+"]//td["+c+"]")).getText();
//			    if(text.equals(date))
//			    {
//			    	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr[r]//td[c]")).click();
//			    	flag=true;
//			    	break;
//			    }
//			 if(flag=true)
//			 {
//				 break;
//			 }
//			}  
//		}
		
		
		Thread.sleep(3000);
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


////div[@id='ui-datepicker-div']//div//following-sibling::div[@class='ui-datepicker-title']