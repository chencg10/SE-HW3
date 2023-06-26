package ex2_Phone;

import java.util.Date; //using the Date library of java
import java.lang.String; //using strings in Java
// ------------------------ Team 8 ------------------------
//Members:
// 1. 208955732 - Chen Cohen Gershon
// 2. 208010785 - Shoham Galili
// 3. 213486764 - Hadas Yosef-Zada
// 4. 207812421 - Avidan Menashe
//---------------------------------------------------------


public class NotMeetingEvent extends Event{
	//this class is extends from Event class
	
	//define members
	private String _description;
	
	//constructor:
    public NotMeetingEvent(Date date, int eventTime, String description) 
    {
        super(date, eventTime);//making 'this' to be an event by super()
        this._description = description;
    }
    
    //Copy Constructor
    public NotMeetingEvent(NotMeetingEvent otherNotMeetingEvent)
    {
    	//making 'this' to be an event by super()
    	super(otherNotMeetingEvent.getDate(), otherNotMeetingEvent.getEventTime()); 
    	this._description = otherNotMeetingEvent.getDescription();
    }
    
    //get:
    public String getDescription() 
    {
        return _description;
    }

    //set:
    public void setDescription(String description)
    {
    	this._description = description;
    }
    
    
    @Override
    //this function is for checking if there is a collision between two events.
    public boolean collidesWith(Event otherEvent) {
        //events without meeting can't collides!
        return false;
    }

    @Override
    public String toString() {
        return "Event details: [date=" + this.getDate() + ", event time=" + this.getEventTime() + ", description=" + this.getDescription() + "]";
    }

	
	
}
