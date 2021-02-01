package Day24TestNG.pack1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test2 {
	
	@AfterTest
	void n()
	{
		System.out.println("************This is n**************");
	}
	@Test
	public void m3()
	{
		System.out.println("This is m3 method from test2...");
	}
    
	@Test
	public void m4()
	{
		System.out.println("This is m4 method from test2...");
	}
}
