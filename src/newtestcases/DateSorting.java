package newtestcases;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateSorting {

	public static void main(String[] args) throws ParseException {
		Date date=new Date();
		System.out.println(date.toString());
		
		Date dNow = new Date( );
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("MMM dd,yyyy hh:mm:ss a");

	      System.out.println("Current Date: " + ft.format(dNow));
	      
	      ArrayList<Date>listDates=new ArrayList<Date>();
	      ArrayList<Date>sortedList=new ArrayList<Date>();
	      List<String>elist=new ArrayList<String>();
	      elist.add("Mar 6,2009");
	      elist.add("Aug 17,2013");
	      elist.add("Jan 12,2001");
	      SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd,yyyy");

	      for(String we:elist)
	      {

	          listDates.add(dateFormatter.parse(we));
	          sortedList.add(dateFormatter.parse(we));
	          System.out.println("listDates:"+listDates);
	          System.out.println("sortedList:"+sortedList);

	      }
	     Collections.sort(sortedList);
	     System.out.println("Assending order:"+sortedList);
	     Collections.sort(sortedList,Collections.reverseOrder());
	     System.out.println("Decending order:"+sortedList);
	}

}
