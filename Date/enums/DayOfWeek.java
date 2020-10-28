package oop.classes.Date.enums;

public enum DayOfWeek
{
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday,
	
	DayOfWeek();
	
	public String toString()
	{
		return this.name();
	}
	
	public String toString(int numberOfLetters)
	{
		if(this.name().length() < numberOfLetters || numberOfLetters < 0)
		{
			throw new RuntimeException("DayOfWeek toString(int)");
		}
		
		return toString().substring(0, numberOfLetters);
	}
	
	public static DayOfWeek getDayOfWeek(int value)
	{
		switch(value)
		{
			case(0):
			{
				return Monday;
			}
			case(1):
			{
				return Tuesday;
			}
			case(2):
			{
				return Wednesday;
			}
			case(3):
			{
				return Thursday;
			}
			case(4):
			{
				return Friday;
			}
			case(5):
			{
				return Saturday;
			}
			case(6):
			{
				return Sunday;
			}
			default:
			{
				throw new RuntimeException("getDayOfWeek - Invalid value!");
			}
		}
	}
}
