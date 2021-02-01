package Day7;

public class Calculation {
	int x;
	int y;
	static int c;
	static double total;
	
	int sum(int x,int y)
	{
		 c= (x+y);
		return c;
	}
	
	int sum(int x, int y, int z)
	{
		c=(x+y+z);
		return c;
	}
	
	double sum(double a, double b)
	{   
		
		 total=(a+b);
		return total;
	}
	
	double sum(double a, double b, double c)
	{
		
	     total=(a+b+c);
		return total;
	}

	public static void main(String[] args) {
		Calculation cal=new Calculation();
		cal.sum(78, 20);
		System.out.println(c);
		
		cal.sum(100, 30, 40);
		System.out.println(c);
		
		cal.sum(20.67, 45.90);
		System.out.println(total);
		
		cal.sum(19.11, 56.13, 35.41);
		System.out.println(total);
		
		
	}

}
