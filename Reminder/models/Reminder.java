package oop.classes.Reminder.models;

import java.time.LocalDateTime;

import oop.classes.Date.models.Date;
import oop.classes.event.models.Event;

public class Reminder
{
	private static int eventsSize = 30;
	
	private Event[] events;
	private int eventIndex;
	
	//Default
	public Reminder()
	{
		events = new Event[eventsSize];
		eventIndex = 0;
	}
	
	public void addEvent(Event newEvent)
	{
		if(newEvent == null)
		{
			throw new RuntimeException("Event is null");
		}
		
		if(eventIndex >= eventsSize)
		{
			throw new RuntimeException("The array of events is full");
		}
		
		events[eventIndex] = newEvent;
		eventIndex++;
	}
	
	public Event[] getAllEventsAt(Date date)
	{
		if(date == null)
		{
			throw new RuntimeException("Date is null");
		}
		
		int resultSize = 0;
		
		Date temp;
		
		for(int i = 0; i < eventIndex; i++)
		{
			temp = events[i].getDate(); 
			
			if(onTheSameDay(temp, date))
			{
				resultSize++;
			}
		}
		
		Event[] result = new Event[resultSize];
		
		int index = 0;
		
		for(int i = 0; i < eventIndex; i++)
		{
			temp = events[i].getDate();
			
			if(onTheSameDay(temp, date))
			{
				result[index] = events[i];
				index++;
			}
		}
		
		return result;
	}
	
	private boolean onTheSameDay(Date d1, Date d2)
	{
		if(d1.getYear() == d2.getYear())
		{
			if(d1.getMonth() == d2.getMonth())
			{
				if(d1.getDay() == d2.getDay())
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void remind()
	{
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date currentDate = new Date(localDateTime.getDayOfMonth(),
									localDateTime.getMonthValue(),
									localDateTime.getYear());
		
		Event[] currentEvent = getAllEventsAt(currentDate);
		
		System.out.println("Events today:");
		
		for(Event event : currentEvent)
		{
			System.out.println(event.toString());
		}
	}
}
