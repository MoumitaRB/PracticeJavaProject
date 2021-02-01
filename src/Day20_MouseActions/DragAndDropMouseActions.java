package Day20_MouseActions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropMouseActions {
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    
	    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    
	   //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    WebElement src_ele1=driver.findElement(By.id("box3"));
	    WebElement tar_ele1=driver.findElement(By.id("box103"));
	    WebElement src_ele2=driver.findElement(By.id("box6"));
	    WebElement tar_ele2=driver.findElement(By.id("box106"));
	    WebElement src_ele3=driver.findElement(By.id("box5"));
	    WebElement tar_ele3=driver.findElement(By.id("box105"));
	    WebElement src_ele4=driver.findElement(By.id("box4"));
	    WebElement tar_ele4=driver.findElement(By.id("box104"));
	    
	    Actions act= new Actions(driver);
	    act.dragAndDrop(src_ele1, tar_ele1).perform();
	    act.dragAndDrop(src_ele2, tar_ele2).perform();
	    act.dragAndDrop(src_ele3, tar_ele3).perform();
	    act.dragAndDrop(src_ele4, tar_ele4).perform();
		
	    Thread.sleep(4000);
	    
	    driver.quit();
	}

}
