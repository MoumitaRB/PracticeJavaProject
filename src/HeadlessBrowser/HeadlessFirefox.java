package HeadlessBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		FirefoxOptions option=new FirefoxOptions();
		option.setHeadless(true);
		
		WebDriver driver=new FirefoxDriver(option);
		
		driver.get("https://en-gb.facebook.com/login/");
		System.out.println(driver.getTitle());
		
	
		

	}

}
