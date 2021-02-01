package Day25TestNG_Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	
	void setUp(String browserName)
	{
		if(browserName.equals("chrome"))
	    {
		   System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
	    }
	    else if(browserName.equals("firefox"))
	    {
	    	System.setProperty("webbriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
	    }
	}


	@DataProvider(name="dp")
	Object[][] populateData()
	{  
		Object myData[][]= {{"moumitabasak@gmail.com","test1234"},
				{"moumita.test123@gmail.com","1223456"},
				{"test.test123@gmail.com","12345"}};
		
		return myData ;
		
	}

	@Test(dataProvider="dp")
	
	void loginTest(String email_id, String pwd) throws InterruptedException
	
	{   driver.get("https://demo.nopcommerce.com/login");
	    driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email_id);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		String act_title=driver.getTitle();
		String exp_title="nopCommerce demo store";
		Assert.assertEquals(act_title, exp_title,"Title did not match");
		
		Thread.sleep(4000);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	
	
}
