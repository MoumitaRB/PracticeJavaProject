package Day5;

public class Reverse_A_String_With_Method {
	
	String str;
	String newStr="";

	void reverseString(String str)
	{  this.str=str;
	   
	    for(int i=str.length()-1; i>=0; i--)
	    {
	    	newStr=newStr+str.charAt(i);
	    }
	    
	    System.out.println(newStr);
	    	
	}
	public static void main(String[] args) {
		Reverse_A_String_With_Method rs=new Reverse_A_String_With_Method();
		rs.reverseString("moumita");
				
		
		
		
	}

}
