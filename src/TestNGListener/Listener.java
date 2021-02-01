package TestNGListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//@Listeners(TestNGListener.CustomeListener.class)
public class Listener {
	
	WebDriver driver;
   
	@BeforeClass
	
	void setUp() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://admin-demo.nopcommerce.com/login");
	 driver.manage().window().maximize();
	 
	}

	@Test(priority=1)
	@Parameters({"username","pwd"})
	
	void loginTest(String un, String passWord)
	{   
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(un);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		String act_title=driver.getTitle();
		String exp_title="Dashboard / nopCommerce administration";
		
		Assert.assertEquals(act_title, exp_title);
	}

	
	@Test(dependsOnMethods= {"loginTest"})
	void  adminNameTest()
	{
		String act_text=driver.findElement(By.xpath("//li[@class='account-info']")).getText();
		Assert.assertEquals(act_text, "John Smith");
		
	}
	
	@Test( dependsOnMethods= {"adminNameTest"})
	void clickOnViewAllOrders() 
	{
		driver.findElement(By.linkText("View All Orders")).click();
		String act_text=driver.findElement(By.xpath("//h1[@class='pull-left']")).getText();
		Assert.assertEquals(act_text, "Orders");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
}
