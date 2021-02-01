package Day11;

import java.util.HashMap;

public class HashMapDemo {
	
	

	public static void main(String[] args) {
		
		HashMap<Integer, String> hashmap=new HashMap<Integer, String>();
		hashmap.put(101, "Prateek");
		hashmap.put(102, "Mishtee");
		hashmap.put(103, "Spriha");
		hashmap.put(104,"Arham");
		hashmap.put(106, "1234");
		
		int size=hashmap.size();       // get the size of the hashmap
		System.out.println(size);
		
		System.out.println(hashmap);   //printing the hashmap
		
		hashmap.remove(104);
		System.out.println("After removing one key="+hashmap);
		
		hashmap.put(104, "Himani");     //adding one  set key value pair 
		System.out.println(hashmap);
		System.out.println("Reading the keys from hashmap=");
		
		
		for(int i:hashmap.keySet())
		{   
			System.out.println(i);
		}
		
		System.out.println("Reading values from the keys=");
		
		for(String i:hashmap.values())
		{
			System.out.println(i);
		}
		
		
		System.out.println("Reading key and value pair:");
		for(int i:hashmap.keySet())
		{
			System.out.println(i+" ="+hashmap.get(i));
		}
		
		
	}

}
