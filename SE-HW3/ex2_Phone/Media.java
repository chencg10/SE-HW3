package ex2_Phone;

//For using strings in Java
import java.lang.String;


// ------------------------ Team 8 ------------------------
//Members:
// 1. 208955732 - Chen Cohen Gershon
// 2. 208010785 - Shoham Galili
// 3. 213486764 - Hadas Yosef-Zada
// 4. 207812421 - Avidan Menashe
//---------------------------------------------------------


public class Media {
	
	//define members
    private String _name;
    private float _length;
    private String _type;
    private Media _nextMedia;
    private Media _previousMedia;
    
    
    // Constructor
    public Media(String name, float length, String type) {
        // update the name and phone number
        this._name = name;
        this._length = length;
        this._type = type;
        // set the next node to null
        this._nextMedia = null;
        // set the previous node to null
        this._previousMedia = null;
    }

    // Constructor
    public Media(String name, float length, String type, Media nextMedia, Media previousMedia) {
        // update the name and phone number
        this._name = name;
        this._length = length;
        this._type = type;
        // set the next node to nextMedia
        this._nextMedia = nextMedia;
        // set the previous node to previousMedia
        this._previousMedia = previousMedia;
    }

    // Copy Constructor
    public Media(Media other) {
        // copy the name and phone number
        this._name = other.getName();
        this._length = other.getLength();
        this._type = other.getType();
        // copy also the next node and previous node
        this._nextMedia = other.getNextNode();
        this._previousMedia = other.getPreviousNode();
    }

    @Override //The method activate a media:
    public String toString() {
        
    	if( this._type.compareTo("song") == 0 || this._type.compareTo("Song") == 0 ) {
        	return this._name + " is now playing for " +this._length +" minutes";
    	}
    	
     	if( this._type.compareTo("video") == 0 || this._type.compareTo("Video") == 0 ) {
        	return this._name + " is now showing for " +this._length +" minutes";
    	}
     	
     	else {
     		return "ERROR: The type you entered is not valid";
     	}
    }

    
    // Getters and Setters
    public String getName() {return this._name;}

    public void setName(String name) {this._name = name;}

    public float getLength() {return this._length;}

    public void setLength(float length) {this._length = length;}
    
    public String getType() {return this._type;}

    public void setType(String type) {this._type = type;}

    public Media getNextNode() {return this._nextMedia;}

    public void setNextNode(Media nextMedia) {this._nextMedia = nextMedia;}

    public Media getPreviousNode() {return this._previousMedia;}

    public void setPreviousNode(Media previousMedia) {this._previousMedia = previousMedia;}

	
}