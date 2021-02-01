package Day9;

public class ClassB implements InterfaceA{
	 public static int c=0;
	
	public int sum()
	{
	    c=(a+b);
	    return c;
	}

	public static void main(String[] args) {
		ClassB bobj=new ClassB();
		bobj.sum();
		System.out.println(c);
		
//		InterfaceA aobj= new ClassB();
//		aobj.sum();
//		System.out.println(c);
//				
	
				
		
	}

}
