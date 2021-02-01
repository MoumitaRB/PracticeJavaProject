package Day27TakeScreenshots;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TakingScreenShotUsingRobotClass {
	public static WebDriver driver;

	public static void main(String[] args) throws HeadlessException, AWTException, IOException {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  driver.manage().window().maximize();
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    
		// This will store screenshot on Specific location
		ImageIO.write(image, "png", new File("C:\\Users\\moumi\\Desktop\\screenshots.png")); 

	}

}
