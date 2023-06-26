package ex2_Phone;

import java.util.Date; //using the Date library of java
import java.lang.String;//using strings in Java

// ------------------------ Team 8 ------------------------
//Members:
// 1. 208955732 - Chen Cohen Gershon
// 2. 208010785 - Shoham Galili
// 3. 213486764 - Hadas Yosef-Zada
// 4. 207812421 - Avidan Menashe
//---------------------------------------------------------

public abstract class Event {
 //this class is abstract because we don't use his objects.
	
	//define members
	private Date _date;
	private int _eventTime;
	
	//constructor:
	public Event(Date date ,int eventTime)
	{
		this._date = date;
		this._eventTime = eventTime;
	}
	
	// Copy Constructor
	public Event(Event other)
	{
		this._date = other.getDate();
		this._eventTime = other.getEventTime();
	}
	
	//gets:
	public Date getDate()
	{
		return this._date;
	}
	public int getEventTime()
	{
		return this._eventTime;
	}
	
	//sets:
	public void setDate(Date date)
	{
		this._date = date;
	}
	public void setEventTime(int eventTime)
	{
		this._eventTime = eventTime;
	}
	
	//this function is for checking if there is a collision between two events.
	//this function is abstract because we don't need to use him in this class
	 public abstract boolean collidesWith(Event otherEvent);
	 
	 //overRide on the toString function of Object class.
	 //this function is abstract because we don't need to use him in this class
	 @Override
	 public abstract String toString();


}
