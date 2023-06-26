package ex2_Phone;

import java.util.Date; //using the Date library of java
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

// ------------------------ Team 8 ------------------------
//Members:
// 1. 208955732 - Chen Cohen Gershon
// 2. 208010785 - Shoham Galili
// 3. 213486764 - Hadas Yosef-Zada
// 4. 207812421 - Avidan Menashe
//---------------------------------------------------------

public class DailyPlanner 
{
	
	//define members
	private List<Event> _diaryevents;
	
	//constructor:
    public DailyPlanner() 
    {
    	this._diaryevents = new ArrayList<>();
    }
    
    //Q1:
    //this function adds a new event to the diary:
    public void addEvent(Event event) 
    {
    	this._diaryevents.add(event);
        System.out.println("Event added successfully!");
    }
    
    //Q2:
    //this function deletes an event in the index 'index' in the diary:
    public void deleteEvent(int index) 
    {
    	//checking if the index is legal:
        if (index >= 0 && index < this._diaryevents.size()) 
        {
        	this._diaryevents.remove(index - 1);
            System.out.println("Event deleted successfully.");
        } 
        else 
        {
            System.out.println("Invalid event index.");
        }
    }

    //Q3:
    //this function prints the events in a date by order:
    public void printEventsByDate(Date date) 
    {
        System.out.println("Events on " + date.toString() + ":");
        //for loop on all the events in the diary:
        for (Event event : this._diaryevents) 
        {
        	Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(event.getDate());

            int year1 = cal1.get(Calendar.YEAR);
            int month1 = cal1.get(Calendar.MONTH);
            int day1 = cal1.get(Calendar.DAY_OF_MONTH);

            int year2 = cal2.get(Calendar.YEAR);
            int month2 = cal2.get(Calendar.MONTH);
            int day2 = cal2.get(Calendar.DAY_OF_MONTH);

            if(year1 == year2 && month1 == month2 && day1 == day2)
            {
            	if (event instanceof MeetingEvent) 
            	{
                	//down casting to MeetingEvent:
                	MeetingEvent otherMeeting = (MeetingEvent) event;
                	System.out.println("Event details: [date=" + otherMeeting.getDate() + ", event time="
                            + otherMeeting.getEventTime()
                            + ", contact=" + otherMeeting.getContact().toString() + "]");
            	}
            	else if (event instanceof NotMeetingEvent) 
            	{
                	//down casting to MeetingEvent:
            		NotMeetingEvent otherMeeting = (NotMeetingEvent) event;
                	System.out.println("Event details: [date=" + otherMeeting.getDate() + ", event time="
                            + otherMeeting.getEventTime()
                            + ", description=" + otherMeeting.getDescription() + "]");
            	}

            }
        }
    }

    //Q4:
    //this function prints the events that has the contact by order in dates:
    public void printMeetingsByContact(Contact contact) 
    {
        System.out.println("Meetings with " + contact.toString());
      //for loop on all the events in the diary:
        for (Event event : this._diaryevents) 
        {	
        	//checking if otherEvent is in the type of MeetingEvent 
        	//and if the event has this contact
            if (((MeetingEvent) event).getContact().getName() == contact.getName()) 
            {
            	//down casting to MeetingEvent:
            	MeetingEvent otherMeeting = (MeetingEvent) event;
            	System.out.println("Event details: [date=" + otherMeeting.getDate() + ", event time="
                        + otherMeeting.getEventTime() + ", contact=" + otherMeeting.getContact().toString() + "]");
            }
        }
    }

    //Q5:
    //this function is for checking if there is a collision between two events.
    //if there is, it deletes the latest event
    public void checkCollisions() 
    {
    	//going for all events and checking if there is a collision
        for (int i = 0; i < this._diaryevents.size(); i++) 
        {
            for (int j = i + 1; j < this._diaryevents.size(); j++) 
            {
                Event event1 = this._diaryevents.get(i);
                Event event2 = this._diaryevents.get(j);
                if (event1.collidesWith(event2)) 
                {
                	int compare_dates = event1.getDate().compareTo(event2.getDate());
                	if(compare_dates > 0)
                	{
                		this._diaryevents.remove(j);
                        System.out.println("Event at index " + j + " collided with event at index " + i + " and was deleted!");
                	}
                	else if(compare_dates < 0)
                	{
                		this._diaryevents.remove(i);
                        System.out.println("Event at index " + i + " collided with event at index " + j + " and was deleted!");
                	}
                	
                }
            }
        }
    }

    //Q6:
    //this function is printing all the events in the diary:
    public void printAllEvents() 
    {
        // check if calnder is empty
        if (this._diaryevents.isEmpty())
        {
            System.out.println("No events to print.");
            return;
        }
        System.out.println("All Events:");
        //for loop on all the events in the diary:
        for (Event event : this._diaryevents) 
        {
        	if (event instanceof MeetingEvent) 
        	{
            	//down casting to MeetingEvent:
            	MeetingEvent otherMeeting = (MeetingEvent) event;
            	System.out.println("Event details: [date=" + otherMeeting.getDate() +
                        ", event time=" + otherMeeting.getEventTime() + ", contact=" +
                        otherMeeting.getContact().toString() + "]");
        	}
        	else if (event instanceof NotMeetingEvent) 
        	{
            	//down casting to MeetingEvent:
        		NotMeetingEvent otherMeeting = (NotMeetingEvent) event;
            	System.out.println("Event details: [date=" + otherMeeting.getDate() +
                        ", event time=" + otherMeeting.getEventTime() + ", description=" +
                        otherMeeting.getDescription() + "]");
        	}
        }
    }
    
    

}
