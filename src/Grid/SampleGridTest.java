package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleGridTest {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName("chrome");
		//cap.setPlatform(Platform.WIN10);

		ChromeOptions option=new ChromeOptions();
		option.merge(cap);
		
		String nodeURL=" http://192.168.50.141:4444/wd/hub";
		WebDriver driver= new RemoteWebDriver(new URL(nodeURL),option);
		driver.get("http://practice.automationtesting.in/my-account/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
