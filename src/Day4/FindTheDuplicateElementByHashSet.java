package Day4;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateElementByHashSet {

	public static void main(String[] args) {
		String array[]= {"papai", "Sonai","Manai","babai","papai"};
		
		Set<String> name= new HashSet<String>();
		
		for(String x:array)
		{
			if(name.add(x)==false)
			{
				System.out.print("Duplicate String is :"+x);
			}
		}
		}
	}


