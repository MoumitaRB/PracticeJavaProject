package Day17_HandlesFrameWindowAndAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramewithInFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		
		WebElement outerFrame=driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
		driver.switchTo().frame(outerFrame);
		Thread.sleep(3000);
		
		WebElement innerFrame=driver.findElement(By.xpath("//body//following-sibling::div//iframe[@style='float: left;height: 250px;width: 400px']"));
		driver.switchTo().frame(innerFrame);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input[@type='text']")).sendKeys("Reached Here!");
		Thread.sleep(4000);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
	}

}
