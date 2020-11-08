package oop.classes.CalendarPanel.tests;


import java.time.LocalDateTime;

import oop.classes.CalendarPanel.models.CalendarPanel;
import oop.classes.Date.models.Date;
import oop.classes.Reminder.models.Reminder;
import oop.classes.event.models.Event;

public class CalendarPanelTest {

	public static void main(String[] args) {
Reminder reminder = new Reminder();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		Date currentDate = new Date(localDateTime.getDayOfMonth(),
				localDateTime.getMonthValue(),
				localDateTime.getYear());
		
		Date momsBirthday = new Date(30, 11, 2020);
		
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
		
		CalendarPanel calendarPanel = new CalendarPanel();
		Date date = new Date(0, 0, 8, 8, 11, 2020);
		Date date2 = new Date(0, 0, 7, 30, 11, 2020);
		date2.setDayOfWeek(date2.whichDayOfWeek());
		calendarPanel.setFirstMonthDay(date);
		
		calendarPanel.addEvent(new Event(date2, "dsds"));
		calendarPanel.addEvents(eventsAtMomsBirthday);
	}

}
