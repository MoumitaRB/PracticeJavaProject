package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageWithThreeSliderOnly_001 {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		 try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
		    driver=new ChromeDriver();
		    
		    driver.get("http://practice.automationtesting.in/");
		    driver.manage().window().maximize();
		    Thread.sleep(4000);
		    
		    driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		    
		    List <WebElement>imglist=driver.findElements(By.tagName("img"));
		    System.out.println(imglist.size());
		    int count=0;
		    for(WebElement img:imglist)
		    {
		    	String act_alt=img.getAttribute("alt");
		    	if(act_alt.equals("Shop Selenium Books")||act_alt.equals("HTML")||act_alt.equals("JavaScript"))
		    	{
		    		count=count+1;
		            
		    	}
		    }
		    System.out.println(count);
		    
		    if(count==3)
		    {
		    	System.out.println("Home page has only 3 sliders...");
		    }
		    else
		    {
		    	System.out.println("Home page has more than 3 sliders....");
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
