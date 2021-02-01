package Day11;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(1089);
		list.add("Selenium");
		list.add('A');
		list.add("Jack");
		
		
		int listSize=list.size();
		System.out.println(listSize);  // Size of the list
		
		System.out.println("Before removing element from the list:"+list);     //printing the list
		
		list.remove(3);
		System.out.println("After removing one element from the list:"+list);
		
		list.add(1, "Mishtee");
		System.out.println("After inserting one element in the list:"+list);
		
		
		System.out.println("Reading element from the arraylist using forloop:");
		for(int i=0; i<listSize; i++)
		{
			System.out.println(list.get(i));
		}
		
		System.out.println();
		System.out.println("Reading element from the arraylist using foreach loop:");
		for(Object i:list)
		{
			System.out.println(i);
		}
		
		
	}

}
