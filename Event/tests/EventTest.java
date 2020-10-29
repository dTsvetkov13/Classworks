package oop.classes.event.tests;

import oop.classes.Date.models.Date;
import oop.classes.event.models.Event;

public class EventTest {

	public static void main(String[] args) {
		Date date = new Date(0, 0, 23, 20, 10, 2020);
		
		Event event;
		
		//event = new Event(date, ""); //Test empty name
		//event = new Event(date, null); //Test null name
		//event = new Event(null, "Homework"); //Test null Date
		
		event = new Event(date, "Homework"); //Working test
		
		System.out.println(event.toString());
	}

}
