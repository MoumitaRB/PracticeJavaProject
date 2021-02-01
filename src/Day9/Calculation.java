package Day9;

public class Calculation implements InterfaceAA, InterfaceBB {
	
	public void sum()
	{
		System.out.println(a+b);
	}
	
	public void mul()
	{
		System.out.println(x*y);
	}

	public static void main(String[] args) {
		Calculation cal=new Calculation();
		cal.sum();
		cal.mul();
		
		InterfaceAA aaobj=new Calculation();
		aaobj.sum();
		
		InterfaceBB bbobj=new Calculation();
		bbobj.mul();
		
		
	}

}
