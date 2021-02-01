package Day18_DatePickerAndWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceDatePicker {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	   
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		driver.findElement(By.xpath("//a[@href='#']//span[contains(text(),'Customers')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn bg-blue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='k-select']")).click();
		
		
		String monthyear="November 2019";
		String date="23";
		while(true)
		{
			String act_month=driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			System.out.println(act_month);
			if(act_month.equals(monthyear))
			{
		          break;
			}
			
		   driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]/a[1]/span[1]")).click();
		   Thread.sleep(3000);
			
		}
		
		List<WebElement>rows=driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println(rows.size());
		
		List<WebElement>columns=driver.findElements(By.xpath("//table//tbody//tr//td"));
		System.out.println(columns.size());
		
		
		for(WebElement col:columns)
		{    
			String ele=col.getText();
			if(ele.equals(date))
			{  
				col.click();
			}
		}
		
	}

}
