package Day4;

public class FindMaxAndMinNumberInArray {
	
	int array[]= {-12,3,45,67,980,609,-88};
	int max=array[0];
	int min=array[0];
	
	void minAndMaxNumber()
	{
		for(int i=1; i<=array.length-1;i++)
		{
			if(max<array[i])
			{
				max=array[i];
			}
		    if(min>array[i])
			{
				min=array[i];
			}
		}
		System.out.println("Maximun number is:"+ max);
		System.out.println("Minimum number is:"+ min);
	}

	public static void main(String[] args) {
		FindMaxAndMinNumberInArray mn= new FindMaxAndMinNumberInArray();
		mn.minAndMaxNumber();
		
		
	}

}
