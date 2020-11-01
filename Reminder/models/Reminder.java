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
			
			if(temp.getYear() == date.getYear())
			{
				if(temp.getMonth() == date.getMonth())
				{
					if(temp.getDay() == date.getDay())
					{
						resultSize++;
					}
				}
			}
		}
		
		Event[] result = new Event[resultSize];
		
		int index = 0;
		
		for(int i = 0; i < eventIndex; i++)
		{
			temp = events[i].getDate();
			
			if(temp.getYear() == date.getYear())
			{
				if(temp.getMonth() == date.getMonth())
				{
					if(temp.getDay() == date.getDay())
					{
						result[index] = events[i];
						index++;
					}
				}
			}
		}
		
		return result;
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
