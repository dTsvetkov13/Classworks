package oop.classes;

public class Date
{	
	private int seconds;
	private int minutes;
	private int hours;
	private int day; 
	private int month;
	private int year;

	//Default
	Date()
	{
		seconds = 0;
		minutes = 0;
		hours = 0;
		day = 1;
		month = 1;
		year = 0;
	}
	
	//A constructor to set all fields
	Date(int seconds, int minutes, int hours, int day, int month, int year)
	{
		ValidateInRange(seconds, 0, 60);
		this.seconds = seconds;
		
		ValidateInRange(minutes, 0, 60);
		this.minutes = minutes;
		
		ValidateInRange(hours, 0, 24);
		this.hours = hours;
		
		ValidateInRange(month, 1, 13);
		this.month = month;
		
		//First check the month, because the validation of the day will not work
		ValidateDay(day);
		this.day = day;
		
		//Year does not need validation
		this.year = year;
	}
	
	//A constructor for the beginning of a day 
	Date(int day, int month, int year)
	{
		this(0, 0, 0, day, month, year);
	}
	
	//Setters
	void SetSeconds(int seconds) { this.seconds = seconds; }
	void SetMinutes(int minutes) { this.minutes = minutes; }
	void SetHours(int hours) { this.hours = hours; }
	void SetDay(int day) { this.day = day; }
	void SetMonth(int month) { this.month = month; }
	void SetYear(int year) { this.year = year; }
	
	//Getters
	int GetSeconds() { return this.seconds; }
	int GetMinutes() { return this.minutes; }
	int GetHours() { return this.hours; }
	int GetDay() { return this.day; }
	int GetMonth() { return this.month; }
	int GetYear() { return this.year; }
	
	private void ValidateInRange(int value, int from, int to)
	{
		if(value < from || value >= to) throw new RuntimeException();
	}
	
	private void ValidateDay(int value)
	{
		int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(IsLeap()) maxMonthDays[1] = 29;
		
		if(value <= 0 || value > maxMonthDays[this.month - 1]) throw new RuntimeException();
	}
	
	int CompareTo(Date d)
	{
		int result = 0;
		result = CompareInts(this.year, d.GetYear());
		if(result == 0)
		{
			result = CompareInts(this.month, d.GetMonth()); 
			if(result == 0)
			{
				result = CompareInts(this.day, d.GetDay()); 
				if(result == 0)
				{
					result = CompareInts(this.hours, d.GetHours()); 
					if(result == 0)
					{
						result = CompareInts(this.minutes, d.GetMinutes()); 
						if(result == 0)
						{
							result = CompareInts(this.seconds, d.GetSeconds()); 
							if(result == 0)
							{
								return 0;
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	private int CompareInts(int a, int b)
	{
		if(a > b)
		{
			return 1;
		}
		else if(b > a)
		{
			return -1;
		}
		else return 0;
	}
	
	void AddSecond()
	{
		this.seconds++;
		if(this.seconds == 60)
		{
			this.seconds = 0;
			this.minutes++;
			
			if(this.minutes == 60)
			{
				this.minutes = 0;
				this.hours++;
				
				if(this.hours == 24)
				{
					this.hours = 0;
					this.day++;
					
					if(day > MaxMonthDay(month))
					{
						this.day = 1;
						this.month++;
						if(month > 12)
						{
							this.year++;
							this.month = 1;
						}
					}
				}
			}
		}
	}
	
	public boolean IsLeap()
	{
		if(year % 4 == 0)
		{
			if(year % 100 == 0)
			{
				if(year % 400 == 0) return true;
				else return false;
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private int MaxMonthDay(int month)
	{
		int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(IsLeap()) maxMonthDays[1] = 29;
		
		return maxMonthDays[month - 1];
	}
	
	public int DayOfTheYear()
	{
		int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(IsLeap()) maxMonthDays[1] = 29;
		
		int result = 0;
		
		for(int i = 0; i < month - 1; i++)
		{
			result += maxMonthDays[i];
		}
		
		result += this.day;
		
		return result;
	}
	
	//In this the year starts on Monday
	public int WhichWeek()
	{
		if(DayOfTheYear() % 7 != 0)
		{
			return DayOfTheYear() / 7 + 1;
		}
		return DayOfTheYear() / 7;
	}
	
	//In this start of the year is given
	public int WhichWeek(int startDay)
	{
		if(startDay < 1 || startDay > 7) throw new RuntimeException();
		
		if((DayOfTheYear() + startDay - 1) % 7 != 0)
		{
			return (DayOfTheYear() + startDay - 1) / 7 + 1;
		}
		return (DayOfTheYear() + startDay - 1) / 7;
	}
	
	public String ToString()
	{
		return hours + ":" + minutes + ":" + seconds + " of " + day + "." + month + "." + year;  
	}
}