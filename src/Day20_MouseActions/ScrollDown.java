 package Day20_MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		//scroll down by pixel
		
//		js.executeScript("window.scrollBy(0,1500)","");
//		Thread.sleep(3000);
//		long value=(long)js.executeScript("return window.pageYOffset;");
//		System.out.println(value);
		
		//scroll down page till the number is visible
		
//		WebElement ele=driver.findElement(By.xpath("//table[2]//tbody[1]//tr[76]//td[1]//img[1]"));
//		js.executeScript("arguments[0].scrollIntoView();",ele );
//		long value=(long)js.executeScript("return window.pageYOffset;");
//		System.out.println(value);
//		
		//scroll down till the end
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		long value=(long)js.executeScript("return window.pageYOffset;");
		System.out.println(value);
		
		Thread.sleep(4000);
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		 value=(long)js.executeScript("return window.pageYOffset;");
		System.out.println(value);
		
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
