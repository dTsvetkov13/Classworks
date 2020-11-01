package oop.classes.event.models;

import oop.classes.Date.models.Date;

public class Event
{
	private Date date;
	private String name;
	
	public Event()
	{
		setDate(new Date());
		setName("");
	}
	
	public Event(Date date, String name)
	{
		setDate(date);
		setName(name);
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setDate(Date date)
	{
		if(date == null)
		{
			throw new RuntimeException("Date is null in Event's constructor");
		}
		
		this.date = date;
	}
	
	public void setName(String name)
	{
		if(name == null || name.isEmpty())
		{
			throw new RuntimeException("Invalid name in Event's constructor");
		}
		
		this.name = name;
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(date.toString());
		stringBuilder.append(" - ");
		stringBuilder.append(name);
		
		return stringBuilder.toString();
	}
}
