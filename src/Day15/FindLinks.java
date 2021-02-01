package Day15;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLinks {
	
	public static FindLinks flObj;
	
	public void getLinkText(List<WebElement> links)
	{
//		for(int i=0; i<links.size();i++)
//		{
//			String s=links.get(i).getText();
//			System.out.println(s);
//		}
		
		for(WebElement e:links)
		{
			String s=e.getText();
			System.out.println(s);
		}
		
	}
	

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int linkSize=links.size();
		System.out.println("Total number of links:"+linkSize);
		
        List<WebElement >inputBoxList=driver.findElements(By.tagName("input"));
        int inputSize=inputBoxList.size();
        System.out.println("Total number of input boxes:"+inputSize);
        
        List<WebElement> images=driver.findElements(By.tagName("img"));
        int imageSize= images.size();
        System.out.println("Total number of images:"+imageSize);
       
		flObj=new FindLinks();
		flObj.getLinkText(links);
		
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
