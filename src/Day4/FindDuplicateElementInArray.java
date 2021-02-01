package Day4;

public class FindDuplicateElementInArray {

	public static void main(String[] args) {
		int array[]= {1,2,3,1,2};
		int duplicate=0;
			
		for(int i=0; i<=array.length-2;i++)
		{
			for(int j=(i+1);j<=array.length-1; j++)
			{
				if(array[i]==array[j])
				{
					duplicate=duplicate+1;
				}
			}
		}
		System.out.println("Total number of duplicate number:"+duplicate);	
		

	}

}
