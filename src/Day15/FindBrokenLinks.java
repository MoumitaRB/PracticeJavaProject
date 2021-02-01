package Day15;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> linkLists=driver.findElements(By.tagName("a"));
		linkLists.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total number of links:"+linkLists.size());
		
		
		List<WebElement> activelinks= new ArrayList<WebElement>();
		
		for(int i=1; i<linkLists.size();i++)
		{
			if(linkLists.get(i).getAttribute("href")!=null)
			{
				activelinks.add(linkLists.get(i));
			}
		}
		
//		for(WebElement l:linkLists)
//		{
//			if(l.getAttribute("href")!=null)
//			{
//				activelinks.add(l);
//			}
//		}
		System.out.println("Total number of active links:"+activelinks.size());
		Thread.sleep(7000);
		for(int j=0; j<activelinks.size(); j++)
		{
			String url=activelinks.get(j).getAttribute("href");
			URL link=new URL(url);
			
			HttpURLConnection httpConn=(HttpURLConnection)link.openConnection();
			httpConn.connect();
			
			int  resCode=httpConn.getResponseCode();
			if(resCode>=400)
			{
				System.out.println(url+"==It's a broken link");
			}
			else
			{
				System.out.println(url+"==It's an active link");
			}
		}
		Thread.sleep(6000);
		
		driver.quit();
	}
	

}
