package Day4;

public class PrintEvenAndOddNumbersFromArray {

	public static void main(String[] args) {
		
		int array[]= {10,11,12,13,14,15,16};
		int evenCounter=0;
		int oddCounter=0;
		
		for(int num: array)
		{
			if(num%2==0)
			{
				evenCounter=evenCounter+1;
			}
			else
			{
				oddCounter= oddCounter+1;
			}
		}
		
        System.out.println("Number of even number:"+evenCounter);
        System.out.println("Number of odd number:"+ oddCounter);
	}

}
