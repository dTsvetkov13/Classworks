package oop.classes.CalendarPanel.models;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.jdi.event.EventSet;

import oop.classes.Date.models.Date;
import oop.classes.event.models.Event;

public class CalendarPanel
{
	static private int MARGIN_BETWEEN_TWO_CELLS = 10; //TODO: decide whether to be percent 
	static private int MARGIN_TO_THE_BORDER = 20;
	
	private JFrame window;
	private Date firstMonthDay;
	final private int cols = 7;
	private int rows;
	private EventCalendarCell[][] cells;
	
	public CalendarPanel()
	{
		windowInit();
		rows = 0;
	}
	
	//Constructor for a date of the month
	public CalendarPanel(Date date) 
	{
		super();
		setFirstMonthDay(date);
		setCells();
	}
	
	private void windowInit()
	{
		window = new JFrame();
		
		setWindowBounds(0, 0, 800, 800);
		
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setWindowBounds(int x, int y, int width, int height)
	{
		if(width < 0 || height < 0 || x < 0 || y < 0) //TODO: maybe a check if they upper the screen's bounds
		{
			throw new RuntimeException("Invalid data");
		}
		
		window.setBounds(x, y, width, height);
	}
	
	private void setCells()
	{
		cells = new EventCalendarCell[rows][cols];
		
		int index = 0;
		
		for(; index < this.firstMonthDay.getDayOfWeek().ordinal(); index++)
		{
			addEventCalendarCell(0, index);
		}
		
		int day = 1;
		
		for(int i = 0; i < rows; i++)
		{
			if(i != 0)
			{
				index = 0;
			}
			for(; index < cols; index++)
			{
				addEventCalendarCell(i, index);
				cells[i][index].addDayLabel(day);
				
				day++;
				
				if(day > this.firstMonthDay.maxMonthDay(this.firstMonthDay.getMonth()))
				{
					index++;
					break;
				}
			}
		}
		
		for(; index < cols; index++)
		{
			addEventCalendarCell(rows - 1, index);
		}
		
		window.setVisible(true);
	}
	
	private void addEventCalendarCell(int row, int col)
	{
		cells[row][col] = new EventCalendarCell(
						MARGIN_TO_THE_BORDER + col * (EventCalendarCell.PANEL_WIDTH + MARGIN_BETWEEN_TWO_CELLS),
						row * (EventCalendarCell.PANEL_HEIGHT + MARGIN_BETWEEN_TWO_CELLS));
		cells[row][col].setVisible(true);
		window.add(cells[row][col].getPanel());
	}
	
	public void setFirstMonthDay(Date date)
	{
		if(date == null)
		{
			throw new RuntimeException("Date is null");
		}
		
		if(date.getDay() == 1)
		{
			this.firstMonthDay = date;
			date.setDayOfWeek(date.whichDayOfWeek());
		}
		else
		{
			date.setDay(1);
			date.setDayOfWeek(date.whichDayOfWeek());
			
			this.firstMonthDay = date;
		}
		
		int tempRows = (date.getDayOfWeek().ordinal() + date.maxMonthDay(date.getMonth())) / 7;
		
		if((date.getDayOfWeek().ordinal() + date.maxMonthDay(date.getMonth())) % 7 != 0)
		{
			tempRows++;
		}
		
		setRows(tempRows);
	}
	
	private void setRows(int rows)
	{
		if(rows < 0)
		{
			throw new RuntimeException("Rows cannot be negative number");
		}
		
		this.rows = rows;
		setCells();
	}
	
	public int getRows()
	{
		return this.rows;
	}
	
	public Date getFirstMonthDay()
	{
		return this.firstMonthDay;
	}
	
	public void addEvent(Event event)
	{	
		if(event == null)
		{
			throw new RuntimeException("Event is null");
		}
		
		int col = event.getDate().getDayOfWeek().ordinal();
		int row = (this.firstMonthDay.getDayOfWeek().ordinal() + event.getDate().getDay() - 1) / 7;
		System.out.println("Add event: " + event.toString());
		this.cells[row][col].addEvent(event);
	}
	
	public void addEvents(Event[] events)
	{
		for(Event event : events)
		{
			addEvent(event);
		}
	}
}
