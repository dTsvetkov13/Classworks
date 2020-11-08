package oop.classes.Date.models;

import oop.classes.Date.enums.DateCompare;
import oop.classes.Date.enums.DayOfWeek;

public class Date
{
	private static final int SECONDS_MIN_VALUE = 0;
	private static final int SECONDS_MAX_VALUE = 59;
	private static final int MINUTES_MIN_VALUE = 0;
	private static final int MINUTES_MAX_VALUE = 59;
	private static final int HOURS_MIN_VALUE = 0;
	private static final int HOURS_MAX_VALUE = 23;
	private static final int DAYS_MIN_VALUE = 1;
	private static final int MONTHS_MIN_VALUE = 1;
	private static final int MONTHS_MAX_VALUE = 12;
	private static final int YEARS_MIN_VALUE = 0;
	private static final int YEARS_MAX_VALUE = 9999;
	
	private static final int WEEK_DAYS = 7;
	
	private int seconds;
	private int minutes;
	private int hours;
	private int day; 
	private int month;
	private int year;
	private DayOfWeek dayOfWeek;
	
	//Default
	public Date()
	{
		setSeconds(0);
		setMinutes(0);
		setHours(0);
		setMonth(1);
		setDay(1);
		setYear(1);
	}
	
	//A constructor to set all fields
	public Date(int seconds, int minutes, int hours, int day, int month, int year)
	{
		setSeconds(seconds);
		setMinutes(minutes);
		setHours(hours);
		setMonth(month);
		setDay(day);
		setYear(year);
	}
	
	//A constructor for the beginning of a day 
	public Date(int day, int month, int year)
	{
		this(0, 0, 0, day, month, year);
	}
	
	//A constructor to specify the day of week
	public Date(DayOfWeek dayOfWeek)
	{
		super();
		setDayOfWeek(dayOfWeek);
	}
	
	public Date(int dayOfWeek)
	{
		super();
		this.dayOfWeek = DayOfWeek.getDayOfWeek(dayOfWeek - 1);
	}

	//Setters
	public void setSeconds(int seconds)
	{
		validateInRange(seconds, SECONDS_MIN_VALUE, SECONDS_MAX_VALUE);
		this.seconds = seconds;
	}

	public void setMinutes(int minutes)
	{
		validateInRange(minutes, MINUTES_MIN_VALUE, MINUTES_MAX_VALUE);
		this.minutes = minutes;
	}

	public void setHours(int hours)
	{
		validateInRange(hours, HOURS_MIN_VALUE, HOURS_MAX_VALUE);
		this.hours = hours;
	}

	public void setDay(int day)
	{
		validateDay(day);
		this.day = day;
	}

	public void setMonth(int month)
	{
		validateInRange(month, MONTHS_MIN_VALUE, MONTHS_MAX_VALUE);
		this.month = month;
	}

	public void setYear(int year)
	{
		validateInRange(year, YEARS_MIN_VALUE, YEARS_MAX_VALUE);
		this.year = year;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek)
	{
		if(dayOfWeek == null) throw new RuntimeException("dayOfWeek is null");
		this.dayOfWeek = dayOfWeek;
	}
	
	//Getters
	public int getSeconds()
	{
		return seconds;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public int getHours()
	{
		return hours;
	}

	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	public DayOfWeek getDayOfWeek()
	{
		return dayOfWeek;
	}
	
	private void validateInRange(int value, int from, int to)
	{
		if(value < from || value > to) throw new RuntimeException();
	}
	
	private void validateDay(int value)
	{
		int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(isLeap()) maxMonthDays[1] = 29;
		
		if(value <= 0 || value > maxMonthDays[this.month - 1]) throw new RuntimeException();
	}
	
	public int compareTo(Date date, DateCompare dateCompare)
	{
		if(date == null || dateCompare == null)
		{
			throw new RuntimeException("Null");
		}
		
		switch(dateCompare)
		{
			case Date:
			{
				return compareByDate(this, date);
			}
			case Time:
			{
				return compareByTime(this, date);
			}
			case DateTime:
			{
				return compareTo(date);
			}
			default:
			{
				return 1;
			}
		}
	}
	
	private int compareByDate(Date d1, Date d2)
	{
		int result = 0;
		result = compareInts(d1.getYear(), d2.getYear());
		if(result == 0)
		{
			result = compareInts(d1.getMonth(), d2.getMonth()); 
			if(result == 0)
			{
				result = compareInts(d1.getDay(), d2.getDay()); 
			}
		}
		
		return result;
	}
	
	private int compareByTime(Date d1, Date d2)
	{
		int result = 0;
		result = compareInts(d1.getHours(), d2.getHours());
		if(result == 0)
		{
			result = compareInts(d1.getMinutes(), d2.getMinutes()); 
			if(result == 0)
			{
				result = compareInts(d1.getSeconds(), d2.getSeconds()); 
			}
		}
		
		return result;
	}
	
	public int compareTo(Date d)
	{
		int result = 0;
		result = compareByDate(this, d);
		if(result == 0)
		{
			result = compareByTime(this, d);
		}
			
		return result;
	}
	
	private int compareInts(int a, int b)
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
	
	public void addSecond()
	{
		this.seconds++;
		if(this.seconds > SECONDS_MAX_VALUE)
		{
			this.seconds = SECONDS_MIN_VALUE;
			this.minutes++;
			
			if(this.minutes > MINUTES_MAX_VALUE)
			{
				this.minutes = MINUTES_MIN_VALUE;
				this.hours++;
				
				if(this.hours > HOURS_MAX_VALUE)
				{
					this.hours = HOURS_MIN_VALUE;
					this.day++;
					
					if(day > maxMonthDay(month))
					{
						this.day = DAYS_MIN_VALUE;
						this.month++;
						if(month > MONTHS_MAX_VALUE)
						{
							this.year++;
							this.month = MONTHS_MIN_VALUE;
						}
					}
				}
			}
		}
	}
	
	public boolean isLeap()
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
	
	public int maxMonthDay(int month)
	{
		int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(isLeap()) maxMonthDays[1] = 29;
		
		return maxMonthDays[month - 1];
	}
	
	public int dayOfTheYear()
	{
		int[] maxMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(isLeap()) maxMonthDays[1] = 29;
		
		int result = 0;
		
		for(int i = 0; i < month - 1; i++)
		{
			result += maxMonthDays[i];
		}
		
		result += this.day;
		
		return result;
	}
	
	//In this the year starts on Monday
	public int whichWeek()
	{
		if(dayOfTheYear() % WEEK_DAYS != 0)
		{
			return dayOfTheYear() / WEEK_DAYS + 1;
		}
		return dayOfTheYear() / WEEK_DAYS;
	}
	
	//In this start of the year is given
	public int whichWeek(int startDay)
	{
		if(startDay < 1 || startDay > WEEK_DAYS) throw new RuntimeException();
		
		if((dayOfTheYear() + startDay - 1) % WEEK_DAYS != 0)
		{
			return (dayOfTheYear() + startDay - 1) / WEEK_DAYS + 1;
		}
		return (dayOfTheYear() + startDay - 1) / WEEK_DAYS;
	}
	
	//Algorithm from Internet
	public DayOfWeek whichDayOfWeek()
	{
		int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		
		int currYear = this.year; 
		currYear -= this.month < 3 ? this.month : 0;
		
		return DayOfWeek.getDayOfWeek(((currYear + currYear/4 
										- currYear/100 + currYear/400 
										+ t[this.month-1] + this.day) % 7));
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(hours);
		stringBuilder.append(":");
		stringBuilder.append(minutes);
		stringBuilder.append(":");
		stringBuilder.append(seconds);
		stringBuilder.append(" of ");
		stringBuilder.append(day);
		stringBuilder.append(".");
		stringBuilder.append(month);
		stringBuilder.append(".");
		stringBuilder.append(year);
		stringBuilder.append(", ");
		stringBuilder.append(whichDayOfWeek());
		
		return stringBuilder.toString();
	}
}