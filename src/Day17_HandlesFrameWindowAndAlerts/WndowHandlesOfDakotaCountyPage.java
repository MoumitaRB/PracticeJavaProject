package Day17_HandlesFrameWindowAndAlerts;


import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WndowHandlesOfDakotaCountyPage {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
	  System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
	  
	  driver.get("https://www.co.dakota.mn.us/libraries/BooksMaterials/Pages/default.aspx");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Catalog']")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//body/div[@id='content']/div[1]/div[1]/span[1]/div[1]/div[9]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[4]/a[1]/img[1]")).click();
	  Thread.sleep(3000);
	  
	 Set<String>windowId=driver.getWindowHandles();
	 for(String id:windowId)
	 {
		 String title=driver.switchTo().window(id).getTitle();
		 System.out.println("The title is="+title);
		 
		 if(title.equals("DCL_CATALOG"))
		 {
			 driver.close();

		 }
		 else if(title.contains("Search Results for TITLE=smartest TITLE=kid TITLE=in TITLE=the TITLE=universe AUTHOR=Grabenstein, AUTHOR=Chris"))
		 {   
			 
			 driver.findElement(By.xpath("//input[@title='Apple Valley (Galaxie)']")).click();
			 driver.findElement(By.xpath("//span[@title='Apple Valley (Galaxie)']//a[@title='Apple Valley (Galaxie)']")).click();
		 }
		 
	 }
	 
	  Thread.sleep(3000);
	  driver.quit();
	}

}
