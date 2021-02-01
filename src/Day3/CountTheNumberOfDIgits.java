package Day3;

public class CountTheNumberOfDIgits {

	public static void main(String[] args) {
		int num= 423424;
	    int count =0;
	    int quotient=0;
	    int remainder=0;
	    
	    for(int i=0; num>0; i++)
		{
			
		 if(num!=0)
		   {
			quotient=(num/10);
		    remainder = (num%10);
		    num=quotient;
		    count=count+1;
		     
		    
		  }
		} 
       System.out.print("Total number of digits= "+ count);
	}
}
