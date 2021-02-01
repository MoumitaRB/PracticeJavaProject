package Day4;

public class MinAndMaxInAnArray {

	public static void main(String[] args) {
		int array[]= {30,20,40,15,10};
		int max=array[0];
		int min=array[0];
		int i=1;
		
		
		for(int x:array) 
		{
			if(x>=max)
			{
				max=x;
			}
			else
			{
				max=max;
			}
		}
		
		for(int x:array)
			
		{
			if(x<=min)
			{
				min=x;
			}
			else
			{
				min=min;
			}
		}
        System.out.println("Maximun element in the array:"+ max);
        System.out.println("Minimum element in the array:"+ min);
        
	}

}
