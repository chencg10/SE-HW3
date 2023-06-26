package ex2_Phone;

import static ex2_Phone.Phone.getInt;
import static ex2_Phone.PhoneBook.checkInput;

import java.util.ArrayList;
import java.util.Scanner;

// ------------------------ Team 8 ------------------------
//Members:
// 1. 208955732 - Chen Cohen Gershon
// 2. 208010785 - Shoham Galili
// 3. 213486764 - Hadas Yosef-Zada
// 4. 207812421 - Avidan Menashe
//---------------------------------------------------------



public class MediaList {

	// create an array list of nodes for the linked list of Media
    private ArrayList<Media> _media;
    

    // Default Constructor
    public MediaList() {
        // initialize the array list
        this._media = new ArrayList<Media>();
    }

    // constructor with a name, length and type
    public MediaList(String name, float length, String type)
    {
        this._media = new ArrayList<Media>();
        this._media.add(new Media(name, length, type));
    }

    // constructor with a node
    public MediaList(Media newMedia)
    {
        this._media = new ArrayList<Media>();
        this._media.add(new Media(newMedia));
    }
//############################################################################################################
    
    public MediaList(MediaList mediaList) {
        // initialize the array list
        this._media = new ArrayList<Media>();
        // copy the nodes
        for (Media media : mediaList._media)
        {
            this._media.add(new Media(media));
        }
    }
    
//############################################################################################################
    
    public void mediaMenu() {
        while (true) {
            //this is the Media menu
            System.out.println("~~~~~~~Media System~~~~~~~");
            System.out.println("Hello User! Please enter your choice:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Add media");
            System.out.println("2. Activate media by name");
            System.out.println("3. Activate all media of both types");
            System.out.println("4. Back to main menu");
 
            //get the user's choice
            int choice = getInt(1, 4);
            //check if user wants to exit:
            if (choice == 4) {
                break;
            }
            else
            {
                //check the user's choice
                switch (choice) {
                    case 1: //-------------Add Media:-------------
                        //get the media name
                        System.out.println("Please enter the name of the media:");
                        String mediaName1 = scanner.nextLine();
                        //check if the name is valid
                        mediaName1 = checkInput(mediaName1, "[\\w\\s]*", scanner);
                        
                        //get the media length
                        float length1 =0;
                        System.out.println("Please enter the length of the media: [minutes.seconds]");
	                    if (scanner.hasNextFloat()) {
		                    length1 = scanner.nextFloat();
                            //check if the length is valid
                            if (length1 < 0) {
                                System.out.println("ERROR: The length you entered is not valid. Please enter a positive number.");
                                break;
                            }
		                    scanner.nextLine(); // consume the newline character
	                    } 
	                    else {
	                        System.out.println("ERROR: The length you entered is not valid. Please enter a float number.");
	                        break;
	                    }
                        
                        //get the media type
                        System.out.println("Please enter the type of the media: [song/video]");
                        String type1 = scanner.nextLine();
                        //check if the type is valid
                        type1 = checkInput(type1, "[a-zA-Z]+", scanner);
                        
                        //check the type syntax:
                        if( type1.compareTo("song") == 0 || type1.compareTo("Song") == 0 || type1.compareTo("video") == 0 || type1.compareTo("Video") == 0 ) {
                        	 Media newMedia = new Media(mediaName1, length1, type1);
                             this.addMedia(newMedia);
                             break;
                		}
                        else {
                			System.out.println("ERROR: The type you entered is not valid.");
                			break;
                        }
                        
                    case 2: //-------------Activate media by name:-------------
                        System.out.println("Please enter the name of the media you want to activate");
                        String mediaName2 = scanner.nextLine();
                        this.activateMediaByName(mediaName2);
                        break;
                        
                    case 3: //-------------Activate all media:-------------
                        this.activateAllMedia();
                        break;
                }
            }
        }
    }   

    // add a node to the linked list
    public void addMedia(Media newMedia)
    {
        this._media.add(new Media(newMedia));
    }
    
  //############################################################################################################

    //this method is activating media by name. In case of duplicates names --> one of them will activated
    public void activateMediaByName(String name) {
    	//check if the list is empty
        if (this._media.size() == 0) {
        	System.out.println("THE MEDIA IS EMPTY, NOTHING TO ACTIVATE");
        	return;
        }
        
        for (Media media : this._media) {
            if (media.getName().equals(name)) {
            	System.out.println(media.toString());
                return;
            }
        }
        System.out.println("Media not found");
    }
    
    //############################################################################################################

    //the method activate all media of both types
    public void activateAllMedia() {
        //check if the list is empty
        if (this._media.size() == 0)
        	System.out.println("THE MEDIA IS EMPTY, NOTHING TO ACTIVATE");

        String str = "";
        int counter = 1;
        for (Media media : this._media)
        {
            str += "This node is the:  " + counter + "th media\n" +
                    media.toString() + "\n----------\n";
            System.out.println(str);
            counter++;
            str = "";
        }
    }

}