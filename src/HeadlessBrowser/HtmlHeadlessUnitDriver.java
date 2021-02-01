package HeadlessBrowser;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlHeadlessUnitDriver {

	public static void main(String[] args) {
		
		HtmlUnitDriver driver=new HtmlUnitDriver();
		
		driver.get("https://www.orangehrm.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

}
