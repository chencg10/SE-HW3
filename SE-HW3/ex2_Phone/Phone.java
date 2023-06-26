package ex2_Phone;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.time.*;

// ------------------------ Team 8 ------------------------
//Members:
// 1. 208955732 - Chen Cohen Gershon
// 2. 208010785 - Shoham Galili
// 3. 213486764 - Hadas Yosef-Zada
// 4. 207812421 - Avidan Menashe
//---------------------------------------------------------


public class Phone {
    //members:
    private SMS _smsApp;
    private PhoneBook _phoneBook;
    private MediaList _mediaApp;
    private DailyPlanner _plannerAPP;
    //need to add shoam's & hadas's app

    //constructor:
    public Phone() {
        this._phoneBook = new PhoneBook();
        this._smsApp = new SMS(this._phoneBook);
        this._mediaApp = new MediaList();
        this._plannerAPP = new DailyPlanner();
        //need to add shoam's & hadas's app
    }


    //build menu:
    public void mainSysMenu()
    {
        while (true) {
            //ask the user to choose an app
            System.out.println("~~~~~~~Phone System~~~~~~~");
            System.out.println("Hello User! Please enter your choice:");
            System.out.println("1. Main menu of phone");
            System.out.println("2. Print Apps content");
            System.out.println("3. Exit");
            //get the user's choice
            int choice = getInt(1, 3);
            //check if the user wants to exit
            if (choice == 3) {
                System.out.println("Bye Bye!");
                break;
            }
            else {
                //check the user's choice
                switch (choice) {
                    case 1:
                        //call the main menu
                        this.mainMenu();
                        break;
                    case 2:
                        //call the print apps content
                        this.printAppsContent();
                        break;
                    default:
                        //wrong input
                        System.out.println("Wrong input! Please try again");
                        this.mainSysMenu();
                        break;
                }
            }
        }
    }

    public static int getInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            while (choice < min || choice > max) {
                System.out.println("Wrong input! Please try again");
                choice = scanner.nextInt();
            }
            return choice;
        }
        catch (Exception e) {
            System.out.println("Your input is not a number! Please try again");
            return getInt(min, max);
        }
    }

    private void mainMenu() {
        while (true) {
            //present the 4 apps in our phone
            System.out.println("~~~~~~~Main Menu~~~~~~~");
            System.out.println("Please choose an app:");
            System.out.println("1. Phone Book");
            System.out.println("2. SMS");
            System.out.println("3. Calendar");
            System.out.println("4. Media");
            System.out.println("5. Back to main menu");
            //get the user's choice
            int choice = getInt(1, 5);
            //check if the user wants to exit
            if (choice == 5) {
                break;
            }
            else {
                //check the user's choice
                switch (choice) {
                    case 1:
                        //call the phone book
                        this._phoneBook.phoneBookMenu();
                        break;
                    case 2:
                        //call the SMS
                        this._smsApp.smsMenu();
                        break;
                    case 3:
                        //call the calendar
                        this.calendarMenu();
                        break;
                    case 4:
                        //call the media
                        this._mediaApp.mediaMenu();
                        break;
                }
            }
        }
    }

    @SuppressWarnings("unused")
	public void calendarMenu()
    {
    	 Scanner scanner = new Scanner(System.in);

         while (true) {
             System.out.println("Diary App Menu:");
             System.out.println("1. Add an event");
             System.out.println("2. Delete an event");
             System.out.println("3. Print events by date");
             System.out.println("4. Print meetings by contact");
             System.out.println("5. Check event collisions");
             System.out.println("6. Print all events");
             System.out.println("7. Back to main menu");

             System.out.print("Enter your choice: ");
             int choice = scanner.nextInt();
             scanner.nextLine(); //scann the next line

             switch (choice) {
                 case 1:
                	 //Add an event
                     System.out.println("Enter event type (1 for meeting event, 2 for non-meeting event): ");
                     int eventType = scanner.nextInt();
                     if(eventType != 1 && eventType != 2)
                     {
                    	 System.out.println("Invalid event type. Please try again");
                    	 calendarMenu();
                     }
                     scanner.nextLine(); //scan the next line

                     System.out.print("Enter event date (yyyy MM dd HH mm): ");
                     int year = scanner.nextInt();
                     //get the current year

                     if(year<1000 || year>9999)
                     {
                    	 System.out.println("Invalid year. Please try again");
                    	 calendarMenu();
                     }
                     int month = scanner.nextInt();
                     if(month<1 || month>12)
                     {
                    	 System.out.println("Invalid month. Please try again");
                    	 calendarMenu();
                     }
                     int day = scanner.nextInt();
                     if(day<1 || day>60)
                     {
                    	 System.out.println("Invalid day. Please try again");
                    	 calendarMenu();
                     }
                     int hour = scanner.nextInt();
                     if(hour<1 || hour>12)
                     {
                    	 System.out.println("Invalid hour. Please try again");
                    	 calendarMenu();
                     }
                     int minutes = scanner.nextInt();
                     if(minutes<0 || minutes>60)
                     {
                    	 System.out.println("Invalid minutes. Please try again");
                    	 calendarMenu();
                     }
                     scanner.nextLine(); //scan the next line
                     Calendar calendar = Calendar.getInstance();
                     calendar.set(year, month, day, hour, 0, 0); 
                     Date date = calendar.getTime();
                     System.out.print("Enter event time in minutes (0-60): ");
                     int eventTime = scanner.nextInt();
                     if(eventTime<0 || eventTime>60)
                     {
                    	 System.out.println("Invalid event time. Please try again");
                    	 calendarMenu();
                     }
                    	 
                     scanner.nextLine(); //scan the next line
                     if (eventType == 1) 
                     {
                         System.out.print("Enter contact name: ");
                         String contactName = scanner.nextLine();
                         Contact contact = this._phoneBook.searchContactByNameForCalander(contactName);
                         if(contact == null)
                        	 break;
                         
                         if(contact != null)
                         {
                        	 Event meeting = new MeetingEvent(date, eventTime, contact);
                             this._plannerAPP.addEvent(meeting);
                         }
                         
                     } 

                     else if (eventType == 2) 
                     {
                         System.out.print("Enter event description: ");
                         String description = scanner.nextLine();
                         Event nonMeeting = new NotMeetingEvent(date, eventTime, description);
                         this._plannerAPP.addEvent(nonMeeting);
                    
                     }
                     break;
                     
                     
                 case 2:
                     System.out.print("Enter the index of the event to delete: ");
                     int indexToDelete = scanner.nextInt();
                     this._plannerAPP.deleteEvent(indexToDelete);
                     break;
                     
                     
                 case 3:
                     System.out.print("Enter the date to print events (yyyy MM dd HH mm): ");
                     int year2 = scanner.nextInt();
                     int month2 = scanner.nextInt();
                     int day2 = scanner.nextInt();
                     int hour2 = scanner.nextInt();
                     int minutes2 = scanner.nextInt();
                     scanner.nextLine(); //scann the next line
                     Calendar calendar2 = Calendar.getInstance();
                     calendar2.set(year2, month2, day2,hour2,minutes2); 
                     Date date2 = calendar2.getTime();
                     // Parse the date from the input string

                     this._plannerAPP.printEventsByDate(date2);
                     break;
                     
                 case 4:
                     System.out.print("Enter the contact person's name to print meetings: ");
                     String contactName2 = scanner.nextLine();
                     Contact contact = new Contact(this._phoneBook.searchContactByNameForCalander(contactName2));
                     if(contact == null)
                    	 this.calendarMenu();
                     this._plannerAPP.printMeetingsByContact(contact);
                     break;
                     
                 case 5:
                	 this._plannerAPP.checkCollisions();
                     break;
                     
                 case 6:
                	 this._plannerAPP.printAllEvents();
                     break;
                     
                 case 7:
                	 mainMenu();
                     break;
                     
                 default:
                     System.out.println("Invalid choice. Please try again.");
                     calendarMenu();
             }
             System.out.println(); // Add a new line for separation
         }
     }
    
    
    private void printAppsContent() {
        //call all the printing methods of the apps
        System.out.println("~~~~~~~Apps Content~~~~~~~");
        System.out.println("Phone Book:");
        System.out.println(this._phoneBook);
        System.out.println("SMS:");
        System.out.println(this._smsApp);
        System.out.println("Media:");
        this._mediaApp.activateAllMedia();
        System.out.println("Calander:");
        this._plannerAPP.printAllEvents();
    }


}