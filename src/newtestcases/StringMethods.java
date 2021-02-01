package newtestcases;

public class StringMethods {
	
	public static void main(String[] args) {
		
		
		String str="$1,500.00";
		String str1=str.replaceAll("[^0-9.]", "");
		System.out.println(str1);
		double num=0.0;
	    num=num+Double.parseDouble(str1);
	    if(num==1500.00)
	    {
	    	System.out.println("true");
	    }
	    else
	    {
	    	System.out.println("false");
	    }
	    
	    String str2=str.toString();
	    System.out.println(str2);
	}

}
