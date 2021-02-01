package Day4;

public class SortElementInArray {

	public static void main(String[] args) {
		int array[]= {50,20,40,10,1000};
		int temp=0;
		
		for(int i=0; i<=array.length-2; i++)
		{
			for(int j=(i+1); j<=array.length-1;j++)
			{
				if(array[i]>array[j])
				{
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		
		
		for(int x:array)
		{
			System.out.print(x+ " ,");
		}
	}

}
