package Day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindTheDuplicateElementByHashMap {
	String array[]= {"john","smith","joey","john"};
	
	
	void duplicateElement()
	{
		Map <String,Integer> hashMap=new HashMap<String,Integer>();
		for(String name:array)
		{
		   Integer count=hashMap.get(name);
		   if(count==null)
		   {
			   hashMap.put(name, 1);
		   }
		   else
		   {
			   hashMap.put(name, ++count);
		   }
		}
		
		Set<Entry<String, Integer>> entrySet= hashMap.entrySet();
		for(Entry<String, Integer>entry:entrySet)
		{
			if(entry.getValue()>1)
			{
				System.out.println("Duplicate element is:"+ entry.getKey());
			}
		}
	}
	
	

	public static void main(String[] args) {
		FindTheDuplicateElementByHashMap dhm= new FindTheDuplicateElementByHashMap();
		dhm.duplicateElement();
		
	}

}
