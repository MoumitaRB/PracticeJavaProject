package Day18_DatePickerAndWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchWebTableWithCondition {
	
	public static WebDriver driver;
	   public static WebTableCheck wtObj;
	   

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		try {
			
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
			System.out.println(rows.size());
			List<WebElement>columns=driver.findElements(By.xpath("//table//tbody//tr[2]//td"));
			System.out.println(columns.size());
			
			for(int r=2; r<rows.size(); r++)
			{
				for(int c=1; c<=columns.size(); c++)
				{    
					String data=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td["+c+"]")).getText();
					System.out.print(data+"    ");
				}
				System.out.println();
			}
			
			System.out.println("----------------");
			
			for(int r=2; r<rows.size();r++)
			{
			      String author=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[2]")).getText();
				  if(author.equals("Amit"))
					{
						String book=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[1]")).getText();
						System.out.println("Books written by Amit:"+book);
					}
				
			}
			
			System.out.println("------------------------------");
			int totalCost=0;
			for(int r=2; r<rows.size(); r++)
			{
				String cost=driver.findElement(By.xpath("//table//tbody//tr["+r+"]//td[4]")).getText();
				totalCost=totalCost+Integer.parseInt(cost);
			}
			System.out.println("Total cost of the books:"+ totalCost);
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
