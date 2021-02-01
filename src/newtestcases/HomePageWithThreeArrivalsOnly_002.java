package newtestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageWithThreeArrivalsOnly_002 {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\moumi\\Desktop\\ChromeDriver\\chromedriver.exe");
		    driver=new ChromeDriver();
		    
		    driver.get("http://practice.automationtesting.in/");
		    driver.manage().window().maximize();
		    Thread.sleep(4000);
		    
		   
		  List<WebElement>texts= driver.findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link']//h3"));
		  System.out.println(texts.size());
		  int arrival=0;
		  for(WebElement ele:texts)
		  {
			  String act_text=ele.getText();
			  if(act_text.equals("Selenium Ruby")||act_text.equals("Thinking in HTML")||act_text.equals("Mastering JavaScript"))
			  {
				 arrival=arrival+1; 
			  }
		  }
		  
		  if(arrival==3)
		  {
			  System.out.println("Home Page has 3 arrivals only....");
		  }
		  else
		  {
			  System.out.println("Home page has more than 3 arrivals....");
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
