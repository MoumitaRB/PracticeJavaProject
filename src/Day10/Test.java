package Day10;

public class Test {

	public static void main(String[] args) throws InterruptedException{
		try {
			
		System.out.println("Program started!");
		Thread.sleep(2000);;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			System.out.println("Program executed...");
		}
	}

}
