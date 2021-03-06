package oop.classes.Date.tests;

import java.util.ArrayList;

import oop.classes.Date.enums.DayOfWeek;
import oop.classes.Date.models.Date;
import oop.classes.event.models.Event;

public class DateTest {

	public static void main(String[] args)
	{
		Date d1 = new Date();
		//Second January 2003
		//Date d2 = new Date(2, 1, 2003);
		//Date d2 = new Date(59, 59, 23, 28, 2, 2004); // - Test adding a second for leap year
		Date d2 = new Date(59, 59, 23, 31, 12, 2004); // - Test adding a second just before New Year 
		Date d3 = new Date(0, 0, 23, 20, 10, 2020);
		
		if(d2.compareTo(d3) == 1)
		{
			System.out.println("D2 is bigger than d3!");
		}
		else if(d2.compareTo(d3) == -1)
		{
			System.out.println("D3 is bigger than d2!");
		}
		else
		{
			System.out.println("D2 is equal to d3!");
		}
		
		if(d3.isLeap())
		{
			System.out.println("D3 is leap!");
		}
		else
		{
			System.out.println("D3 is not leap!");
		}
		
		System.out.println("D3 is the " + d3.dayOfTheYear() + " day");
		//This week starts on Wednesday
		System.out.println("D3 is in " + d3.whichWeek(3) + " week");
		
		d2.addSecond();
		
		System.out.println("D2 after a second is added: " + d2.toString());
		
		ArrayList<Date> l = new ArrayList<Date>();
		l.add(d3);
		l.add(d2);
		l.add(d1);
		l.add(d3);
		
		SortDates(l);
		
		System.out.println("Array: ");
		
		for(Date i : l)
		{
			System.out.println(i.toString());
		}
		
		System.out.println(DayOfWeek.getDayOfWeek(0).toString(3));
		
		System.out.println(d3.toString());
	}
	
	public static void SortDates(ArrayList<Date> l)
	{
		l.sort((Date a, Date b) -> {
			return a.compareTo(b);
		});
	}
}
