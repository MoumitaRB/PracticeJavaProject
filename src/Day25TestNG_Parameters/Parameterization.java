package Day25TestNG_Parameters;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	
	WebDriver driver;

@BeforeClass
@Parameters({"browser"})

	void setUp(String browserName) throws InterruptedException {
	
	    if(browserName.equals("chrome"))
	    {
		   System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		   driver=new ChromeDriver();
	    }
	    else if(browserName.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			
	    }
	    else if(browserName.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Work\\drivers\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver(); 
		}
		 driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 
		 
}
@Test(priority=1)
@Parameters({"url"})

void lauchingUrl(String url)
{
	 driver.get(url);
	 driver.manage().window().maximize();
	 
	
}
@Test(priority=2)

void logoPresentTest() 
{
	boolean logoImg=driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
    Assert.assertEquals(logoImg, true);
}



@Test(priority=3, dependsOnMethods="logoPresentTest")

void logintitleTest()
{
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
	String act_title=driver.getTitle();
	Assert.assertEquals(act_title, "OrangeHRM");
	
}

@AfterClass
void tearDown()
{
	driver.close();
}
}
