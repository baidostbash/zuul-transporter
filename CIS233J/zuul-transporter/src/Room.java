import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * Rooms now can contain one item.
 * 
 * @author  Sam Shokrollahi
 * @version 2017.10.12
 */
public class Room 
{
    public String description;
    private HashMap<String, Room> exits;
    private Item item;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description the room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>(); 
    }

    /**
     * Defalut constructor
     */
    public Room()
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null.
     * @param directiont The room's directiont.
     * @param neighbor the neighboring room.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor); 
    }

    /**
     * @param direction.
     * @return the selected exit. 
     */
    public Room getExit(String direction)
    {
        return exits.get(direction); 
    }
    
    /*** 
     * @return directions of the available exits
     */ 
    public String getExitString()   
    
    {
        String directions = "Exits:";
        
        Set<String> keys = exits.keySet(); 
        
        for(String exit: keys) {
            directions += " " + exit;
        }
        
        return directions;
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return A description of the room, including exits.
     */ 
    public String getLongDescription()
    { String returnString;
        returnString =  "You are " + description + ". ";
        if(item != null) {
            returnString += "There is a " + item.getDescription() + " here.";
        }
        
        returnString +=  "\n" + getExitString(); 
        return returnString; 
    }
    
    /**
     * Create item in the room.
     * @param description and weight.
     */
    public void addItem(String description, double weight)
    {
         item = new Item(description, weight);
    }
    
}
