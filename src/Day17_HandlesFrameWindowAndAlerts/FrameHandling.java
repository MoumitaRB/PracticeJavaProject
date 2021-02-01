package Day17_HandlesFrameWindowAndAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("https://www.selenium.dev/selenium/docs/api/java/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[text()='WebDriver']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[contains(text(),'Deprecated')]")).click();
		Thread.sleep(3000);
		
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
