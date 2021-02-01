package Day24TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupingTestDemo2 {
	WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	void setUp()
	{	
	 System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
     driver=new ChromeDriver();
	}
	
	@Test(priority=1,groups= {"Sanity test"})
	void logIn()
	{
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.xpath("//input[@name='login']")).click();
	}
	
	@Test(priority=2,dependsOnMethods="logIn",groups= {"Regression test"})
	void TitleVarifiactionTest()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
	}
	
	@AfterClass(alwaysRun=true)
	void tearDown()
	{
		driver.quit();
	}
}
