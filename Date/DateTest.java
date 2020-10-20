package oop.classes;

import java.util.ArrayList;

public class DateTest {

	public static void main(String[] args)
	{
		Date d1 = new Date();
		//Second January 2003
		Date d2 = new Date(2, 1, 2003);
		//Date d2 = new Date(59, 59, 23, 28, 2, 2004); - Test adding a second for leap year
		//Date d2 = new Date(59, 59, 23, 31, 12, 2004); - Test adding a second just before New Year 
		Date d3 = new Date(0, 0, 23, 20, 10, 2020);
		
		if(d2.CompareTo(d3) == 1)
		{
			System.out.println("D2 is bigger than d3!");
		}
		else if(d2.CompareTo(d3) == -1)
		{
			System.out.println("D3 is bigger than d2!");
		}
		else
		{
			System.out.println("D2 is equal to d3!");
		}
		
		if(d3.IsLeap())
		{
			System.out.println("D3 is leap!");
		}
		else
		{
			System.out.println("D3 is not leap!");
		}
		
		System.out.println("D3 is the " + d3.DayOfTheYear() + " day");
		//This week starts on Wednesday
		System.out.println("D3 is in " + d3.WhichWeek(3) + " week");
		
		d2.AddSecond();
		
		System.out.println("D2 after a second is added: " + d2.ToString());
		
		ArrayList<Date> l = new ArrayList<Date>();
		l.add(d3);
		l.add(d2);
		l.add(d1);
		l.add(d3);
		
		SortDates(l);
		
		System.out.println("Array: ");
		
		for(Date i : l)
		{
			System.out.println(i.ToString());
		}
	}
	
	public static void SortDates(ArrayList<Date> l)
	{
		l.sort((Date a, Date b) -> {
			return a.CompareTo(b);
		});
	}
}
