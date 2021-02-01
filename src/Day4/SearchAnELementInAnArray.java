package Day4;

public class SearchAnELementInAnArray {

	public static void main(String[] args) {
		int array[]= {10,20,30,40,50};
		int num=30;
		boolean flag=false;
		
		for(int x:array)
		{
			if(x==num)
			{
				System.out.println("Element found!");
				flag=true;
				break;
			}
			
		}
        if(flag!=true)
        {
        	System.out.println("Element not found!");
        }
	}

}
