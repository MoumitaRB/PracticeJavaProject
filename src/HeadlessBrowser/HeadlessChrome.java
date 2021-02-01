package HeadlessBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		//option.setHeadless(true);
		option.addArguments("--headless");
		
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://en-gb.facebook.com/login/");
		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
        driver.quit();
	}

}
