package Day20_MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DifferenentMouseActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\drivers\\chromedriver_win32\\chromedriver.exe");
	    WebDriver  driver=new ChromeDriver();
	    
	    driver.get("https://testautomationpractice.blogspot.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	    
	    WebElement inputBox1=driver.findElement(By.id("field1"));
	    inputBox1.clear();
	    inputBox1.sendKeys("Welcome to java");
	    Thread.sleep(3000);
	    
	    //double click
	    WebElement clickBtn= driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
        Actions act=new Actions(driver);
        act.doubleClick(clickBtn).perform();
		Thread.sleep(4000);
        
        String actualText= driver.findElement(By.xpath("//input[@id='field2']")).getText();
        System.out.println(actualText);
        
        if(actualText.equals("Welcome to java"))
        {
    	   System.out.println("Test passed");
        }
        else
        {
    	   System.out.println("Test Failed");
        }
        
           //Drag and Drop
         WebElement source=driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
         WebElement target=driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
         act.dragAndDrop(source, target).perform();
         Thread.sleep(4000);
         
         
           //scroll down
         JavascriptExecutor js= (JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0,600),(0,650)");
         Thread.sleep(3000);
         
         
          // Drag and Drop
         WebElement source2=driver.findElement(By.xpath("//li[1]//img[1]"));
         WebElement source3=driver.findElement(By.xpath("//li[2]//img[1]"));
         WebElement target2=driver.findElement(By.xpath("//div[@id='trash']"));
         
         act.dragAndDrop(source2, target2).perform();
         Thread.sleep(3000);
         
         act.dragAndDrop(source3, target2).perform();
         Thread.sleep(3000);
         
         
            //slider
         WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
         act.dragAndDropBy(slider, 250, 0).perform();
         Thread.sleep(4000);
            
         
           //scroll down
         js.executeScript("window.scrollBy(0,400),(0,650)");
         Thread.sleep(3000);
           
         
         //resizable
         WebElement  resizeBtn=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
         act.dragAndDropBy(resizeBtn, 200, 100).perform();
         Thread.sleep(4000);
         
         driver.quit();
         
	}

	
}
