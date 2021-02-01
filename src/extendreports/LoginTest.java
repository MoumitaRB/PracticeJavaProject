package extendreports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest {
	WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://admin-demo.nopcommerce.com/login");
	    driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	void loginTest()
	{   
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		String act_title=driver.getTitle();
		Assert.assertEquals(act_title, "Dashboard / nopCommerce administration");
	}
	
	@Test(priority=2, dependsOnMethods= {"loginTest"})
	void  adminNameTest()
	{
		String act_text=driver.findElement(By.xpath("//li[@class='account-info']")).getText();
		Assert.assertEquals(act_text, "John Smith");
		
	
	}
	
	@Test(priority=3,dependsOnMethods= {"adminNameTest"})
	void clickOnViewAllOrders() 
	{
		driver.findElement(By.linkText("View All Orders")).click();
		String act_text=driver.findElement(By.xpath("//h1[@class='pull-left']")).getText();
		Assert.assertEquals(act_text, "Orders");
	}
	
    @Test(priority=4, dependsOnMethods="loginTest")
    void logOutTest()
    {
    	driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
    	String act_title=driver.getTitle();
    	Assert.assertEquals(act_title, "Your store. Login");
    }
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
}
