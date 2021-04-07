package newtestcases;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchContextExamples {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		SearchContext driver=new ChromeDriver();
		WebDriver dr= (WebDriver)driver;
		
	   
		dr.get("https://www.amazon.com/");
		dr.manage().window().maximize();
		dr.quit();
	}

}
