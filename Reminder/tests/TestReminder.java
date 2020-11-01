package oop.classes.Reminder.tests;

import java.time.LocalDateTime;

import oop.classes.Date.models.Date;
import oop.classes.Reminder.models.Reminder;
import oop.classes.event.models.Event;

public class TestReminder
{
	//By changing the eventsSize in Reminder you can check the addEvent method,
	//i.e change it to 4 and the program will break
	
	public static void main(String[] args)
	{
		Reminder reminder = new Reminder();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date currentDate = new Date(localDateTime.getDayOfMonth(),
				localDateTime.getMonthValue(),
				localDateTime.getYear());
		
		Date momsBirthday = new Date(31, 10, 2020);
		
		reminder.addEvent(new Event(momsBirthday, "Say a Happy Birthday to her"));
		reminder.addEvent(new Event(momsBirthday, "Something"));
		reminder.addEvent(new Event(currentDate, "HomeWork"));
		reminder.addEvent(new Event(currentDate, "HomeWork"));
		reminder.addEvent(new Event(currentDate, "HomeWork"));
		
		reminder.remind();
		
		Event[] eventsAtMomsBirthday = reminder.getAllEventsAt(momsBirthday);
		
		System.out.println("Events at Mom's birthday:");
		
		for(int i = 0; i < eventsAtMomsBirthday.length; i++)
		{
			System.out.println(eventsAtMomsBirthday[i].toString());
		}
	}

}
