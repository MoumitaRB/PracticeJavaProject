package Day17_HandlesFrameWindowAndAlerts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesWithMethods {
	public static WebDriver driver;
	public static WindowHandlesWithMethods whObj;
	
	
	public void gettingLinks(WebElement link, WebElement clickBtn, String value) throws InterruptedException
	{
		link.sendKeys(value);
		clickBtn.click();
		Thread.sleep(3000);
		
	}
	public void clickingOnLinks(List<WebElement> linklist)
	{
		 System.out.println("size of the links:"+ linklist.size());
		    
		    for(WebElement link:linklist)
		    {
		    	link.click();
		    }
	}
	
	public void handlingWindow(Set<String> windowId,String linkTitle1, String linkTitle2, String linkTitle3,
			String linkTitle4, String linkTitle5) throws InterruptedException
	{
		for(String id:windowId) 
	    {
	       String title= driver.switchTo().window(id).getTitle();
	       System.out.println(windowId+" = "+title);
	       
	        if(title.equals(linkTitle1))
	        {
	        	driver.findElement(By.linkText("Random article")).click();
	        	Thread.sleep(3000);
	        	driver.close();
	        }
	        else if(title.equals(linkTitle2)||title.equals(linkTitle3)
	        		||title.equals(linkTitle4)||title.equals(linkTitle5))
	        {
	        	driver.close();
	        }
	    	
	     }
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    try {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement link=driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		WebElement clickBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		
		whObj=new WindowHandlesWithMethods();
		whObj.gettingLinks(link, clickBtn, "Selenium");
		
		
		List<WebElement>linklist= driver.findElements(By.xpath("//form[@id='Wikipedia1_wikipedia-search-form']"
				+ "//following-sibling::div//div//a"));
		
		whObj.clickingOnLinks(linklist);
		
		Set<String>windowId= driver.getWindowHandles();
		String linkTitle1="Selenium - Wikipedia";
		String linkTitle2="Selenium in biology - Wikipedia";
		String linkTitle3="Selenium (software) - Wikipedia";
		String linkTitle4="Selenium disulfide - Wikipedia";
		String linkTitle5="Selenium dioxide - Wikipedia";
		
		whObj.handlingWindow(windowId, linkTitle1, linkTitle2, linkTitle3, linkTitle4, linkTitle5);
		
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
