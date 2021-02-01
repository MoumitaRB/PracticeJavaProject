package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LoginTestInGrid {
	
	static WebDriver driver;
	
	@Test(priority=1)
	
	void setUp() throws MalformedURLException
	{  
		String nodeURL=" http://192.168.50.140:4444/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		//cap.setBrowserName("chrome");
		//cap.setPlatform(Platform.WIN10);
		//cap.setVersion("81");
		//ChromeOptions options=new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new RemoteWebDriver(new URL(nodeURL),cap);
	}
	
	@Test(priority=2)
	void login()
	{
		driver.get("http://practice.automationtesting.in/my-account/");
		driver.findElement(By.id("username")).sendKeys("moumitabasak@gmail.com");
		driver.findElement(By.id("password")).sendKeys("MoumitaBasak");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		String act_text=driver.findElement(By.xpath("//div[@id='body']//p[1]")).getText();
		if(act_text.contains("moumitabasak"))
		{
		    System.out.println("My test is passed..");
		}
		else
		{
			System.out.println("My test is failed...");
		}
	}
	

	

}
