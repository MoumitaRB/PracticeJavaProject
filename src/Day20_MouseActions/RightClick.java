package Day20_MouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act= new Actions(driver);
		act.contextClick(button).perform();;
		Thread.sleep(3000);
		WebElement editBtn=driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']"));
	    editBtn.click();
		
		Alert alt=driver.switchTo().alert();
	    String actualText=alt.getText();
	    
	    if(actualText.equals("clicked: edit"))
	    {
	       alt.accept();
	    }
	    Thread.sleep(3000);
	    	
		driver.quit();
		
		
		
	}

}
