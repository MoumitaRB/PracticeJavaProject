package Day17_HandlesFrameWindowAndAlerts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    try {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
		
		
//		List<WebElement>linklist=driver.findElements(By.tagName("a"));
//		for(WebElement link:linklist)
//		{
//			System.out.println(link.getText());
//		}
		

	    List<WebElement>linklist= driver.findElements(By.xpath("//form[@id='Wikipedia1_wikipedia-search-form']//following-sibling::div//div//a"));
	    System.out.println( linklist.size());
	    
	    for(WebElement link:linklist)
	    {
	    	link.click();
	    }
	   
	    Set<String>windowId= driver.getWindowHandles();
	    for(String id:windowId) 
	    {
	       String title= driver.switchTo().window(id).getTitle();
	       System.out.println(windowId+" = "+title);
	       
	        if(title.equals("Selenium - Wikipedia"))
	        {
	        	driver.findElement(By.linkText("Random article")).click();
	        	Thread.sleep(3000);
	        	driver.close();
	        }
	        else if(title.equals("Selenium in biology - Wikipedia")||title.equals("Selenium (software) - Wikipedia")
	        		||title.equals("Selenium disulfide - Wikipedia")||title.equals("Selenium dioxide - Wikipedia"))
	        {
	        	driver.close();
	        }
	    	
	     }
	    
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
