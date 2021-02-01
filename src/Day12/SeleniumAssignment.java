package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumAssignment {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		try {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    //System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
	   // driver=new FirefoxDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		Thread.sleep(2000);
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		if(actualTitle.equals("Dashboard / nopCommerce administration"))
		{
			System.out.println("Test passed!");
		}
		else
		{
			System.out.println("Test failed...");
		}
		
		
		
		}
		finally {
			driver.quit();
			
		}
	}

}
