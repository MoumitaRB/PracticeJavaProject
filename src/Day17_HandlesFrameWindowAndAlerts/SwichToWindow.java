package Day17_HandlesFrameWindowAndAlerts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SwichToWindow {

	public static void main(String[] args) {
		
	
		System.setProperty("webdriver.chrome.driver","C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("https://dhms.district196.org/");
		driver.manage().window().maximize();
		
		WebElement academics=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]"));
		WebElement math=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/li[4]/a[1]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(academics).build().perform();
		act.moveToElement(math).click().build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[@id='h.p_7Wt2yhTDBkJL']/a")).click();
		driver.findElement(By.xpath("//p[@id='h.p_snHR4UikHn9N']/a")).click();
		
		Set<String>winId=driver.getWindowHandles();
		for(String h:winId)
		{
			String title=driver.switchTo().window(h).getTitle();
			System.out.println(title);
			if(title.equals("6th grade Math")||title.equals("Kisch Math"))
			{
				driver.close();
			}	
		}
		
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
