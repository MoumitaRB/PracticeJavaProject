package Day23_TestNGSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NopCommerceLoginTest {
	
	 WebDriver driver;
	
	@Test(priority=1)
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://admin-demo.nopcommerce.com/login");
		 driver.manage().window().maximize();
		 
	}
	
	@Test(priority=2)
	void loginTest()
	{   
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		String act_title=driver.getTitle();
		String exp_title="Dashboard / nopCommerce administration";
		
		Assert.assertEquals(act_title, exp_title);
	}
    
	@Test(priority=3)
	void tearDown()
	{
		driver.quit();
	}
}

