package Day24TestNG.pack1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
	@BeforeTest
	void m()
	{
		System.out.println("************This is m*************");
	}
	
	@Test(priority=1)
	public void m1()
	{
		System.out.println("This is m1 method from test1...");
	}
	
	@Test(priority=2)
	public void m2()
	{
		System.out.println("This is m2 method from test1...");
	}

}
