package Day16_WaitCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait myWait= new WebDriverWait(driver, 20);
				
		try {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Fairy Tale");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		WebElement ele= myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='English Fairy Tales - YouTube']")));
		ele.click();
		
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
