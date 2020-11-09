package oop.classes.CalendarPanel.models;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import oop.classes.Date.enums.DateCompare;
import oop.classes.event.models.Event;

public class EventCalendarCell
{
	public static int PANEL_WIDTH = 100;
	public static int PANEL_HEIGHT= 100;
	public static int EVENT_HEIGHT = 20;
	
	private JPanel panel;
	private Rectangle panelRectangle;
	private ArrayList<Event> events;
	private JTextArea eventTextArea;
	
	public EventCalendarCell(int x, int y)
	{
		events = new ArrayList<Event>();
		initializeRectangle();
		setX(x);
		setY(y);
		initializePanel();
		this.panel.setBackground(Color.gray);
		initializeTextArea();
	}
	
	private void initializePanel()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		setPanel(this.panelRectangle.x, this.panelRectangle.y, this.panelRectangle.width, this.panelRectangle.height);
	}

	private void initializeRectangle()
	{
		this.panelRectangle = new Rectangle();
		this.panelRectangle.x = 0;
		this.panelRectangle.y = 0;
		this.panelRectangle.width = PANEL_WIDTH;
		this.panelRectangle.height = PANEL_HEIGHT;
	}
	
	private void setX(int x)
	{
		//TODO: validation
		
		this.panelRectangle.x = x;
	}
	
	private void setY(int y)
	{
		//TODO: validation
		
		this.panelRectangle.y = y;
	}
	
	public int getX()
	{
		return this.panelRectangle.x;
	}

	public int getY()
	{
		return this.panelRectangle.y;
	}
	
	private void initializeTextArea()
	{
		this.eventTextArea = new JTextArea();
		this.eventTextArea.setBounds(new Rectangle(5, 20, 90, 75));
	}
	
	public void setPanel(int x, int y, int width, int height)
	{
		//TODO: validation
		
		this.panel.setBounds(x, y, width, height);
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
	
	public void setVisible(boolean isVisible)
	{
		this.panel.setVisible(isVisible);
	}
	
	public void addDayLabel(int day)
	{
		addLabel(Integer.toString(day), new Rectangle(40, 5, 20, 10), Color.lightGray);
	}
	
	private void appendEventTextArea(String text)
	{
		this.eventTextArea.append(text);
		if(!this.eventTextArea.getText().isEmpty() && !this.eventTextArea.isShowing())
		{
			this.panel.add(eventTextArea);
		}
	}
	
	public void addEvent(Event event)
	{
		this.events.add(event);
		appendEventTextArea(event.getName() + "\n");
	}
	
	private void addLabel(String text, Rectangle rect, Color color)
	{
		JLabel lbl = new JLabel();
		lbl.setText(text);
		lbl.setBounds(rect);
		
		if(color != null)
		{			
			this.panel.setBackground(color);
		}
		this.panel.add(lbl);
	}
	
	public void removeEvent(int at)
	{
		this.events.remove(at);
		setEventTextAreaWithAvailableEvents();	
	}
	
	public void removeEvent(Event event)
	{
		//TODO: see if can be optimized
		
		for(int i = 0; i < this.events.size(); i++)
		{
			if(this.events.get(i).getName().equals(event.getName())) //Don't know better way
			{
				if(this.events.get(i).getDate().compareTo(event.getDate(), DateCompare.DateTime) == 0) //same
				{
					this.events.remove(i);
				}
			}
		}
		
		setEventTextAreaWithAvailableEvents();
	}
	
	private void setEventTextAreaWithAvailableEvents() //Awful name
	{
		//TODO: see if can be optimized
		
		this.eventTextArea.setText("");
		
		for(int i = 0; i < this.events.size(); i++)
		{
			this.eventTextArea.append(this.events.get(i).getName() + "\n");
		}
	}
}