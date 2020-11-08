package oop.classes.CalendarPanel.models;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import oop.classes.event.models.Event;

public class EventCalendarCell
{
	public static int PANEL_WIDTH = 100;
	public static int PANEL_HEIGHT= 100;
	public static int EVENT_HEIGHT = 20;
	
	private JPanel panel;
	private Rectangle panelRectangle;
	private ArrayList<Event> events;
	
	public EventCalendarCell(int x, int y)
	{
		events = new ArrayList<Event>();
		initializeRectangle();
		setX(x);
		setY(y);
		initializePanel();
		this.panel.setBackground(Color.gray);
	}
	
	private void initializePanel()
	{
		this.panel = new JPanel();
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
	
	public void draw()
	{
		
	}
	
	public void addDayLabel(int day)
	{
		addLabel(Integer.toString(day), new Rectangle(40, 5, 20, 10), Color.lightGray);
	}
	
	public void addEvent(Event event)
	{
		events.add(event);
		addLabel(events.size() + " " + event.getName(), new Rectangle(0, events.size() * EVENT_HEIGHT, PANEL_WIDTH, EVENT_HEIGHT), null);
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
}
