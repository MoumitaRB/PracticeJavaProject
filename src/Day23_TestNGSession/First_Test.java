package Day23_TestNGSession;

import org.testng.annotations.Test;

public class First_Test {
	
	@Test(priority=1)
	void setUp()
	{
		System.out.println("Lauching Browser...");
		System.out.println("Lauching URL...");
	}
    
	@Test(priority=2)
	void loginTest()
	{
		System.out.println("Login test...");
	}
	
	@Test(priority=3)
	void tearDown()
	{
		System.out.println("Logout from the app...");
	}
}
