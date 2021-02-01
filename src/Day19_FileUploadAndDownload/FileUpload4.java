package Day19_FileUploadAndDownload;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class FileUpload4 {

	public static void main(String[] args) throws InterruptedException, SikuliException {
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Moumita");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Roy");
		driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']")).sendKeys("3475 Golfview Drive, Eagan, MN-55123" );
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid-email ng-invalid ng-invalid-required']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required ng-valid-pattern']")).sendKeys("7845678990");
		driver.findElement(By.xpath("//label[2]//input[1]")).click();
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		WebElement country=driver.findElement(By.xpath("//select[@id='countries']"));
		Select select=new Select(country);
		select.selectByVisibleText("India");
		
		WebElement ele=driver.findElement(By.id("imagesrc"));

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		Thread.sleep(3000);
		
		Screen s=new Screen();
		Pattern fileInputText=new Pattern("C:\\SikuliPics\\TextBox.png");
		Pattern openBtn =new Pattern("C:\\SikuliPics\\OpenBtn1.png");
		
		s.wait(fileInputText,3);
		s.type(fileInputText,"C:\\SikuliPics\\Rose.jpg");
		s.click(openBtn);
		Thread.sleep(3000);
		
		driver.findElement(By.id("submitbtn")).click();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
