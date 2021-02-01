package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArrivalsImageNavigatingToNextPage {
     public static  WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
		    driver=new ChromeDriver();
		    
		    driver.get("http://practice.automationtesting.in/");
		    driver.manage().window().maximize();
		    Thread.sleep(4000);
		    
		    driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		    
		    List<WebElement>arrivalImges= driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//h3"));
		    System.out.println(arrivalImges.size());
		   
		      for(WebElement img:arrivalImges)
		       {
		        try {
		    	  String text=img.getText();
		    	  System.out.println(text);
		    	  Thread.sleep(3000);
		    	}
		        catch(StaleElementReferenceException e)
			    {  
		        	driver.navigate().back();
		        	Thread.sleep(3000);
			    	img.click();
			    }
		       
		       }
		    }
		      
		    
	}	    
		    
	



