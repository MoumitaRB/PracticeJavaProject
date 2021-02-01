package Day7;

public class ConstructorOverloading {
	
	int a=10;
	int b=20;
	
	ConstructorOverloading()
	{
		
	}
	
	ConstructorOverloading(int x, int y)
	{
		this.a=x;
		this.b=y;
	}
	
	 int multiply ()
	{
		int c=(a*b);
		return c;
		
	}
	int multiply(int a, int b)
	{
		int c=a*b;
		return c;
	}

	public static void main(String[] args) {
		
		ConstructorOverloading co=new ConstructorOverloading();
		//System.out.println(co.multiply());         //200
		
		System.out.println(co.multiply(12, 30));     //360
		
		
		//ConstructorOverloading co=new ConstructorOverloading(30,60);
		//System.out.println(co.multiply());                        //1800
		
	}

}
