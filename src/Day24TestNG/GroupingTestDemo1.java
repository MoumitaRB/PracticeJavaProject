package Day24TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupingTestDemo1 {
	WebDriver driver;
	
	
	@Test(groups= {"Sanity Test"})
	void setUp()
	{
		
	 System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://admin-demo.nopcommerce.com/login");
	 driver.manage().window().maximize();
	 boolean b1= driver.findElement(By.xpath("//input[@class='button-1 login-button']")).isDisplayed();
	 Assert.assertEquals(b1, true);
		
	}
	
	@Test(groups= {"Regression Test"})
	void welcomeMsgTest()
	{
		String str=driver.findElement(By.xpath("//strong[contains(text(),'Welcome, please sign in!')]")).getText();
		Assert.assertEquals(str, "Welcome, please sign in!");
	}
	
	@Test(groups= {"Regression Test"})
	void chechBoxTest()
	{
		boolean b3=driver.findElement(By.xpath("//input[@id='RememberMe']")).isDisplayed();
		Assert.assertEquals(b3,true);
	}
	@Test(groups= {"Sanity Test"})
	void userNamePresenceTest()
	{
		boolean b4=driver.findElement(By.xpath("//body//p[1]")).isDisplayed();
		Assert.assertEquals(b4, true);
	}
	@Test(groups= {"Regression Test"})
	void closing()
	{
		driver.quit();
	}
}
